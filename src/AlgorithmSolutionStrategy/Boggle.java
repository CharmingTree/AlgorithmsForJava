package AlgorithmSolutionStrategy;

public class Boggle {

    final static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    final static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
    final static char[][] board = {
        {'U', 'R', 'L', 'P', 'M'},
        {'X', 'P', 'R', 'E', 'T'},
        {'G','I', 'A', 'E', 'T'},
        {'X', 'T', 'N', 'Z', 'Y'},
        {'X', 'O', 'Q', 'R', 'S'}
    };

    boolean hasWord(int y, int x, String word) {

        if (!isRange(y,x)) {
            return false;
        }

        if (board[y][x] != word.charAt(0)) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }


        for (int direction = 0; direction < 8; ++direction) {
            int nextY = y + dy[direction];
            int nextX = x + dx[direction];

            if (hasWord(nextY, nextX, word.substring(1))) {
                return true;
            }

        }
        return false;
    }

    boolean isRange(int y, int x) {
        if (y >= 0 && y <= 4 && x >= 0 && x <= 4) {
            return true;
        }
        else
            return false;
    }


    public static void main(String[] args) {

        Boggle boggle = new Boggle();

        System.out.println(boggle.hasWord(1, 1, "PRETTY"));
    }
}
