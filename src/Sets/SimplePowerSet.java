package Sets;

import java.util.ArrayList;
import java.util.HashSet;

public class SimplePowerSet {
	
	public static void disPset(ArrayList<Object> lst) {
		
		ArrayList<Object> ps = new ArrayList<>();
		System.out.println(1<<lst.size());
		for (int i = 0; i < 1<<lst.size(); i++) {
			HashSet<Object> subSet = new HashSet<>();
			for (int j = 0; j < lst.size(); j++ ) {
				if( (i & 1<<j) != 0)
				{
					System.out.println(i+" >>> "+j);
					subSet.add(lst.get(j));
				}
					
			}
			ps.add(subSet);
		}
		
		System.out.println(ps);
	}

	public static void main(String[] args) {
		ArrayList<Object> myList = new ArrayList<>();
		
		myList.add('a');
		myList.add('b');
		myList.add('c');
		
		disPset(myList);

	}

}
