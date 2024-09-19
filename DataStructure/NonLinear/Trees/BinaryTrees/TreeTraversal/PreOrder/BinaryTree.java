package DataStructure.NonLinear.Trees.BinaryTrees.TreeTraversal.PreOrder;

import java.util.Stack;

public class BinaryTree {

   private TreeNode root;

   public static void main(String[] args) {
      BinaryTree tree = new BinaryTree();
      tree.createBinaryTree();
      System.out.println("Pre-order traversal of the binary tree:");
      tree.preOrderRecursive();
   }

   // Method to create the binary tree
   public void createBinaryTree() {
      TreeNode first = new TreeNode(1);
      TreeNode second = new TreeNode(2);
      TreeNode third = new TreeNode(3);
      TreeNode forth = new TreeNode(4);
      TreeNode fifth = new TreeNode(5);
      TreeNode sixth = new TreeNode(6);
      TreeNode seventh = new TreeNode(7);

      root = first;
      first.left = second;
      first.right = third;
      second.left = forth;
      second.right = fifth;
      third.left = sixth;
      third.right = seventh;

   }

   public void preOderTravsersalRecursive(TreeNode root) {
      if (root == null) return;
      System.out.print(root.data + " ");
      preOderTravsersalRecursive(root.left);
      preOderTravsersalRecursive(root.right);
   }

   public void preOrderRecursive() {
      preOderTravsersalRecursive(root);
   }

   public void inOrderItertive() {
      preOderTravsersalIterative(root);
   }

   public void preOderTravsersalIterative(TreeNode root) {
      if (root == null) return;
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
         TreeNode temp = stack.pop();
         System.out.print(temp.data + " ");
         if (temp.right != null) {
            stack.push(temp.right);
         }
         if (temp.left != null) {
            stack.push(temp.left);
         }

      }
   }

   class TreeNode {
      private final int data;
      private TreeNode left;
      private TreeNode right;

      public TreeNode(int data) {
         this.data = data;
      }
   }
}
