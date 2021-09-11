package AlgorithmSolutionStrategy.practice;

import java.util.Arrays;

public class PracPI {

    final static int INF = 9999999;
    static String N = "12345678";
    static int[] cache = new int[10001];

    static int classify(int a, int b) {

        // base case
        // 0 : 0, 3
        // 6 : 3, 3
        // 9 : 9, 9  / 9, 10

        if (a >= b-a+1)
            return 0;

        String M = N.substring(a, b-a+1);

        if (M.isEmpty())
            return 0;

        char[] sameness = new char[M.length()];
        Arrays.fill(sameness, M.charAt(0));

        if (M.equals(String.valueOf(sameness)))
            return 1;

        boolean isProgress = true;
        for (int i = 0; i < M.length()-1; ++i) {
            if (M.charAt(i+1)-M.charAt(i) != M.charAt(1) - M.charAt(0))
                isProgress = false;
        }

        if (isProgress && Math.abs(M.charAt(1)-M.charAt(0)) == 1)
            return 2;

        boolean isAlternate = true;

        for (int i = 0; i < M.length(); i++) {
            if (M.charAt(i) != M.charAt(i%2))
                isAlternate = false;
        }

        if (isAlternate)
            return 4;

        if (isProgress)
            return 5;

        return 10;
    }

    static int memorize(int begin) {

        if (begin == N.length())
            return 0;

        if (cache[begin] != -1)
            return cache[begin];


        cache[begin] = INF;

        for (int i = 3; i <= 5; ++i) {
            if ( begin + i <= N.length()) {
                cache[begin] = Math.min(cache[begin], memorize(begin+i) + classify(begin, begin + i -1));
            }
        }

        return cache[begin];
    }

    public static void main(String[] args) {

        Arrays.fill(cache, -1);


        System.out.println(memorize(0)  );
    }
}
