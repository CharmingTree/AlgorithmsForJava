package programers;

import java.util.*;

public class PhoneKeyPad {

    public static String solution(int[] numbers, String hand) {
        long startTime = System.nanoTime();
        List<String> result = new ArrayList<>();
        HashSet<Integer> leftSide = new HashSet<>(Arrays.asList(1,4,7));
        HashSet<Integer> rightSide = new HashSet<>(Arrays.asList(3,6,9));

        int cur_left = 10;
        int cur_right = 12;

        for (Integer i : numbers) {
            if ( i == 0 )
                i = 11;

            //System.out.println("current[I] : " + i + " / left : " + cur_left +" / right : " + cur_right);
            if (leftSide.contains(i)) {
                cur_left = i;
                result.add("L");
            }
            else if (rightSide.contains(i)) {
                cur_right = i;
                result.add("R");
            }
            else {
                if (cur_left+1 == i && cur_right-1 == i) {
                    if (hand.equals("right")) {
                        cur_right = i;
                        result.add("R");
                    }
                    else {
                        cur_left = i;
                        result.add("L");
                    }
                }
                else {
                    int leftCost = 0;
                    int tmpLeft = cur_left;
                    int rightCost = 0;
                    int tmpRight = cur_right;

                    while (tmpLeft != i) {
                        //System.out.println("tmpLeft "+ tmpLeft);
                        if (tmpLeft+1 == i) {
                            tmpLeft += 1;
                        }
                        else if (tmpLeft+3 <= i){
                            tmpLeft += 3;
                        }
                        else if (tmpLeft-3 >= i){
                            tmpLeft -= 3;
                        }
                        else {
                            tmpLeft += 1;
                        }
                        leftCost++;
                    }

                    while (tmpRight != i) {
                        //System.out.println("tmpRight : " + tmpRight);
                        if (tmpRight-1 == i) {
                            tmpRight -= 1;
                        }
                        else if (tmpRight+3 <= i){
                            tmpRight += 3;
                        }
                        else if (tmpRight-3 >= i){
                            tmpRight -= 3;
                        }
                        else {
                            tmpRight -= 1;
                        }
                        rightCost++;
                    }

                    if (leftCost == rightCost) {
                        if (hand.equals("right")) {
                            result.add("R");
                            cur_right = tmpRight;
                        }
                        else {
                            result.add("L");
                            cur_left = tmpLeft;
                        }
                    }
                    else if (leftCost < rightCost) {
                        result.add("L");
                        cur_left = tmpLeft;
                    }
                    else if (leftCost > rightCost) {
                        result.add("R");
                        cur_right = tmpRight;
                    }


                }
            }
        }



        /*
        *   1 2 3
        *   4 5 6
        *   7 8 9
        *   * 0 #
        * */

        //System.out.println(result);

        long endTime = System.nanoTime();
        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");

        return String.join("", result);
    }


    int[][] numPosition = {
            {3,1}, // 0
            {0,0}, // 1
            {0,1}, // 2
            {0,2}, // 3
            {1,0}, // 4
            {1,1}, // 5
            {1,2}, // 6
            {2,0}, // 7
            {2,1}, // 8
            {2,2} // 9
    };

    int[] leftPosition = {3,0};
    int[] rightPosition = {3,2};

    public String solution2(int[] numbers, String hand) {
        long startTime = System.nanoTime();
        ArrayList<String> result = new ArrayList<>();
        String myHand = hand.equals("right") ? "R" : "L";
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                result.add("L");
                leftPosition = numPosition[num];
            }
            else if (num == 3 || num == 6 || num == 9) {
                result.add("R");
                rightPosition = numPosition[num];
            }
            else {
                if (getDist(leftPosition, numPosition[num]) < getDist(rightPosition, numPosition[num])) {
                    result.add("L");
                    leftPosition = numPosition[num];
                }
                else if (getDist(leftPosition, numPosition[num]) > getDist(rightPosition, numPosition[num])) {
                    result.add("R");
                    rightPosition = numPosition[num];
                }
                else {
                    result.add(myHand);
                    if (myHand.equals("R"))
                        rightPosition = numPosition[num];
                    else
                        leftPosition = numPosition[num];
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("ExcuteTime : " + (endTime-startTime) + " ns");
        return String.join("", result);
    }

    public int getDist(int[] curPosition, int[] targetPosition) {
        return Math.abs(curPosition[0]-targetPosition[0]) + Math.abs(curPosition[1]-targetPosition[1]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(new PhoneKeyPad().solution2(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(new PhoneKeyPad().solution2(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }
}

