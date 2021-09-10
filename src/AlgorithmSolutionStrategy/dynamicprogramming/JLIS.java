package AlgorithmSolutionStrategy.dynamicprogramming;

import java.util.Arrays;

public class JLIS {

    static int NEGINF = Integer.MIN_VALUE;

    static int n;
    static int m;
    static int[] A = new int[] {10,20,30,1,2};
    static int[] B = new int[] {10,20,30};
    static int[][] cache = new int[101][101];

    static int jlis(int indexA, int indexB) {

        if (cache[indexA+1][indexB+1] != -1)
            return cache[indexA+1][indexB+1];

        cache[indexA+1][indexB+1] = 2;
        int a = indexA == -1 ? NEGINF : A[indexA];
        int b = indexB == -1 ? NEGINF : B[indexB];
        int maxElement = Math.max(a,b);

        for (int nextA = indexA + 1; nextA < n; ++nextA) {
            if (maxElement < A[nextA]) {
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], jlis(nextA, indexB) +1);
            }
        }

        for (int nextB = indexB + 1; nextB < m; ++nextB) {
            if (maxElement < B[nextB]) {
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], jlis(indexA, nextB) +1);
            }
        }

        return cache[indexA+1][indexB+1];
    }

    public static void main(String[] args) {

        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }

        n = A.length;
        m = B.length;


        System.out.println(jlis(-1,-1));

    }
}
