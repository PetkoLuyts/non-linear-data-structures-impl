package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
    BinaryNode<E> root;
    public static class BinaryNode<E> {
        public E value;
        public BinaryNode left;
        public BinaryNode right;
        public int height;
    }

    public BinaryTree() {
        this.root = null;
    }

    // DFS
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value + " ");

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    // BFS
    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();

            System.out.print(presentNode.value + " ");

            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }

            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }
}
