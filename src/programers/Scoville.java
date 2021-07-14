package programers;

import java.util.*;

public class Scoville {


    public static int solution(int[] scoville, int K) {
        int answer = 0;

        //ArrayList<Integer> underScovList = new ArrayList<>();
        //ArrayList<Integer> moreScovList = new ArrayList<>();

        PriorityQueue<Integer> underScovList = new PriorityQueue<>();
        PriorityQueue<Integer> moreScovList = new PriorityQueue<>();


        for (int i : scoville) {
            if (i >= K )
                moreScovList.add(i);
            else
                underScovList.add(i);
        }


        //Collections.sort(underScovList);
        //Collections.sort(moreScovList);

        int secondNum = -1;
        while (!underScovList.isEmpty()) {
            //System.out.println(underScovList +" / "+ moreScovList);

            int firstNum = underScovList.poll();
            if (underScovList.size() == 0) {
                //secondNum = moreScovList.remove(0);
                secondNum = moreScovList.poll();
            }
            else {
                //secondNum = underScovList.remove(1);
                secondNum = underScovList.poll();
            }
            //System.out.println(firstNum+" / "+ secondNum);
            int tmpNUm = firstNum + secondNum * 2;

            if (tmpNUm >= K) {
                moreScovList.add(tmpNUm);
            }
            else
                underScovList.add(tmpNUm);

            //System.out.println(underScovList +" / "+ moreScovList);
            //Collections.sort(underScovList);
            //Collections.sort(moreScovList);
            answer++;

            if (underScovList.size() == 1 && moreScovList.size() == 0) {
                return -1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        //System.out.println(solution(new int[]{1,1,1,1}, 20));



    }
}
