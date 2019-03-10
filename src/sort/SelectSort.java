package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12,56,23,89,16,8};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){

        for (int i=0;i<arr.length;i++){
            //记录数组中最小值的索引
            int minIndex = i;
            for (int j= i+1;j<arr.length;j++){
                if (arr[j] < arr[minIndex]){
                     minIndex = j;
                }
            }
            //如果当前元素跟最小数不相等的时候
            if (i != minIndex) {
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }

    }
}
