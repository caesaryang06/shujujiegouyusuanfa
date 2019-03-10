package sort;

import java.util.Arrays;

/**
 * 快速排序  就是找第一个元素为基准 比这个基准数字大的放在基准数字的右边  比这个
 * 基准数字小的放在左边 然后递归操作  直到开始位置和结束位置相同
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12,56,23,89,16,8};
        System.out.println(Arrays.toString(arr));

        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr,int start,int end){
        //递归执行的条件
        if (start < end) {

            //把数组中的第0个数字作为标准数
            int stard = arr[start];
            int low = start;
            int high = end;
            //循环找出标准数大的数和比基准数小的数
            while (low < high) {

                while (low < high && stard <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
              //  low++;
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
                // high--;

            }
            //循环结束  开始和结束重复  将标准数赋给重复的位置
            arr[low] = stard;

            //处理所有比标准数小的元素
            sort(arr, 0, low);
            //处理所有比标准数大的元素
            sort(arr, low + 1, end);
        }
    }

}
