package AlgorithmSolutionStrategy.divideandconquer;

public class Multiply {

    int[] multiply(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < b.length; j++) {
                c[i+j] += a[i] * b[j];
            }
        }

        for (int i : c) {
            System.out.print(i +" ");
        }
        System.out.println();
        normalize(c);
        for (int i : c) {
            System.out.print(i +" ");
        }
        System.out.println();
        return c;
    }

    void normalize(int[] num) {

        for (int i = num.length-1; i > 0; i--) {
            num[i-1] += num[i] / 10;
            num[i] %= 10;
        }
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();

        multiply.multiply(new int[] {9,9,9,9}, new int[] {9,9,9,9});
    }
}
