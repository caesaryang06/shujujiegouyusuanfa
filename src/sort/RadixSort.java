package sort;

import java.util.Arrays;

/**
 * 基数排序   循环的次数由最大数的位数决定
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{123,12,456,56,345,23,1,89,16,8};
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        //存数组中最大数
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //计算最大值是几位数
        int maxLength = (max+"").length();
        //用于临时存储数据的数组
        int[][] tmp = new int[10][arr.length];

        //用于记录tmp相应的数组中存放的数字的数量
        int[] counts = new int[10];
        //根据最大数的位数决定比较的次数
        for (int j=0,n=1;j<maxLength;j++,n*=10){
            //把每个数字分别计算余数
            for (int k=0;k<arr.length;k++){
                int ys = arr[k]/n%10;
                tmp[ys][counts[ys]] = arr[k];
                //记录数量
                counts[ys]++;
            }
            int index = 0;//记录放回原数组的位置
            for (int g=0;g<counts.length;g++){
                if (counts[g]!=0){
                    for (int f=0;f<counts[g];f++){
                     arr[index++] = tmp[g][f];
                    }
                    //将数量置为空
                    counts[g] = 0;
                }
            }
        }
    }
}
