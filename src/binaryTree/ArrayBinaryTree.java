package binaryTree;

/**
 * 基于顺序存储的二叉树(完全二叉树  即从上到下  从左到右)
 *
 */
public class ArrayBinaryTree {

    int[] data;
    public ArrayBinaryTree(int[] data){
        this.data = data;
    }
    //前序遍历
    public void frontShow(int index){
        if (data==null || data.length==0){
            return;
        }
        //先遍历当前节点的元素
        System.out.println(data[index]);
        //处理左子节点 2*index+1
        if (2*index+1<data.length){
            frontShow(2*index+1);
        }
        //处理右子节点  2*index+2
        if (2*index+2<data.length){
            frontShow(2*index+2);
        }
    }

    //前序遍历
    public void frontShow(){
        if (data==null || data.length==0){
            return;
        }
        int index = 0;
        //先遍历当前节点的元素
        System.out.println(data[index]);
        //处理左子节点 2*index+1
        if (2*index+1<data.length){
            frontShow(2*index+1);
        }
        //处理右子节点  2*index+2
        if (2*index+2<data.length){
            frontShow(2*index+2);
        }
    }
}
