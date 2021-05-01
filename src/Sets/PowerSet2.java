package Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PowerSet2 {
	
	public static void getPowerSet(ArrayList<Object> lst) {
		ArrayList<Object> pSet = new ArrayList<>();
		
		String fm = "%0"+lst.size()+"d";
		
		for ( int i = 1; i < Math.pow(2, lst.size()); i++) {
			String flag = String.format(fm, Integer.parseInt(Integer.toBinaryString(i)));
			System.out.println(flag);
			ArrayList<Object> subSet = new ArrayList<>();
			//Set<Object> subSet2 = new HashSet<>();
			//Set<Object> subSet3 = new TreeSet<>();
			for (int j = 0; j < lst.size(); j++) {
				if (flag.charAt(j) == '1') {
					subSet.add(lst.get(j));
					//subSet2.add(lst.get(j));
					//subSet3.add(lst.get(j));
					
				}
			}
			pSet.add(subSet);
		}
		
		System.out.println(pSet);
	}

	public static void main(String[] args) {
		ArrayList<Object> myList = new ArrayList<>();
		
		myList.add(1);
		myList.add(2);
		myList.add(3);
		
		getPowerSet(myList);
		
	}

}
