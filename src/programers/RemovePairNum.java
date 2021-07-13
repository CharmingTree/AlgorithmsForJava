package programers;

import java.util.ArrayList;
import java.util.List;

public class RemovePairNum {

    public static int solution(String s)
    {
        int answer = -1;

        //List<Character> strList = s.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        List<Character> strList = new ArrayList<>();
        List<Character> bucket = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!bucket.isEmpty() && bucket.get(bucket.size()-1).equals(s.charAt(i))) {
                bucket.remove(bucket.size()-1);
            }
            else {
                bucket.add(s.charAt(i));
            }
        }

        /*while (!strList.isEmpty()) {
            if (!bucket.isEmpty() && bucket.get(bucket.size()-1).equals(strList.get(0))) {
                bucket.remove(bucket.size()-1);
                strList.remove(0);
            }
            else {
                bucket.add(strList.remove(0));
            }
        }*/
        answer = bucket.isEmpty() ? 1 : 0;

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution("baabaa"));
    }
}
