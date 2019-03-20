package binaryTree.huffmanCode;

public class Node implements Comparable<Node>{

    private Byte data;

    private int weight;

    private Node lNode;

    private Node rNode;


    public Node(int weight) {
        this.weight = weight;
    }

    public Node(int weight, Byte data){
        this.weight = weight;
        this.data = data;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
    public int compareTo(Node o) {
        return -(this.weight-o.weight);
    }
}
