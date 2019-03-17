package sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2};
         sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void  sort(int[] arr){
        //开始位置是最后一个非叶子节点 即最后一个节点的父节点
        int start = (arr.length-2)/2;
        //调整为大顶堆
        for (int i=start;i>=0;i--){
            maxHeap(arr,arr.length,i);
        }
        System.out.println(Arrays.toString(arr));
        //循环遍历
       for (int j = arr.length-1;j>0;j--){
            int tmp = arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
            maxHeap(arr,j,0);
       }
    }

    /**
     * 将数组转成大顶堆
     * @param arr  数组
     * @param size 要转成大顶堆数组的size
     * @param index 要调整哪一个
     */
    public static void maxHeap(int[] arr,int size,int index){
        //左子节点
        int leftNode = 2*index+1;

        //右子节点
        int rightNode = 2*index+2;
        int max = index;
        //和两个子节点分别对比，找出最大的节点
        if (leftNode < size && arr[leftNode] > arr[max]){
            max = leftNode;
        }

        if (rightNode < size && arr[rightNode] > arr[max]){
            max = rightNode;
        }
        //交换位置
        if (max!=index){
            int tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            //交换位置以后  可能会破坏之前排好的堆，所以，之前的排好的堆要重新调整
            maxHeap(arr,size,max);
        }

    }

}
