package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MathGiveUp {
	
	public static int[] solution(int[] answers) {
		
		int[] a = { 1, 2, 3, 4, 5};
		int a_len = a.length;
		
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5};
		int b_len = b.length;
		
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int c_len = c.length;
		
		Integer[] score = {0,0,0};
		   
        for (int i = 0; i < answers.length; i++) {
        	
        	if (a[i%a_len] == answers[i]) {
        		score[0]++;
        	}
        	
        	if (b[i%b_len] == answers[i]) {
        		score[1]++;
        	}
        	
        	if (c[i%c_len] == answers[i]) {
        		score[2]++;
        	}        		
        }
        ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(score));
        int maxNum = Collections.max(temp);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
        	if (temp.get(i) == maxNum) {
        		ans.add(i+1);
        	}
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }

        return answer;
    }

	public static void main(String[] args) {
		
		solution(new int[] {1,2,3,4,5});
		solution(new int[] {1,3,2,4,2});
	}

}
