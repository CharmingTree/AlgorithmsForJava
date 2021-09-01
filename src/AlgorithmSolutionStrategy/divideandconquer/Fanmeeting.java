package AlgorithmSolutionStrategy.divideandconquer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Fanmeeting {

    int brustSolution(String M, String N) {
        int answer = 0;

        for (int i = 0; i < N.length(); ++i) {
            boolean isComplete = true;
            for (int j = 0; j < M.length(); ++j) {
                //System.out.println(j + ", "+ (i+j));
                if (i+j >= N.length()) {
                    isComplete = false;
                    break;
                }
                if (M.charAt(j) == 'M' && N.charAt(i+j) == 'M') {
                    isComplete = false;
                    break;
                }
            }
            if (isComplete)
                ++answer;
            //i = i+M.length();
        }

        return answer;
    }

    int usedKaratsubaSolution(String mebers, String fans) {
        int N = mebers.length(), M = fans.length();
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            if (mebers.charAt(i) == 'M')
                A.add(1);
            else
                A.add(0);
        }

        for (int i = 0; i < M ; ++i) {
            if (fans.charAt(M-1-i) == 'M')
                B.add(1);
            else
                B.add(0);
        }

        System.out.println(A);
        System.out.println(B);

        return 0;
    }

    public static void main(String[] args) {

        Fanmeeting fanmeeting = new Fanmeeting();


        System.out.println(fanmeeting.usedKaratsubaSolution("FFFMMM", "MMMFFF"));
        //System.out.println(fanmeeting.brustSolution("FFFFF", "FFFFFFFFFF"));
        //ystem.out.println(fanmeeting.brustSolution("FFFFM", "FFFFFMMMMF"));
        //System.out.println(fanmeeting.brustSolution("MFMFMFFFMMMFMF", "MMFFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF"));
    }
}
