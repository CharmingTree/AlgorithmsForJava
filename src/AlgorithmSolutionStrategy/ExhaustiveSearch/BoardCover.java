package AlgorithmSolutionStrategy.ExhaustiveSearch;

import java.util.List;

public class BoardCover {

    public final static int[][][] converType = new int[][][]
    {
        { {0, 0}, {1, 0}, {0, 1} },
        { {0, 0}, {0, 1}, {1, 1} },
        { {0, 0}, {1, 0}, {1, 1} },
        { {0, 0}, {1, 0}, {1, -1} }
    };

    boolean set(int[][] board, int y, int x, int type, int delta) {
        boolean ok = true;
        for (int i = 0; i < 3; i++) {
            int ny = y + converType[type][i][0];
            int nx = x + converType[type][i][1];

            // 새 블록이 보드판을 넘는경우 막기
            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                ok = false;
            }
            else {
                board[ny][nx] += delta;
                if (board[ny][nx]  > 1) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    int cover(int[][] board) {
        int y = -1;
        int x = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            // 상단 왼쪽기준으로 채워지지 않은 칸을 찾은 경우
            if (y != -1)
                break;
        }

        // 모든 칸이 채워있을 경우 (기저 사례)
        if (y == -1)
            return 1;

        int ret = 0;

        for (int type = 0; type < 4; ++type) {
            if (set(board, y, x, type, 1))
                ret += cover(board);
            set(board, y, x, type, -1);
        }

        return ret;
    }

    public static void main(String[] args) {

        int[][] board = new int[][] {
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,1,0,0,1,1,1}
        };

        int[][] board2 = new int[][] {
                {1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}
        };

        BoardCover boardCover = new BoardCover();

        int result = boardCover.cover(board2);


        System.out.println(result);
    }
}
