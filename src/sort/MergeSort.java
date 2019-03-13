package sort;

import java.util.Arrays;

/**
 * 归并排序   整体思想就是递归的思想
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12,56,23,89,16,8};

        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void merge(int[] arr,int start,int mid,int end){
        //用于存储归并后的临时数组
        int[] tmp = new int[end-start+1];
        int  index = 0;
        //记录第一个数组中需要遍历的下标
        int i = start;
        //记录第二个数组中需要遍历的下标
        int j = mid+1;
        //遍历两个数组取出小的数字，放入临时数组中
        while (i<=mid && j<=end){
            //第一个数组的数据更小
            if (arr[i]<=arr[j]){
                tmp[index] = arr[i];
                //下标向后移一位
                i++;
            }else{
                tmp[index] = arr[j];
                j++;
            }

            //临时数组中插入元素后  下标向后移动一位
            index++;
        }
        //处理多余的数据  可能是数组一  也可能是数组二
        while(i<=mid){
            tmp[index++] = arr[i];
            i++;
        }
        while (j<=end){
            tmp[index++] = arr[j];
            j++;
        }
        //数据处理完后  将临时数组中的数据重新存入原数组
        for (int k=0;k<tmp.length;k++){
            arr[start++] = tmp[k];
        }





    }



    //归并排序
    public static void sort(int[] arr,int start,int end){

        int mid = (start+end)/2;
       if (start<end) {
           //处理左边
           sort(arr, start, mid);

           //处理右边
           sort(arr, mid+1, end);

           //归并
           merge(arr, start, mid, end);
       }


    }
}
