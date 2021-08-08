package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Greedy {

    public int solution(int n, int[] lost, int[] reserve) {
        long startTime = System.nanoTime();
        //if (n == lost.length && lost.length == reserve.length) {
        //    return n;
        //}

        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();

        for (int i : lost) {
            boolean isContain = false;
            for (int j : reserve) {
                if (i == j) {
                    isContain = true;
                    break;
                }
            }
            if (!isContain)
                lostList.add(i);
        }

        for (int i : reserve) {
            boolean isContain = false;
            for (int j : lost) {
                if (i == j) {
                    isContain = true;
                    break;
                }
            }
            if (!isContain)
                reserveList.add(i);
        }

        int answer = n - lostList.size();
        Collections.sort(lostList);
        Collections.sort(reserveList);

        for ( Integer i : reserveList) {
            for (int j = 0; j < lostList.size(); j++) {
                if (lostList.get(j) == i-1 || lostList.get(j) == i+1) {
                    lostList.remove(j);
                    answer++;
                    break;
                }
            }
        }
        long endTime = System.nanoTime();

        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");
        return answer;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        long startTime = System.nanoTime();
        int[] people = new int[n+2];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length-2; i++) {
            if(people[i] == -1) {
                if(people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");
        return answer;
    }

    public static void main(String[] args) {

        Greedy g = new Greedy();

        int result = g.solution2(5, new int[] {2,4}, new int[] {5, 3, 1});
        int result3 = g.solution(5, new int[] {2,4}, new int[] {5, 3, 1});
        System.out.println(result);
        System.out.println(result3);
        //int result2 = g.solution(2, new int[] {1,2}, new int[] {4,5});
        //System.out.println(result2);

    }
}
