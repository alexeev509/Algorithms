package Trees;

public class Node {
    Node leftNode;
    Node rightNode;
    Integer value;

    public Node(Node leftNode, Node rightNode, Integer value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public Node(Integer value) {
        this.value = value;
    }
}
