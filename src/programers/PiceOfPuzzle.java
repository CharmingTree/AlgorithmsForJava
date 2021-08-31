package programers;

import java.util.*;

class Pice {
    boolean isHead = false;
    Pice() {}
    Pice(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Pice left;
    Pice right;
    Pice up;
    Pice down;

    int x = 0, y = 0;


}

public class PiceOfPuzzle {

    void display(Pice p) {

        if( p == null)
            return;

        System.out.println(p);

        if (p.right != null) {
            System.out.print("오른쪽   ");
            display(p.right);
        }
        if (p.down != null) {
            System.out.print("아래    ");
            display(p.down);
        }

        if (p.left != null) {
            System.out.print("왼쪽    ");
            display(p.left);
        }

        if (p.up != null) {
            System.out.print("위     ");
            display(p.up);
        }
    }

    void rotaion(Pice p) {
        if (p == null)
            return;

        Pice tempLeft = p.left;
        Pice tempRight = p.right;
        Pice tempUp = p.up;
        Pice tempDown = p.down;

        p.down = tempRight;
        p.left = tempDown;
        p.up = tempLeft;
        p.right = tempUp;

        if (tempRight != null) {
            rotaion(tempRight);
        }


        if (tempDown != null) {
            rotaion(tempDown);
        }


        if (tempLeft != null) {
            rotaion(tempLeft);
        }


        if (tempUp != null) {
            rotaion(tempUp);
        }
    }

    Pice findPice(int x, int y, int[][] table) {
        //System.out.println(">> "+x +", "+ y);

        if (y < 0 || x < 0 )
            return null;

        if (y >= table.length || x >= table[y].length )
            return null;

        if (table[y][x] == 0) {
            return null;
        }
        table[y][x] = 0;
        Pice ret = new Pice(x,y);
        ret.up = findPice(x, y-1, table); // up
        ret.right = findPice(x+1, y, table); // right
        ret.down = findPice(x, y+1, table); // down
        ret.left = findPice(x-1,y, table);// left
        return ret;
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;


        return answer;
    }



    public static void main(String[] args) {

//        Pice head = new Pice("G");
//        head.data = 0;
//
//
//        Pice left = new Pice("LG");
//        left.data = -1;
//
//        head.left = left;
//
//        Pice leftleft = new Pice("LLG");
//        leftleft.data = -2;
//
//        left.left = leftleft;
//
//        Pice right = new Pice("GR");
//        right.data = 1;
//        head.right = right;
//
//        Pice down = new Pice("GD");
//        down.data = 10;
//
//        head.down = down;



        PiceOfPuzzle piceOfPuzzle = new PiceOfPuzzle();

//        piceOfPuzzle.display(head);
//        System.out.println("----------------------");
//
//        piceOfPuzzle.rotaion(head);
//
//        piceOfPuzzle.display(head);
        int[][] table = new int[][] {
                {1,0,0,1,1,0},
                {1,0,1,0,0,0},
                {0,1,1,1,1,1},
                {0,0,1,0,0,0},
                {1,1,0,1,1,0},
                {0,1,0,0,0,0}};

        Pice tt = piceOfPuzzle.findPice(1,2, table);
        tt.isHead = true;

        piceOfPuzzle.display(tt);

        piceOfPuzzle.rotaion(tt);
        System.out.println("-----------------");
        piceOfPuzzle.display(tt);

        piceOfPuzzle.solution(new int[][] {
                        {1,1,0,0,1,0},
                        {0,0,1,0,1,0},
                        {0,1,1,0,0,1},
                        {1,1,0,1,1,1},
                        {1,0,0,0,1,0},
                        {0,1,1,1,0,0}},

        new int[][] {
                {1,0,0,1,1,0},
                {1,0,1,0,1,0},
                {0,1,1,0,1,1},
                {0,0,1,0,0,0},
                {1,1,0,1,1,0},
                {0,1,0,0,0,0}});
    }
}
