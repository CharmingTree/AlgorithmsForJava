package programers;

import java.util.ArrayList;

public class PickDollWithCrane {

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList<Integer> bucket = new ArrayList<>();
        
        for (int i = 0; i < moves.length; i++) {
        	for (int j = 0; j < board.length; j++) {
        		if (board[j][moves[i]-1] != 0) {
        			if (bucket.size() > 0 && bucket.get(bucket.size()-1) == board[j][moves[i]-1]) {
        				answer += 2;
        				bucket.remove(bucket.size()-1);
        			}
        			else {
        				bucket.add(board[j][moves[i]-1]);
        			}       	
        			board[j][moves[i]-1] = 0;
        			break;
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4});
		solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}, new int[] {1, 2, 3});
		solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[] {1, 4});
		solution(new int[][] {{0, 1}, {0, 1}, {5, 5}}, new int[] {2, 2, 1, 2});
		solution(new int[][] {{0, 0}}, new int[] {1, 2});

	}

}
