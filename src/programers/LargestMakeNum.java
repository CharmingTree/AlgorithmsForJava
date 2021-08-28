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

    String rightFillStr(String s, int po) {

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = s.length(); i < po; i++) {
            sb.append("0");
        }

        return sb.toString();
    }

    public String solution3(int[] numbers) {
        String answer = "";

        List<List<Integer>> unComplectList = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            unComplectList.add(new ArrayList<>());
        }

        for (int num : numbers) {
            String temp = String.valueOf(num);
            unComplectList.get(Character.getNumericValue(temp.charAt(0))).add(num);
        }

        Comparator<Integer> cp2 = (a,b) -> {
            String tA = String.valueOf(a);
            String tB = String.valueOf(b);

            Integer rA = Integer.parseInt(tA+tB);
            Integer rB = Integer.parseInt(tB+tA);

            Integer result = rA.compareTo(rB);
            return result > 0 ? -1 : result < 0 ? 1 : 0;
        };

        Comparator<Integer> cp = (a,b) -> {
            String tA = String.valueOf(a);
            String tB = String.valueOf(b);

            if (tA.length() > tB.length()) {
                tB = rightFillStr(tB, tA.length());
                Integer rA = Integer.parseInt(tA);
                Integer rB = Integer.parseInt(tB);
                int temp = rA.compareTo(rB);
                //return  temp == 0 ? -1 : temp;
                return  temp == 0 ? 1 : temp * -1;

            }
            else if (tA.length() < tB.length())  {
                tA = rightFillStr(tA, tB.length());
                Integer rA = Integer.parseInt(tA);
                Integer rB = Integer.parseInt(tB);
                int temp = rA.compareTo(rB);
                //return temp == 0 ? 1 : temp;
                return temp == 0 ? -1 : temp * -1;
            }
            else {
                Integer rA = Integer.parseInt(tA);
                Integer rB = Integer.parseInt(tB);
                return rA.compareTo(rB) * -1;
            }

        };

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            //System.out.println(unComplectList.get(i));
            //Collections.sort(unComplectList.get(i), cp);
            Collections.sort(unComplectList.get(i), cp2);
            //System.out.println(unComplectList.get(i));
            //Collections.reverse(unComplectList.get(i));
            for (int j = 0; j < unComplectList.get(i).size(); j++) {
                sb.append(unComplectList.get(i).get(j));
            }
        }


        //return sb.toString().isEmpty() ? "0" : sb.toString();
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }

    /*
    [정리된 코드]
    생각해보니 앞자리 별로 버켓을 나눌 필요가 없음;;
    * */
    public String solution4(int[] numbers) {
        String answer = "";

        List<Integer> unComplectList = new ArrayList<>();

        for (int num : numbers) {
            unComplectList.add(num);
        }

        Comparator<Integer> cp = (a,b) -> {
            String tA = String.valueOf(a);
            String tB = String.valueOf(b);

            Integer rA = Integer.parseInt(tA+tB);
            Integer rB = Integer.parseInt(tB+tA);

            Integer result = rA.compareTo(rB);
            return result > 0 ? -1 : result < 0 ? 1 : 0;
        };

        Collections.sort(unComplectList, cp);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unComplectList.size(); i++) {
            sb.append(unComplectList.get(i));
        }


        //return sb.toString().isEmpty() ? "0" : sb.toString();
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        LargestMakeNum largestMakeNum = new LargestMakeNum();

        System.out.println(largestMakeNum.solution4(new int[] {6, 10, 2, 9, 99, 98, 91, 999, 988, 9001}));
        System.out.println(largestMakeNum.solution4(new int[] {1,10,9}));
        //System.out.println(largestMakeNum.solution3(new int[] {10, 101, 1001, 11}));
        // 101101001
        // 101100110
        //System.out.println(largestMakeNum.solution3(new int[] {3, 30, 34, 5, 9}));
        //System.out.println(largestMakeNum.rightFillStr("12", 3));


    }
}
