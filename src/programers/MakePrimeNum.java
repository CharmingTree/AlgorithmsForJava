package programers;

public class MakePrimeNum {

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {

            for ( int j = i+1; j < nums.length; j++) {

                for ( int k = j+1; k < nums.length; k++) {
                    if (isPrimeNum(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }


        return answer;
    }

    boolean isPrimeNum(int num) {
        //System.out.println(num);
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        MakePrimeNum obj = new MakePrimeNum();

        System.out.println(obj.solution(new int[] {1,2,3,4}));
        System.out.println(obj.solution(new int[] {1,2,7,6,4}));

    }
}
