package binaryTree.avl;

public class Node {

    int value;

    Node left;

    Node right;

    public Node(int value ){
        this.value = value;
    }

    /**
     * 返回当前节点的高度
     * @return
     */
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height()) +1;
    }


    /**
     * 获取左子树的高度
     * @return
     */
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    /**
     * 获取右子树的高度
     * @return
     */
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
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

       //添加节点完成以后 查询是否平衡
        //进行右旋
        if (leftHeight()-rightHeight()>=2){
            //双旋转之先左后右
            if (left!=null && left.leftHeight()<left.rightHeight()){
                left.leftRotate();
                rightRotate();
            //单右旋
            }else{
                rightRotate();
            }
        }
        //进行左旋
        if (rightHeight()-leftHeight()>=2){
            //双旋转之选右后左
            if (right!=null && right.rightHeight()<right.leftHeight()){
                right.rightRotate();
                leftRotate();

            }else {
                leftRotate();
            }
        }

    }

    /**
     * 左旋  跟右旋相反
     */
    private void leftRotate() {

        Node newNode = new Node(value);

        newNode.left = left;

        newNode.right = right.left;

        value = right.value;

        right = right.right;

        left = newNode;
    }

    /**
     * 右旋
     */
    private void rightRotate() {
        //1.创建一个新节点  新节点的值等于当前节点的值
        Node newNode = new Node(value);
        //2.让新节点的右节点等于当前节点的右节点
        newNode.right = right;
        //3.新节点的左节点设置为当前节点的左子节点的右子节点
        newNode.left = left.right;
        //4.将当前节点的值修改为左子节点的值
        value = left.value;
        //5.将当前节点的左子节点的左子节点指向当前节点的左子节点
        left = left.left;
        //6.将新节点指向当前节点的右子节点
        right = newNode;
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
