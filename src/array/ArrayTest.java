package array;

public class ArrayTest {

    public static void main(String[] args) {

        //解决数组不可变的问题

        MyArray array = new MyArray();
        System.out.println(array.size());
        array.add(4);
        array.add(14);
        array.add(54);
        array.add(68);
        array.add(79);
        array.show();
        System.out.println(array.binarySearch(100));
    }


}
