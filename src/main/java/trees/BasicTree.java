package trees;

import java.util.ArrayList;

public class BasicTree<E> {

    public static class TreeNode<E> {
        public E data;
        public ArrayList<TreeNode> children;

        public TreeNode(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public void addChild(TreeNode node) {
            this.children.add(node);
        }

        public String print(int level) {
            String returnString;
            returnString = " ".repeat(level) + data + "\n";

            for (TreeNode node : this.children) {
                returnString += node.print(level + 1);
            }

            return returnString;
        }
    }
}
