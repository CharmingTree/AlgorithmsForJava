package ModernJava.Async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.*;

public class Shop {

    private static Logger logger = LoggerFactory.getLogger(Shop.class);
    private static Random random = new Random();

    public static void main(String[] args) {

        //double gg = getPrice("apple01");
        long start = System.nanoTime();
        Future<Double> gg = getPriceAsync("apple01");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        logger.info("Invocation returned after : {} msecs", invocationTime);

        doSomethingElse();
        try {
            // double result = gg.get();

            // 타임아웃 추가
            //
            double result = gg.get(2000, TimeUnit.MILLISECONDS);

            logger.info("{}", result);
        }
        catch (TimeoutException e2) {
            logger.info("timeOut : {}", e2.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.info("main Exception : {}", e.getMessage());
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        logger.info("Price returned after : {} msecs", retrievalTime);
    }

    public static void doSomethingElse() {
        logger.info("current working do something else ...");
        delay();
        delay();
    }

    public static double getPrice(String product) {
        return calculatePrice(product);
    }

    public static Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                delay();
                double price = calculatePrice(product);
                //throw new Exception("임의 에러 ");

                // 타임아웃 테스트를 위해 추가
                // future의 타임아웃 조건은 future가 리턴되기 까지의 시간을 기준으로 한다. 혼동할 수 있는게 비동기가 아무리 오래걸려도 타임아웃 조건에는 걸리지 않음.
                // 즉, future가 리턴하기 까지의 시간을 기준으로만 타임아웃에 걸리기 때문.
                Thread.sleep(4000);
                futurePrice.complete(price);
            } catch (Exception e) {
                e.printStackTrace();
                futurePrice.completeExceptionally(e); // 문제가 생기면 발생 에러를 포함시켜 Future를 종료 한다.
            }
        }).start();

        logger.info("return Future ...");
        return futurePrice;
    }

    // 간편 버전
    public static Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private static double calculatePrice(String product) {
        delay();
        logger.info("calculating ...");
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(3000L);
        }catch (Exception e) {
            logger.info("{}", e.getMessage());
        }
    }
}
