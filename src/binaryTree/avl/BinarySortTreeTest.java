package binaryTree.avl;

public class BinarySortTreeTest {

    public static void main(String[] args) {

        int[] arr = new int[] {8,9,6,7,5,4};

        //创建一颗二叉排序树
        BinarySortTree bTree = new BinarySortTree();
        //循环添加节点
        for (int i : arr) {
            bTree.add(new Node(i));
        }
        //查看树的高度
        System.out.println(bTree.root.height());
        System.out.println(bTree.root.value);


    }
}
