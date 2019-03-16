package binaryTree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binaryTree = new BinaryTree();
        //创建根节点
        TreeNode root = new TreeNode(1);
        //给树设置根节点
        binaryTree.setRoot(root);

        //创建根节点的两个子节点
        TreeNode lNode = new TreeNode(2);
        TreeNode rNode = new TreeNode(3);

        //设置子节点
        root.setlNode(lNode);
        root.setrNode(rNode);


        //为左子节点设置两个子节点
        lNode.setlNode(new TreeNode(4));
        lNode.setrNode(new TreeNode(5));
        rNode.setlNode(new TreeNode(6));
        rNode.setrNode(new TreeNode(7));

        //前序遍历
        System.out.println("===================前序遍历=============================");
        binaryTree.frontShow();
        //中序遍历
        System.out.println("===================中序遍历=============================");
        binaryTree.midShow();
        //后序遍历
        System.out.println("===================后序遍历=============================");
        binaryTree.afterShow();

        //前序查找
        System.out.println("===================前序查找结果=============================");
        TreeNode result = binaryTree.frontSearch(5);
        System.out.println(result.value);

        //删除子树
        System.out.println("================删除之后遍历查看======================");
        binaryTree.delete(5);
        binaryTree.frontShow();

    }
}
