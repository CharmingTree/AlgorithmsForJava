package AlgorithmSolutionStrategy.ExhaustiveSearch;

public class Picnic {
    int n = 4;
    boolean[][] areFriends = new boolean[10][10];

    public int countpairings(boolean[] taken) {
        int firstFree = -1;
        for (int i = 0; i < n; i++) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }
        //System.out.println(finished);

        if (firstFree == -1)
            return 1;
        int ret = 0;

        for (int pairWith = firstFree+1; pairWith < n; ++pairWith) {
            if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
                taken[firstFree] = true;
                taken[pairWith] = true;
                ret += countpairings(taken);
                taken[firstFree] = false;
                taken[pairWith] = false;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        boolean[] taken = new boolean[10];

        Picnic picnic = new Picnic();

        picnic.areFriends[0][1] = true;
        picnic.areFriends[1][2] = true;
        picnic.areFriends[2][3] = true;
        picnic.areFriends[3][0] = true;
        picnic.areFriends[0][2] = true;
        picnic.areFriends[1][3] = true;



        System.out.println(picnic.countpairings(taken));


    }
}
