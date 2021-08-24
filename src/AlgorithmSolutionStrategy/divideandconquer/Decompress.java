package AlgorithmSolutionStrategy.divideandconquer;

import java.util.Iterator;

public class Decompress {

    static char[][] decompressed = new char[16][16];
    int it = 0;

    void decompress(String s, int y, int x, int size) {

        if (s.length() <= it)
            return;
        char head = s.charAt(it);
        it++;
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
            decompress(s, y, x, half);
            decompress(s, y, x+half, half);
            decompress(s, y+half, x, half);
            decompress(s, y+half, x+half, half);
        }
    }

    String reserve(String s) {
        char head = s.charAt(it);
        ++it;
        if(head == 'b' || head == 'w')
            return String.valueOf(head);
        String upperLeft = reserve(s);
        String upperRight = reserve(s);
        String lowerLeft = reserve(s);
        String lowerRight = reserve(s);

        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
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

        String s ="xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";

        decompress.decompress(s, 0, 0 , decompressed.length);

        for (int i = 0; i < decompressed.length; i++) {
            for ( int j = 0; j < decompressed[i].length; j++) {
                System.out.print(decompressed[i][j]+" ");
            }
            System.out.println();
        }

        decompress.it = 0;

        System.out.println(decompress.reserve("xbwxwbbwb"));
    }
}
