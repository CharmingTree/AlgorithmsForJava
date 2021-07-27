package AlgorithmSolutionStrategy;

import java.util.List;

public class SelectMenu {

    private static final int INF = 987654321;
    private static final int M = 5;

    boolean canEveryBodyEat(List<Integer> menu) {

        return true;
    }

    int selectMenu(List<Integer> menu, int food) {

        if (food == M) {
            if (canEveryBodyEat(menu))
                return menu.size();
            return INF;
        }

        int ret = selectMenu(menu, food+1);

        menu.add(food);
        //menu.remove()
        return -1;
    }


    public static void main(String[] args) {

    }
}
