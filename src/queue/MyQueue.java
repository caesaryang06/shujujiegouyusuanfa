package queue;

/**
 * 自定义队列
 */
public class MyQueue {

    private int[] elements;

    public MyQueue(){
        elements = new int[0];
    }

    //入队
    public void add(int element){
        int[] newArr = new int[elements.length+1];
        for (int i=0;i<elements.length;i++){
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    //出队
    public int poll(){
        //出队之前要判断是否有元素
        if (elements.length==0){
            throw new RuntimeException("queue is empty");
        }
        //取出0位置的元素
        int element = elements[0];

       int[] newArr = new int[elements.length-1];
        for (int i=0;i<newArr.length;i++){
            newArr[i] = elements[i+1];
        }
        //原数组指向新数组
        elements = newArr;
        return element;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }

}
