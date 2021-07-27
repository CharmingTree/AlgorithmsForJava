package AlgorithmSolutionStrategy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class movingAverage {

    public static void optimizerMovingAverage(ArrayList<Double> A, int M) {
        long startTime = System.nanoTime();
        ArrayList<Double> ret = new ArrayList<>();
        int N = A.size();
        Double partialSum = 0.0;

        for (int i = 0; i < M-1; i++) {
            partialSum += A.get(i);
        }

        for (int i = M-1; i < N; i++) {
            partialSum += A.get(i);
            ret.add(Math.round((partialSum / M) * 10) / 10.0);
            partialSum -= A.get(i-M+1);
        }

        long endTime = System.nanoTime();
        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");
        System.out.println(ret);
        System.out.println(ret.size());

    }

    public static void nonOptimizerMovingAverage(ArrayList<Double> A, int M) {
        long startTime = System.nanoTime();
        ArrayList<Double> ret = new ArrayList<>();
        int N = A.size();

        for (int i = M-1; i < N; ++i) {
            Double partialSum = 0.0;

            for (int j = 0; j < M; j++) {
                partialSum += A.get(i-j);
            }
            ret.add(Math.round((partialSum / M) * 10) / 10.0);
        }
        long endTime = System.nanoTime();
        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");
        System.out.println(ret);
        System.out.println(ret.size());
    }

    public static void main(String[] args) {
        ArrayList<Double> lst = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            lst.add(Math.round((Math.random()*100) *10.0) / 10.0 );
        }

        Collections.sort(lst);

        System.out.println(lst);

        nonOptimizerMovingAverage(lst, 10);
        optimizerMovingAverage(lst, 10);
    }


}
