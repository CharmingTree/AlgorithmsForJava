package programers;

import java.util.*;

public class LargestMakeNum {


    /* 개썅! 잘못 풀었다 */
    public String solution2(int[] numbers) {
        String answer = "";
        Map<Integer,Integer> numberMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            String temp = String.valueOf(numbers[i]);
            while (temp != null) {
                //System.out.println((int)temp.charAt(0));
                int ch = (int)temp.charAt(0)-48;
                if (!numberMap.containsKey(ch))
                    numberMap.put(ch, 1);
                else
                    numberMap.put(ch, numberMap.get(ch) + 1);

                temp = temp.length() == 1 ? null : temp.substring(1,temp.length());
            }
        }

        //System.out.println(numberMap);

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (numberMap.containsKey(i)) {
                for (int j = 0; j < numberMap.get(i); j++) {
                    sb.append(String.valueOf(i));
                }
            }
        }

        return sb.toString();
    }

    /* 무식한 방법으로 풀기 */
    public String solution(int[] numbers) {

        return solve(numbers);
    }

    String solve(int[] lst) {
        if (lst.length == 0)
            return "";

        int ret = 0;

        for (int i = 0; i < lst.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(lst[i]);

            int[] tempLst = copyArray(lst, i);
            sb.append(solve(tempLst));
            //System.out.println(sb.toString());
            ret = Math.max(ret, Integer.parseInt(sb.toString()));
        }
        return String.valueOf(ret);
    }

    int[] copyArray(int[] lst, int d) {
        int[] result = new int[lst.length-1];
        int position = 0;
        for(int i = 0; i < lst.length; i++) {
            if (d == i)
                continue;
            else
                result[position++] = lst[i];
        }

        //for (int  i = 0; i < result.length; i++)
        //    System.out.print(result[i]+", ");

        //System.out.println();
        return result;
    }


    public String solution3(int[] numbers) {
        String answer = "";

        List<List<Integer>> completeList = new ArrayList<>();
        List<List<Integer>> unComplectList = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            completeList.add(new ArrayList<>());
            unComplectList.add(new ArrayList<>());
        }

        for (int num : numbers) {
            String temp = String.valueOf(num);

            if (temp.length() == 1)
                completeList.get(num).add(num);
            else
                unComplectList.get(Character.getNumericValue(temp.charAt(0))).add(num);
        }

        for (int i = 1; i <= 10; i++) {
            Collections.sort(unComplectList.get(i));
            Collections.reverse(unComplectList.get(i));
            int temp = unComplectList.get(i).isEmpty() ? 0 : String.valueOf(unComplectList.get(i).get(0)).length();
            for (int j = 2; j <= temp; j++) {
                for (int k = 0; k < unComplectList.get(i).size(); k++) {
                    int curElementLength = String.valueOf(unComplectList.get(i).get(k)).length();
                    if ( j == curElementLength ) {
                        completeList.get(i).add(unComplectList.get(i).get(k));
                    }
                }
            }
        }
        System.out.println(completeList);
        System.out.println(unComplectList);
        return answer;
    }


    public static void main(String[] args) {
        LargestMakeNum largestMakeNum = new LargestMakeNum();

        System.out.println(largestMakeNum.solution3(new int[] {6, 10, 2, 9, 99, 98, 91, 999, 988, 9001}));

    }
}
