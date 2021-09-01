package AlgorithmSolutionStrategy.divideandconquer;

/*
 * 너비가 같은 N개의 나무 판자를 붙여 세운 울타리가 있습니다.
 * 시간이 지남에 따라 판자들이 부러지거나 망가져 높이가 다 달라진 관계로 울타리를
 * 통째로 교체하기로 했습니다. 울타리를 구성하는 각 판자의 높이가 주어질 때,
 * 잘라낼 수 있는 직사각형의 최대 크기를 계산하는 프로그램을 작성하세요,
 * 단, 직사각형을 비스듬히 잘라낼 수는 없습니다.
 * 판자의 너비는 모두 1이라고 가정합니다.
 */


import java.util.Arrays;
import java.util.List;

public class Fence {

    /**
     * N^2 시간 복잡도 해결방법
     * */
    public int bruteForce(List<Integer> h) {
        int ret = 0;
        int N = h.size();

        // 가능한 모든 조합을 순회
        for (int left = 0; left < N; ++left) {
            int minHeight = h.get(left);
            for ( int right = left; right < N; ++right) {
                minHeight = Math.min(minHeight, h.get(right));
                ret = Math.max(ret, (right - left + 1) * minHeight);
            }
            //System.out.println(">>> " + ret);
        }
        return ret;
    }

    /**
     * ︎
     *       ◼
     *       ◼
     * ◼     ◼   ◼
     * ◼     ◼ ◼ ◼
     * ◼   ◼ ◼ ◼ ◼
     * ◼   ◼ ◼ ◼ ◼
     * ◼   ◼ ◼ ◼ ◼ ◼
     * ◼   ◼ ◼ ◼ ◼ ◼
     * ◼ ◼ ◼ ◼ ◼ ◼ ◼
     * 7 1 5 9 6 7 3
     * 0 1 2 3 4 5 6
     * */

    public int solve(List<Integer> h, int left, int right, int depth) {

        // deapth는 없어도된다. 로그 찍으려고 넣음
        System.out.println("Depth : " + depth);
        // base case
        if (left == right)
            return h.get(left);

        int mid = (left + right) / 2;

        int ret = Math.max(solve(h, left , mid, depth+1), solve(h, mid+1, right, depth+1));

        int lo = mid, hi = mid +1;
        int height = Math.min(h.get(lo), h.get(hi));

        // height * 2 = mid, mid+1 의 직사각형 크기
        ret = Math.max(ret, height * 2);
        System.out.println("left : " + left + " / right : " + right);
        while ( left < lo || hi < right ) {
            if (hi < right && (lo == left || h.get(lo-1)< h.get(hi+1))) {
                ++hi;
                height = Math.min(height, h.get(hi));
            }
            else {
                --lo;
                height = Math.min(height, h.get(lo));
            }

            ret = Math.max(ret, height * (hi - lo + 1));
            System.out.print("Depth : " + depth +" , (lo, hi) = " + lo +", " + hi);
            System.out.println(" / current = " + height * (hi - lo + 1));
        }
        return ret;
    }


    public int solve2(List<Integer> h, int left, int right) {

        if (left == right)
            return h.get(left);

        int mid = (left+right) / 2;

        int ret = Math.max(solve2(h, left, mid), solve2(h, mid+1, right));

        int lo = mid, hi = mid+1;

        int height = Math.min(h.get(lo), h.get(hi));
        ret = Math.max(ret, height*2);

        while (lo > left || hi < right) {
            if (hi < right && (lo == left || (h.get(lo-1) < h.get(hi+1)))) {
                height = Math.min(height, h.get(++hi));
                ret = Math.max(ret, height * ((hi-lo)+1));
            }
            else {
                height = Math.min(height, h.get(--lo));
                ret = Math.max(ret, height * ((hi-lo)+1));
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        Fence fence = new Fence();

        List<Integer> lst = Arrays.asList(7,1,5,9,6,7,3);
        //List<Integer> lst = Arrays.asList(7,1,1,1,1,1,1,1,1);
        //System.out.println(fence.bruteForce(lst));

        //System.out.println(fence.solve(lst, 0, lst.size()-1, 0));
        System.out.println(fence.solve2(lst, 0, lst.size()-1));
    }
}
