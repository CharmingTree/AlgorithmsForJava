package AlgorithmSolutionStrategy.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 최대 증가 부분 수열 :: 수열 S에 0개 이상을 지우고 남은 부분 수열이 '순 증가' 하는 증가 부분을 최대로 구하기
// e.g) S = 1, 3, 4, 2, 4 => s' = 1, 2, 4는 S의 증가 부분 순열이다
//      S' = 1, 4, 4 는 증가 부분 순열이 아니다
public class LIS {

    static int[] cache = new int[100];

    // 완전 탐색으로 무식하게 풀어보기
    static int lis(List<Integer> A) {
        if (A.isEmpty())
            return 0;

        int ret = 0;

        for (int i = 0; i < A.size(); ++i) {
            List<Integer> B = new ArrayList<>();
            for (int j = i+1; j < A.size(); ++j) {
                if (A.get(i) < A.get(j)) {
                    B.add(A.get(j));
                }
            }
            ret = Math.max(ret, 1 + lis(B));
        }

        return ret;
    }

    // 동적 계획법 1
    static int n;
    static int[] S = new int[] {1,2,5,3,6,4,7};
    static int lis2(int start) {
        if (cache[start] != -1) {
            return cache[start];
        }

        int ret = 1;
        for (int next = start+1; next < n; ++next) {
            if (S[start] < S[next])
                ret = Math.max(ret, lis2(next) +1);
        }

        return ret;
    }

    public static void main(String[] args) {

        List<Integer> lst = Arrays.asList(1,5,2,3,6,4,8,9);

        System.out.println(lis(lst));

        //Arrays.fill(cache, -1);
        //n = S.length;
        //System.out.println(lis2(0));
    }
}
