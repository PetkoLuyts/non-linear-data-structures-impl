package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
    private BinaryNode<E> root;
    private static class BinaryNode<E> {
        private E value;
        private BinaryNode left;
        private BinaryNode right;
        private int height;
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

    public void search(E value) {
        Queue<BinaryNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();

            if (presentNode.value == value) {
                System.out.println("The value - " + value + "is found in Tree");
                return;
            } else {
                if (presentNode.left != null) {
                    queue.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    queue.add(presentNode.right);
                }
            }
        }

        System.out.println("The value - " + value + "is not found in Tree");
    }

    public void insert(E value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            System.out.println("Inserted new node at root");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();

            if (presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("Successfully inserted");
                break;
            } else if (presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("Successfully inserted");
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;

        while (!queue.isEmpty()) {
            presentNode = queue.remove();

            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }

        return presentNode;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;

        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();

            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }

            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    public void deleteNode(E value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();

            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node is deleted!");
                return;
            } else {
                if (presentNode.left != null) queue.add(presentNode.left);
                if (presentNode.right != null) queue.add(presentNode.right);
            }
        }

        System.out.println("The node does not exist in this BT");
    }

    public void deleteBinaryTree() {
        root = null;
        System.out.println("The binary tree has been deleted successfully!");
    }
}
