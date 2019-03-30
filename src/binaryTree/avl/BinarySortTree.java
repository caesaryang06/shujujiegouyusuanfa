package binaryTree.avl;

/**
 * 二叉排序树-- 之平衡二叉树（avl）
 */
public class BinarySortTree {

    Node root;

    public void add(Node node){

        if (root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void midShow(){
        if (root!=null){
            root.midShow(root);
        }
    }

    /**
     * 查找
     * @param value
     * @return
     */
    public Node search(int value){

        if (root == null){
            return null;
        }
       return root.search(value);
    }

    /**
     * 删除节点
     * @param value
     */
    public void delete(int value){

        if (root == null){
            return;
        }else{
            //找到这个节点
            Node target = search(value);
            if (target == null){
                return;
            }
            //查找父节点
            Node parentNode = searchParent(value);
            //删除的是叶子节点
            if (target.left==null && target.right==null){
                if (parentNode.value>value){
                    parentNode.left = null;
                }else{
                    parentNode.right = null;
                }
             //删除的是有两个子节点的节点
            }else if (target.left!=null && target.right!=null){
                //删除右子树中值最小的节点 获取到该节点的值
                int min = deleteMin(target.right);
                //替换目标节点中的值
                target.value = min;

             //删除的是只有一个子节点的节点
            }else {
               if (parentNode.value>value){
                   if (target.left!=null){
                       parentNode.left = target.left;
                   }else {
                       parentNode.left =target.right;
                   }

               }else{
                   if (target.left!=null){
                       parentNode.right = target.left;
                   }else {
                       parentNode.right =target.right;
                   }
               }

            }
        }
    }

    /**
     * 删除一颗树中的最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target = node;
        while (target.left!=null){
            target = target.left;
        }
        //删除这个节点
        delete(target.value);
        return target.value;
    }

    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public Node searchParent(int value){

        if (root == null){
            return null;
        }
        return root.searchParent(value);
    }

}
