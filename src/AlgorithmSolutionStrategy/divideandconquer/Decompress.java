package AlgorithmSolutionStrategy.divideandconquer;

import java.util.Iterator;

public class Decompress {

    static char[][] decompressed = new char[20][20];

    void decompress(String s, int it, int y, int x, int size) {

        if (s.length() <= it)
            return;
        char head = s.charAt(it);
        System.out.println(head +" "+it);


        if (head == 'b' || head == 'w') {
            for (int dy = 0; dy < size; ++dy) {
                for (int dx = 0; dx < size; ++dx) {
                    decompressed[y+dy][x+dx] = head;
                }
            }
        }
        else {
            int half = size / 2;
            decompress(s, it+1, y, x, half);
            decompress(s, it+2, y, x+half, half);
            decompress(s, it+3, y+half, x, half);
            decompress(s, it+4, y+half, x+half, half);
        }
    }

    public static void main(String[] args) {

        Decompress decompress = new Decompress();

        for (int i = 0; i < decompressed.length; i++) {
            for ( int j = 0; j < decompressed[i].length; j++) {
                System.out.print(decompressed[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        String s ="xwbbw";

        decompress.decompress(s, 0, 0, 0 , decompressed.length);

        for (int i = 0; i < decompressed.length; i++) {
            for ( int j = 0; j < decompressed[i].length; j++) {
                System.out.print(decompressed[i][j]+" ");
            }
            System.out.println();
        }
    }
}
