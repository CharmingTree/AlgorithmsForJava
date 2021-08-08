package programers;

import sun.lwawt.macosx.CSystemTray;

public class RetPrice {

    public long solution(int price, int money, int count) {
        long startTime = System.nanoTime();
        long answer = 0;

        for (int i = 1; i <= count; i++) {
            answer += price * i;
        }

        answer -= money;

        long result = answer <= 0 ? 0 : answer;
        long endTime = System.nanoTime();

        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");
        return result;
    }

    public long solution2(int price, int money, int count) {
        long startTime = System.nanoTime();
        long result = Math.max(price * (count * (count + 1) / 2) - money, 0);
        long endTime = System.nanoTime();

        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");
        return result;
    }

    public static void main(String[] args) {
        RetPrice ob = new RetPrice();

        System.out.println(ob.solution2(3, 20 , 4));
        System.out.println(ob.solution(3, 20 , 4));
    }
}
