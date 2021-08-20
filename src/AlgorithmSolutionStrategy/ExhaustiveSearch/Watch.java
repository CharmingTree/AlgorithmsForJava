package AlgorithmSolutionStrategy.ExhaustiveSearch;

public class Watch {

    char[][] pushBtn = new char[][] {
            {'*','*','.','.'},
            {'.','.','*','*'},
            {'.','*','.','.'},
            {'*','.','.','*'}
    };

    int[] watchBoard = new int[] {12, 3, 9, 9};

    public void push(int pushNum) {
        for (int i = 0; i < pushBtn[pushNum].length; i++) {
            if (pushBtn[pushNum][i] == '*') {
                watchBoard[i] += 3;
                if (watchBoard[i] == 15)
                    watchBoard[i] = 3;
            }
        }
    }

    public int solve(int[] watchBoard, int pushNum) {

        if (pushNum > 3) {
            return isComplete(watchBoard) ? 0 : 9999;
        }


        int temp = 9999;
        for (int i = 0; i < 4; ++i) {
            temp = Math.min(temp, i + solve(watchBoard, pushNum+1));
            push(pushNum);
        }

        return temp;
    }

    public boolean isComplete(int[] watchBoard) {
        for (int watch : watchBoard) {
            if (watch != 12)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Watch watch = new Watch();

        System.out.println(watch.solve(watch.watchBoard, 0));
    }
}
