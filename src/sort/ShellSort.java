package sort;

import java.util.Arrays;

/**
 * 插入排序之希尔排序（比直接插入排序更优）
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12,56,23,89,16,8};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr){
        //遍历所有步长
        for (int d = arr.length/2;d>0;d/=2){
           //遍历所有元素
            for (int i=d;i<arr.length;i++){
                //遍历本组中的所有元素
                for (int  j=i-d;j>=0;j-=d){
                    if(arr[j] >arr[j+d]){
                        int tmp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = tmp;
                    }
                }


            }
        }



    }
}
