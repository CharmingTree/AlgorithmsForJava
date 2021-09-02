package AlgorithmSolutionStrategy.dynamicprogramming;

import java.util.Arrays;

public class JumpGame {

    static int[][] cache = new int[100][100];
    int n;
    int[][] board2 = new int[][] {
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1},
            {1,1,1,1,1,1,2},
            {1,1,1,1,1,2,1}
    };

    int cnt = 0;
    /* 책안보고 코딩했는데. 로직이 똑같다 킹기하네 */
    boolean isEscape(int right, int down, int[][] board) {
        cnt++;
        int y = board.length;
        int x = board[0].length;

        if (y <= down || x <= right )
            return false;
        if (down == y-1 && right == x-1)
            return true;
        int dy = board[down][right];
        int dx = board[down][right];

        return isEscape(right+dx, down, board) || isEscape(right, down+dy, board);
    }


    // 메모이제이션 이용
    int jump(int y, int x) {
        cnt++;
        if ( y >= n || x >= n)
            return 0;
        if ( y == n-1 &&  x == n-1)
            return 1;

        if (cache[y][x] != -1)
            return cache[y][x];

        int jumpSize = board2[y][x];
        return cache[y][x] = (jump(y + jumpSize, x) + jump(y, x + jumpSize));
    }


    public static void main(String[] args) {

        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        int[][] board = new int[][] {
                {2,5,1,6,1,4,1},
                {6,1,1,2,2,9,3},
                {7,2,3,2,1,3,1},
                {1,1,3,1,7,1,2},
                {4,1,2,3,4,1,2},
                {3,3,1,2,3,4,1},
                {1,5,2,9,4,7,0}
        };


        JumpGame jumpGame = new JumpGame();
        jumpGame.n = jumpGame.board2.length;
        //System.out.println(jumpGame.isEscape(0,0, board2) +" , " + jumpGame.cnt);
        System.out.println(jumpGame.jump(0,0) +" , " + jumpGame.cnt);

    }
}
