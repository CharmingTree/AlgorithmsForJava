package programers;

import java.util.*;
import java.util.stream.Collectors;

public class phonecketMon {

    public int solution2(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }


    public int solution(int[] nums) {
        long startTime = System.nanoTime();
        int answer = 0;
        int temp = nums.length / 2;
        HashSet<Integer> phoneChetMons = new HashSet<>();
        for (int i : nums)
            phoneChetMons.add(i);
        //System.out.println(phoneChetMons);
        int result = phoneChetMons.size() >= temp ? temp : phoneChetMons.size();
        long endTime = System.nanoTime();
        System.out.println("Excute Time : " + (endTime-startTime) + " ns");
        return result;
    }



    public static void main(String[] args) {

//        System.out.println(new phonecketMon().solution(new int[] {3,1,2,3}));
//
//        long startTime = System.nanoTime();
//        new phonecketMon().solution2(new int[] {3,1,2,3});
//
//        long endTime = System.nanoTime();
//        System.out.println("Excute Time : " + (endTime-startTime) + " ns");


        long currentMs = System.currentTimeMillis() / 1000;

        System.out.println(((currentMs / 86400) / 365 ) + 1970);

        // 60 * 60 * 24 *
    }
}
