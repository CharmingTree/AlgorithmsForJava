package AlgorithmSolutionStrategy.dynamicprogramming;

import java.util.Arrays;

public class PI {

    final static int INF = 987654321;
    final static String N = "12673939";

    static int classify(int a, int b) {
        if (a >= (b-a+1))
            return INF;
        String M = N.substring(a, b-a+1);
        if (M.isEmpty())
            return 0;
        char[] tC = new char[M.length()];

        Arrays.fill(tC, M.charAt(0));
        String tmpStr = String.valueOf(tC);

        // level 1
        if (M.equals(tmpStr)) {
            return 1;
        }


        // 등차 수열인지 검사
        boolean progressice = true;
        for (int i = 0; i < M.length()-1; ++i) {
            if (M.charAt(i+1) - M.charAt(i) != M.charAt(1) - M.charAt(0))
                progressice = false;
        }

        // level 2
        // 숫자가 1씩 단조 증/감하는 등차수열
        if (progressice && Math.abs(M.charAt(1)- M.charAt(0)) == 1) {
            System.out.println(a +" / "+b);
            return 2;
        }


        boolean alternating = true;

        // 패턴이 반복되는지 검사
        for( int i = 0; i < M.length(); ++i) {
            if (M.charAt(i) != M.charAt(i%2))
                alternating = false;
        }

        // level 4
        if (alternating)
            return 4;

        // lavel 5 :: 공차가 1이 아닌 등차수열의 난이도 5
        if (progressice)
            return 5;

        return 10;
    }

    static int[] cache = new int[10002];

    static int memorize(int begin) {
        if (begin == N.length())
            return 0;

        if (cache[begin] != -1)
            return cache[begin];

        cache[begin] = INF;
        for (int L = 3; L <= 5; ++L) {
            if (begin + L <= N.length()) {
                cache[begin] = Math.min(cache[begin], memorize(begin+L) + classify(begin, begin + L - 1));
            }
        }
        return cache[begin];
    }

    public static void main(String[] args) {

        Arrays.fill(cache, -1);

        System.out.println(memorize(0));

        for (int i = 0; i < cache.length; ++i)   {
            System.out.print(cache[i] +" ");
            if (((i+1) % 10) == 0)
                System.out.println();
        }
    }
}
