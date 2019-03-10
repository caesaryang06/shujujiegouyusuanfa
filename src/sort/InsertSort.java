package sort;

import java.util.Arrays;

/**
 * 直接 插入排序  循环操作第一个元素之后的每个元素（从第一个元素开始  用这个元素跟前面的元素进行比较 如果该元
 *          素小于前面的元素  就将前面的元素向前移动 直到前面的
 *          元素小于当前元素  这时就当前元素赋给前面元素+1的位置）
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12,56,23,89,16,8};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int tmp;
        int j;
      for (int i=1;i<arr.length;i++){
          //将数组中的第i个元素赋值给tmp
          tmp = arr[i];
         for (j=i-1;j>=0&&tmp<arr[j];j--){
                 arr[j+1] = arr[j];
         }
         arr[j+1] = tmp;
      }
    }
}
