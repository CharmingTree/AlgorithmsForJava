package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class NumberSet {
	
	public static int[] solution(int[] numbers) {
        
        HashSet<Integer> s = new HashSet<Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
        	for (int j = i+1; j < numbers.length; j++) {
        		int temp = numbers[i] + numbers[j];
        		s.add(temp);
        	}
        }
        
        ArrayList<Integer> nList = new ArrayList<>(s);
        Collections.sort(nList);
        
        return nList.stream().mapToInt(i->i.intValue()).toArray();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(new int[] {2,1,3,4,1});
	}

}
