package programers;

import java.util.Random;

public class SortTest {

    public void selectSort(int[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int minNum = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minNum] > arr[j]) {
                    minNum = j;
                }
            }
            int temp = arr[minNum];
            arr[minNum] = arr[i];
            arr[i] = temp;
        }

        long endTime = System.nanoTime();
        System.out.println("SelectSort ExcuteTime : " + (endTime-startTime) + " ns");

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void insertSort(int[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("InsertionSort ExcuteTime : " + (endTime-startTime) + " ns");
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SortTest obj = new SortTest();

        Random random = new Random();

        int[] nums = new int[1000];

        for (int i = 0; i < 1000; i++) {
            nums[i] = random.nextInt(10000);
        }

        //obj.selectSort(new int[] {9, 19, 1, 2, 3, 5, 58 ,38 ,8, 0});
        obj.insertSort(nums.clone());
        obj.selectSort(nums.clone());

        //obj.insertSort(new int[] {9, 19, 1, 2, 3, 5, 58 ,38 ,8, 0});
    }
}
