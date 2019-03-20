package binaryTree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        byte[] b = new byte[]{114};
        System.out.println(new String(b));
        int[] arr = new int[] {3,7,8,29,5,11,23,14};
        Node huffManTree = createHuffManTree(arr);
        System.out.println(huffManTree);
    }

    /**
     * 创建赫夫曼树
     * @param arr
     * @return
     */
    public static Node createHuffManTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        //先使用数组中的所有的元素创建若干个二叉树  当然只有一个节点
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //循环处理
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出权值最小的两个二叉树
            Node lNode = nodes.get(nodes.size()-1);
            Node rNode = nodes.get(nodes.size()-2);
             //创建一颗新的二叉树
            Node parent = new Node(lNode.getValue()+ rNode.getValue());
            parent.setlNode(lNode);
            parent.setrNode(rNode);
            //把取出来的两个二叉树移除
            nodes.remove(lNode);
            nodes.remove(rNode);
            //放入原来的二叉树集合中
            nodes.add(parent);
        }

        return nodes.get(0);
    }
}
