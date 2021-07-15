package programers;

public class IntactSquare {

    public static long solution(int w, int h) {
        long answer = 1;

        if (w == h)
            return (w*h) - w;
        else if (w == 1 || h == 1) {
            return 0;
        }

        int stdValue = w > h ? w : h;


        int doubleCnt = Math.abs(w-h);

        answer = (stdValue-doubleCnt) + (doubleCnt * 2);

        return (w*h) - answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(3,3));
    }
}
