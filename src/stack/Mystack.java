package stack;

public class Mystack {

    private int[] elements;

    public Mystack(){
        elements = new int[0];
    }

    //压入元素
    public void push(int element){
        int[] newArr = new int[elements.length+1];
        for (int i=0;i<elements.length;i++){
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    //取出栈顶元素
    public int pop(){
        //判断栈中是否有元素
        if (elements.length == 0){
            throw  new RuntimeException("stack is empty");
        }
        //取出元素
        int element = elements[elements.length-1];

        int[] newArr =  new int[elements.length-1];
        for (int i=0;i<newArr.length;i++){
            newArr[i] = elements[i];
        }
        //替换数组
        elements = newArr;

        return element;
    }

    //查看栈顶元素
    public int peek(){
        //判断栈中是否有元素
        if (elements.length == 0){
            throw  new RuntimeException("stack is empty");
        }
        return elements[elements.length-1];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return elements.length == 0;
    }

}
