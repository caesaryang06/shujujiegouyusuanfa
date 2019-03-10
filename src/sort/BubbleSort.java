package sort;

import java.util.Arrays;

/**
 * 冒泡排序 升序
 */
public class BubbleSort {

    public static void testMethod(int start){
        start--;
        System.out.println(start);
    }

    public static void main(String[] args) {
        testMethod(12);
        int[] arr = new int[]{12,56,23,89,16,8};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
       int tmp;
        for (int i=0;i<arr.length-1;i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }

        }
    }



}
