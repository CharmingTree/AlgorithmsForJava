package AlgorithmSolutionStrategy.divideandconquer;

public class FastSum {

    public static int fastSum(int n) {
        if ( n == 1)
            return 1;
        if ( n % 2 == 1)
            return fastSum(n-1) + n;

        return 2 * fastSum(n/2) + (n/2) * (n/2);
    }

    public static int simplySum(int n) {
        return (n*(n+1)) / 2;
    }

    public static void main(String[] args) {

        System.out.println(fastSum(9));

        System.out.println(simplySum(9));


    }
}
