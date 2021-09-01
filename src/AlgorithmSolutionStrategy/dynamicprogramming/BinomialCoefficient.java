package AlgorithmSolutionStrategy.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinomialCoefficient {

    // (n, n/2) 꼴에서 n이 증가함에 따라 호출수는 2배로 급증한다. n=25일때, 10400599번 호출됨
    int bino(int n, int r) {
        if ( r == 0 || n == r)
            return 1;
        return bino(n-1, r-1) + bino(n-1, r);
    }
    static int[][] cache = new int[30][30];


    int bino2(int n, int r) {
        if (r == 0 || n == r) return 1;
        if ( cache[n][r] != -1) {
            return cache[n][r];
        }

        return cache[n][r] = bino2(n-1, r-1) + bino2(n-1, r);
    }

    public static void main(String[] args) {

        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        BinomialCoefficient binomialCoefficient = new BinomialCoefficient();



        System.out.println(binomialCoefficient.bino2(4,2));

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
    }
}
