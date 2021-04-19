package Other;

import java.util.Scanner;

public class BrianKernighanAlgorithm {

	/*
	 * @param num : number in which we count the set bits
	 * @return int : Number of set bits
	 * */
	
	
	/* 1111(2) -> 8 4 2 1 = 15
	 * #1   1111
	 *    & 1110
	 *      1110
	 * 
	 * #2   1110
	 *    & 1101
	 *      1100
	 *      
	 * #3   1100
	 *    & 1011
	 *      1000
	 *      
	 * #4   1000
	 *      0999
	 *      0000
	 * 
	 *      result => 4
	 * 
	 * */
	private static int countSetBits(int num)
	{
		int cnt = 0;
		while (num != 0)
		{
			num = num & (num - 1);
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int setBitCount = countSetBits(num);
		System.out.println(setBitCount);
		sc.close();
	}
}
