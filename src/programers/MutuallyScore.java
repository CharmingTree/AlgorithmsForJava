package programers;

import java.util.*;

public class MutuallyScore {

    public String solution(int[][] scores) {
        List<Integer> totalList = new ArrayList<>();

        for (int i = 0; i < scores.length; ++i) {
            int temp = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean isUnique = true;
            for ( int j = 0; j < scores[i].length; ++j) {
                if (i != j && scores[i][i] == scores[j][i])
                    isUnique = false;
                temp += scores[j][i];
                min = Math.min(min, scores[j][i]);
                max = Math.max(max, scores[j][i]);
            }
            int length = scores.length;
            if (isUnique && (scores[i][i] == min || scores[i][i] == max))
            {
                temp -= scores[i][i];
                --length;
            }


            totalList.add(temp/length);
        }

        StringBuilder sb = new StringBuilder();

        for (Integer data : totalList) {
            if (data >= 90)
                sb.append("A");
            else if(data >= 80)
                sb.append("B");
            else if(data >= 70)
                sb.append("C");
            else if(data >= 50)
                sb.append("D");
            else
                sb.append("F");
        }

        //System.out.println(totalList);

        return sb.toString();
    }

    public static void main(String[] args) {


        MutuallyScore mutuallyScore = new MutuallyScore();

        int[][] testCase_1 = new int[][] {
                                            {100,90,98,88,65},
                                            {50,45,99,85,77},
                                            {47,88,95,80,67},
                                            {61,57,100,80,65},
                                            {24,90,94,75,65}
                                        };

        int[][] testCase_2 = new int[][] {
                {100,90,98,88,65},
                {100,45,99,85,77},
                {100,88,95,80,67},
                {100,57,100,80,65},
                {100,90,94,75,65}
        };

        System.out.println(mutuallyScore.solution(testCase_2));
    }
}
