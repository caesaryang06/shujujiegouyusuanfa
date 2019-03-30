package binaryTree.binarysortTree;

public class Node {

    int value;

    Node left;

    Node right;

    public Node(int value ){
        this.value = value;
    }

    /**
     * 向子树中添加节点
     * @param node
     */
    public void add(Node node) {
        if (node == null){
            return;
        }
        //判断传入的节点的值跟当前节点的大小
        if (this.value>node.value){//传入节点的值小于当前节点的值
            if (this.left==null){//左子节点为空
                this.left = node;
            }else {//左子节点不为空
                this.left.add(node);
            }

        }else{//传入节点的值大于当前节点的值
             if (this.right == null){
                 this.right = node;
             }else{
                 this.right.add(node);
             }
        }

    }

    /**
     * 中序遍历
     * @param node
     */
    public void midShow(Node node) {

        if (node == null){
            return;
        }

        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);


    }


    public Node search(int value) {

        if (this.value == value){
            return this;
        }

        if (this.value>value ){
            if (left==null){
                return null;
            }else{
              return left.search(value);
            }
        }else{
            if (right==null){
                return null;
            }else {
               return right.search(value);
            }
        }
    }

    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {

        if ((this.left!=null && this.left.value==value) || (this.right!=null && this.right.value==value)){
            return this;
        }else{
            if (this.value>value && this.left!=null){
               return this.left.searchParent(value);
            }else if (this.value<value && this.right!=null){
                return this.right.searchParent(value);
            }

            return null;
        }

    }
}
