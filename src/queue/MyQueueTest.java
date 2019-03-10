package queue;

public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(12);
        myQueue.add(34);
        myQueue.add(39);
        myQueue.add(84);
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.poll());
    }
}
