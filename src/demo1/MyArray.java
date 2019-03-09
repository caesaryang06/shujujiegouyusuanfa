package demo1;

import java.util.Arrays;

public class MyArray {

    private int[] elements;

    public MyArray(){
        elements = new int[0];
    }


    //获取长度的方法
    public int size(){
        return elements.length;
    }

    //添加元素
    public void add(int element){
        int[] newArr = new int[elements.length+1];
        for (int i=0;i<elements.length;i++){
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    //遍历元素
    public void show(){
        System.out.println(Arrays.toString(elements));
    }

    //删除数组中的元素
    public void delete(int index){
        if (index < 0 || index >= elements.length){
            new RuntimeException("下标越界");
        }
       int[] newArr = new int[elements.length-1];
        for (int i = 0;i<newArr.length;i++){

            if (i<index){
                newArr[i] = elements[i];
            }else {
                newArr[i] = elements[i+1];
            }

        }
        elements = newArr;
    }

    //获取某个元素
    public int get(int index){
        if (index < 0 || index >= elements.length){
            new RuntimeException("下标越界");
        }
        return elements[index];
    }

    //插入某个元素到指定位置
    public void insert(int index,int element){
        if (index < 0 || index >= elements.length){
            new RuntimeException("下标越界");
        }
         int[] newArr = new int[elements.length+1];
         for (int i=0;i<elements.length;i++){
             if (i<index){
                 newArr[i] = elements[i];
             }else {
                 newArr[i+1] = elements[i];
             }
         }
         newArr[index] = element;

         elements = newArr;
    }

    //替换指定位置的元素
    public void set(int index,int element){
        if (index < 0 || index >= elements.length){
            new RuntimeException("下标越界");
        }
        elements[index] = element;
    }

    //线向查找元素
    public int search(int desc){
        for (int i=0;i<elements.length;i++){
           if (desc == elements[i]){
               return i;
           }
        }
        return -1;
    }

    //二分查找 使用条件 数组是有序的
    public int binarySearch(int desc){
        int start = 0;
        int end = elements.length-1;
        int mid = (start + end)/2;
        while (start <= end){
            if (elements[mid] == desc){
                return mid;
            }else {
                if (elements[mid] > desc){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }

            mid = (start + end)/2;
        }

        return -1;
    }


}
