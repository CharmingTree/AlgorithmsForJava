package programers;

import java.util.*;

public class Ktimes {

    public int[] solution2(int[] array, int[][] commands) {
        long startTime = System.nanoTime();
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        long endTime = System.nanoTime();
        System.out.println("solution2 ExcuteTime : " + (endTime-startTime) + " ns");
        for (int i : answer) {
            System.out.print(i +", ");
        }
        System.out.println();
        return answer;
    }

    public int[] solution(int[] array, int[][] commands) {
        long startTime = System.nanoTime();
        int[] answer = new int[commands.length];

        //System.out.println(answer.length);
        int idx = 0;
        for (int[] i : commands) {

            List<Integer> lst = new ArrayList<>();
            int[] lst2 = Arrays.copyOfRange(array, i[0]-1, i[1]);
            Arrays.sort(lst2);
            //for (int j = i[0]-1; j < i[1]; j++) {
            //    lst.add(array[j]);
            //}
            //Collections.sort(lst);
            //System.out.println(lst);
            //answer[idx++] = lst.get(i[2]-1);
            answer[idx++] = lst2[i[2]-1];
        }

        long endTime = System.nanoTime();
        System.out.println("solution1 ExcuteTime : " + (endTime-startTime) + " ns");
        for (int i : answer) {
            System.out.print(i +", ");
        }
        System.out.println();
        return answer;
    }

    public static void main(String[] args) {

        new Ktimes().solution2(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        new Ktimes().solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        new Ktimes().solution2(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        new Ktimes().solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        new Ktimes().solution2(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        new Ktimes().solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        new Ktimes().solution2(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        new Ktimes().solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
