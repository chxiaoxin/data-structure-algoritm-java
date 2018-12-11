public class RedBlackTree {

    private static final boolean Red = true;
    private static final boolean Black = false;
    private Node root;

    private class Node {
        int key;
        Node left;
        Node right;
        int N;
        int value;
        boolean color;

        Node(int key, Node left, Node right, int N, int vlaue, boolean color) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.N = N;
            this.value = value;
            this.color = color;
        }
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == Red;
    }

    public Node rotateLeft(Node node) {
        Node right = node.right;
        Node rightSubLeft = right.left;
        node.right = rightSubLeft;
        right.left = node;
        right.color = node.color;
        node.color = Red;
        right.N = node.N;
        node.N = 1 + node.left.N + node.right.N;
        return right;
    }

    public Node rotateRight(Node node) {
        Node left = node.left;
        Node leftSubRight = left.right;
        node.left = leftSubRight;
        left.right = node;
        left.color = node.color;
        node.color = Red;
        left.N = node.N;
        node.N = 1 + node.left.N + node.right.N;
        return left;
    }

    public void flipColors(Node node) {
        node.left.color = Black;
        node.right.color = Black;
        node.color = Red;
    }

    public void put(int key, int value) {
        root = put(root, key, value);
        root.color = Black;
    }

    public Node put(Node node, int key, int value) {
        if (node == null) {
            return new Node(key, null, null, 1, value, Red);
        }

        if (key > node.key) node.right = put(node.right, key, value);
        if (key < node.key) node.left = put(node.left, key, value);
        if (key == node.key) node.value = value;

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        node.N = node.left.N + node.right.N + 1;

        return node;
    }
}
