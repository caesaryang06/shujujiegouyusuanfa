package binaryTree;

public class TreeNode {
    //节点的权
    int value;

    //左子节点
    TreeNode lNode;
    //右子节点
    TreeNode rNode;

    public TreeNode(int value){

        this.value = value;
    }

    //设置左节点
    public void setlNode(TreeNode lNode) {
        this.lNode = lNode;
    }
    //设置右节点
    public void setrNode(TreeNode rNode) {
        this.rNode = rNode;
    }


    public void frontShow() {
        System.out.println(value);
        //左节点
        if (lNode != null){
            lNode.frontShow();
        }

        //右节点
        if (rNode != null){
              rNode.frontShow();
        }
    }

    public void midShow() {

        if (lNode != null){
            lNode.midShow();
        }
        System.out.println(value);
        if (rNode != null){
            rNode.midShow();
        }
    }
    //后序遍历
    public void afterShow() {
        if (lNode != null){
            lNode.afterShow();
        }
        if (rNode != null){
            rNode.afterShow();
        }
        System.out.println(value);

    }
    //前序查找
    public TreeNode frontSearch(int i) {
        TreeNode result = null;
        if (i == this.value){
            result = this;
        }else{
            if (lNode != null){
               result = lNode.frontSearch(i);
            }

            if (result == null && rNode != null){
                result = rNode.frontSearch(i);
            }

        }

        //查找结束  返回结果
        return result;
    }
    //删除子树
    public void delete(int i) {

        TreeNode parent = this;

        //判断左儿子
        if (parent.lNode!=null && parent.lNode.value==i){
            parent.lNode = null;
            return;
        }
        //判断右儿子
        if (parent.rNode!=null && parent.rNode.value==i){
            parent.rNode = null;
            return;
        }
        //如果左右子节点都没找到的话
        if (parent.lNode!=null){
            parent = parent.lNode;
            parent.delete(i);
        }
        if (parent.rNode!=null){
            parent = parent.rNode;
            parent.delete(i);
        }


    }
}
