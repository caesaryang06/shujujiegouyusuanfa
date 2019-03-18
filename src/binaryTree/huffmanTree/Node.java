package binaryTree.huffmanTree;

public class Node implements Comparable<Node>{

    private int value;

    private Node lNode;

    private Node rNode;

    @Override
    public int compareTo(Node o) {
        return -(this.value-o.value);
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getlNode() {
        return lNode;
    }

    public void setlNode(Node lNode) {
        this.lNode = lNode;
    }

    public Node getrNode() {
        return rNode;
    }

    public void setrNode(Node rNode) {
        this.rNode = rNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
