package Sets;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 멱집합 메모리 낭비 하지 않고 생성 */
public class PowerSet {
	
	public static final <E> Collection<Set<E>> of(Set<E> s) {
		List<E> src = new ArrayList<>(s);
		if (src.size() > 30)
			throw new IllegalArgumentException();
		return new AbstractList<Set<E>>() {
			public int size() {
				return 1 << src.size(); // 2^n 
			}
			public boolean contains(Object o) {
				return o instanceof Set && src.containsAll((Set)o);
			}
			public java.util.Set<E> get(int index) 
			{
				Set<E> result = new HashSet<>();
				for (int i = 0; index != 0; i++, index >>= 1) {
					if ((index & 1) == 1) {
						result.add(src.get(i));
					}
				}
				return result;
			}
		};
	}

	public static void main(String[] args) {
		Set s = new HashSet(Arrays.asList("a","b","c"));
		System.out.println(PowerSet.of(s));

	}

}
