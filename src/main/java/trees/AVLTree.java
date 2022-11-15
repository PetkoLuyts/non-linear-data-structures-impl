package trees;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    public BinaryNode root;

    public static class BinaryNode {
        public int value;
        public int height;
        public BinaryNode left;
        public BinaryNode right;
    }

    public AVLTree() {
        this.root = null;
    }

    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

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

    public BinarySearchTree.BinaryNode search(BinarySearchTree.BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value " + value + " not found in AVL");
            return null;
        } else if (node.value == value) {
            System.out.println("Value " + value + " found in AVL");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
}
