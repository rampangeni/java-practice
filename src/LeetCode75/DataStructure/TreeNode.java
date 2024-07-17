package LeetCode75.DataStructure;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printBFSTraversal(TreeNode head) {

        System.out.println("*** BFS ***");

        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        System.out.println("*** DONE ***");

        return;
    }

    public void printDFSTraversal(TreeNode head) {

        System.out.println("*** DFS ***");

        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

        }

        System.out.println("*** DONE ***");


        return;
    }

    public TreeNode InvertBinaryTree(TreeNode root) {
        TreeNode result = root;
        if (root == null) {
            return null;
        }

        return result;
    }

    public TreeNode InvertBinaryTreeHelper(TreeNode root) {
        TreeNode result = root;
        if (result == null) {
            return null;
        }


        return result;
    }

    public static void main(String[] args) {
        TreeNode leaf4 = new TreeNode(4);
        TreeNode leaf5 = new TreeNode(5);
        TreeNode leaf6 = new TreeNode(6);
        TreeNode leaf7 = new TreeNode(7);
        TreeNode parent45 = new TreeNode(2, leaf4, leaf5);
        TreeNode parent67 = new TreeNode(3, leaf6, leaf7);
        TreeNode root = new TreeNode(1, parent45, parent67);

        TreeNode head = root;
        root.printBFSTraversal(head);

        head = root;
        root.printDFSTraversal(head);
    }
}
