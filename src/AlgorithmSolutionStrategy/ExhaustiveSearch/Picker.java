package AlgorithmSolutionStrategy.ExhaustiveSearch;

import java.util.ArrayList;

public class Picker {

    public void pick(int n, ArrayList<Integer> picked, int toPick) {
        if (toPick == 0) {
            System.out.println(picked);
            return;
        }

        int smallest = picked.isEmpty() ? 0 : picked.get(picked.size()-1) + 1;

        for ( int next = smallest; next < n; next++) {
            picked.add(next);
            System.out.println(">> " + picked);
            pick(n, picked, toPick -1);
            picked.remove(picked.size()-1);
        }
    }

    public static void main(String[] args) {

        Picker picker = new Picker();

        picker.pick(4, new ArrayList<Integer>() , 4);
    }
}
