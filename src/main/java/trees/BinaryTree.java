package trees;

public class BinaryTree<E> {
    BinaryNode<Integer> root;
    public static class BinaryNode<E> {
        public E value;
        public BinaryNode left;
        public BinaryNode right;
        public int height;
    }

    public BinaryTree() {
        this.root = null;
    }

    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value + " ");

        preOrder(node.left);
        preOrder(node.right);
    }
}
