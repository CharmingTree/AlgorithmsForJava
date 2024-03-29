package AlgorithmSolutionStrategy.dynamicprogramming;

import java.util.Arrays;

public class TrianglePath {
    static int[][] triangle2 = new int[][] {
            {6,0,0,0,0},
            {1,2,0,0,0},
            {3,7,4,0,0},
            {9,4,1,7,0},
            {2,7,5,9,4}
    };

    static int[][] triangle = new int[][] {
            {2,0,0,0,0},
            {2,1,0,0,0},
            {2,1,1,0,0},
            {2,1,1,1,0},
            {2,1,1,1,100}
    };

    int pathSum(int y, int x, int sum) {

        if ( triangle.length-1 == y)
            return sum + triangle[y][x];

        sum += triangle[y][x];
        return Math.max(pathSum(y+1, x+1, sum), pathSum(y+1, x, sum));
    }

    int maxSum(int rShift, int level) {
        if (level >= triangle.length || rShift >= triangle[level].length || triangle[level][rShift] == 0)
            return -1;


        int ret = triangle[level][rShift];
        int tempSum = ret;



        for (int i = rShift; i < triangle[level].length; i++) {
            tempSum = Math.max(tempSum, ret+maxSum(i, level+1));
        }

        System.out.println("rShift = " + rShift + " / level : " + level + " / ret : " + ret +" / sum = " + tempSum);
        return tempSum;
    }


    static int n;
    static int[][] cache = new int[100][100];

    // 메모제이션 사용 n^2 복잡도
    int path2(int y, int x) {
        // base case
        if ( y == n-1 )
            return triangle[y][x];

        // 메모제이션
        if (cache[y][x] != -1)
            return cache[y][x];

        return cache[y][x] = Math.max(path2(y+1, x), path2(y+1, x+1)) + triangle[y][x];
    }



    public static void main(String[] args) {

        TrianglePath trianglePath = new TrianglePath();

        n = triangle.length;

        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }

        System.out.println(trianglePath.path2(0,0));

        //System.out.println(trianglePath.pathSum(0,0, 0));
    }
}
