package programers;

import java.util.*;

public class OTFCountry {

    public static String solution(int n) {
        String answer = "";

        int mok = 0;
        int mod = 0;
        List<String> result = new ArrayList<>();
        while (n >= 3) {
            mok = n / 3;
            n = mok;
            result.add(String.valueOf(mok));
        }

        answer = String.join("", result);
        answer = answer.replace("3", "4");
        answer = answer.replace("0", "1");
        //Collections.reverse(result);
        System.out.println(result);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(9));
    }
}

