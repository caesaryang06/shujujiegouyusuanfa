package binaryTree.binarysortTree;

public class BinarySortTreeTest {

    public static void main(String[] args) {

        int[] arr = new int[] {7,3,10,12,5,1,9};

        //创建一颗二叉排序树
        BinarySortTree bTree = new BinarySortTree();
        //循环添加节点
        for (int i : arr) {
            bTree.add(new Node(i));
        }
        //查看树中的值
        bTree.midShow();

//        System.out.println("=========================================");
//        Node node = bTree.search(10);
//        System.out.println(node.value);
//        System.out.println("=========================================");
//        Node node1 = bTree.search(100);
//        System.out.println(node1);
          bTree.delete(7);
          bTree.midShow();

    }
}
