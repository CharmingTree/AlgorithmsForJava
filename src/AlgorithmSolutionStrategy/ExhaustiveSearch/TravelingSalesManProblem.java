package AlgorithmSolutionStrategy.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

public class TravelingSalesManProblem {

    int n = 5;
    int[][] dist = new int[][]{
            {0, 1, 9, 9, 9},
            {1, 0, 1, 9, 9},
            {9, 1, 0, 1, 9},
            {9, 9, 1, 0, 1},
            {1, 9, 9, 1, 0}
    };

    public int shortestPath(List<Integer> path, boolean[] visited, int currentLengh) {
        // basis
        if (path.size() == n) {
            System.out.println(path + " , " +  (currentLengh));
            return currentLengh;
        }

        int ret = Integer.MAX_VALUE;

        for ( int next = 0; next < n; ++next) {
            if (visited[next])
                continue;
            int here = path.get(path.size()-1);
            path.add(next);
            visited[next] = true;

            int cand = shortestPath(path, visited, currentLengh + dist[here][next]);

            ret = Math.min(ret, cand);
            visited[next] = false;
            path.remove(path.size()-1);
        }

        return ret;
    }

    public static void main(String[] args) {

        TravelingSalesManProblem travelingSalesManProblem = new TravelingSalesManProblem();

        List<Integer> path = new ArrayList<>();
        path.add(0);

        boolean[] visited = new boolean[5];
        visited[0] = true;
        int result = travelingSalesManProblem.shortestPath(path, visited, 0);

        System.out.println(result);
        System.out.println(path);
    }
}
