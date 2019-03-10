package stack;

public class MystackTest {

    public static void main(String[] args) {
        Mystack mystack = new Mystack();
        mystack.push(23);
        mystack.push(56);
        mystack.push(29);
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.isEmpty());
    }
}
