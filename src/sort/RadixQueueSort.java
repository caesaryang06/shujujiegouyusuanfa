package sort;

import queue.MyQueue;

import java.util.Arrays;

/**
 * 使用自定义队列实现基数排序
 */
public class RadixQueueSort {

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
        //用于临时存储数据的队列数组
        MyQueue[] tmp = new MyQueue[10];
        //为队列数组初始化对象   如果不为队列初始化对象的化  队列调方法会报错
        for (int m=0;m<tmp.length;m++){
            tmp[m] = new MyQueue();
        }
        //根据最大数的位数决定比较的次数
        for (int j=0,n=1;j<maxLength;j++,n*=10){
            //把每个数字分别计算余数
            for (int k=0;k<arr.length;k++){
                int ys = arr[k]/n%10;
                tmp[ys].add(arr[k]);
            }
            int index = 0;//记录放回原数组的位置
            for (int g=0;g<tmp.length;g++){
                //循环从队列中取出数据
                while (!tmp[g].isEmpty()){
                       arr[index++] = tmp[g].poll();
                }
            }
        }
    }
}
