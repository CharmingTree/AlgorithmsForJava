package AlgorithmSolutionStrategy;

public class InefficientMaxSum {

    public static int MIN = Integer.MIN_VALUE;

    public int fastestMaxSum(int[] arr) {
        long startTime = System.nanoTime();
        int N = arr.length;
        int ret = MIN;
        int psum = 0;

        for (int i = 0; i < N; i++) {
            psum = Math.max(psum, 0) + arr[i];
            ret = Math.max(psum, ret);
        }

        long endTime = System.nanoTime();
        System.out.println("fastestMaxSum ExcuteTime : " + (endTime-startTime) + " ns");
        return ret;
    }

    public int fastMaxSum(int[] arr, int lo, int hi) {
        if (lo == hi)
            return arr[lo];

        int mid = (lo+hi) / 2;
        int left = MIN, right = MIN, sum = 0;
        for (int i = mid; i >= lo; i--) {
            sum += arr[i];
            left = Math.max(left, sum);
        }

        sum = 0;

        for (int j = mid+1; j <= hi; j++) {
            sum += arr[j];
            right = Math.max(right, sum);
        }

        int single = Math.max(fastMaxSum(arr, lo, mid), fastMaxSum(arr, mid+1, hi));



        return Math.max(left + right, single);
    }

    public int inefficientMaxSum(int[] arr) {
        long startTime = System.nanoTime();
        int N = arr.length;
        int ret = MIN;
        for (int i = 0; i < N; i++) {
            for ( int j = i; j < N; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                ret = Math.max(ret, sum);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("inefficientMaxSum ExcuteTime : " + (endTime-startTime) + " ns");
        return ret;
    }

    public int betterMaxSum(int[] arr) {
        long startTime = System.nanoTime();
        int N = arr.length;
        int ret = MIN;
        for ( int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                ret = Math.max(ret, sum);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("betterMaxSum ExcuteTime : " + (endTime-startTime) + " ns");
        return  ret;
    }

    public static void main(String[] args) {
        InefficientMaxSum obj = new InefficientMaxSum();

        System.out.println(obj.inefficientMaxSum(new int[] {-7, 4, -3, 6, 3, -8, 3, 4}));
        System.out.println(obj.betterMaxSum(new int[] {-7, 4, -3, 6, 3, -8, 3, 4}));


        long startTime = System.nanoTime();
        System.out.println(obj.fastMaxSum(new int[] {-7, 4, -3, 6, 3, -8, 3, 4}, 0, 7));
        long endTime = System.nanoTime();
        System.out.println("fastMaxSum ExcuteTime : " + (endTime-startTime) + " ns");

        System.out.println(obj.fastestMaxSum(new int[] {-7, 4, -3, 6, 3, -8, 3, 4}));

        System.out.println(obj.fastestMaxSum(new int[] {-7, -4, -3, -6, -3, -8, -3, -4}));

        //System.out.println(obj.fastMaxSum(new int[] {-99, -99, 100, 100, 100, 100, -99, -99}, 0, 7));
    }
}
