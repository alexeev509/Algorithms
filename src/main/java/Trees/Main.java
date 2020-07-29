package Trees;

public class Main {
    static int summ = 0;

    public static void main(String[] args) {
//        Node root=new Node();
//        Node left_1=new Node();

        Node leave_1 = new Node(8);
        Node leave_2 = new Node(9);
        Node leave_3 = new Node(5);
        Node leave_4 = new Node(6);
        Node leave_5 = new Node(7);

        Node node_1 = new Node(leave_1, leave_2, 4);
        Node node_2 = new Node(leave_4, leave_5, 3);
        Node node_3 = new Node(node_1, leave_3, 2);

        Node root = new Node(node_3, node_2, 1);

        dfs(root, 0);
        System.out.println(summ);
    }

    public static void dfs(Node currentNode, int depth) {
        summ += depth;
        if (currentNode.leftNode != null)
            dfs(currentNode.leftNode, depth + 1);
        if (currentNode.rightNode != null)
            dfs(currentNode.rightNode, depth + 1);

    }
}
