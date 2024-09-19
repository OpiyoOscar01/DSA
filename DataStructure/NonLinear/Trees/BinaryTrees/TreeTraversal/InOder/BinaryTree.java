package DataStructure.NonLinear.Trees.BinaryTrees.TreeTraversal.InOder;

import java.util.LinkedList;

public class BinaryTree {
   private TreeNode root;

   public static void main(String[] args) {
      BinaryTree binaryTree = new BinaryTree();
      binaryTree.createBinaryTree();
      System.out.println("In order traversal of binary tree is:");
      binaryTree.inOrderTraversalRecursive(binaryTree.root);
      System.out.println();
      System.out.println("Pre order traversal of binary tree is:");
      binaryTree.inOrderTraversalIterative(binaryTree.root);
   }

   private void createBinaryTree() {
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

   public void inOrderTraversalRecursive(TreeNode root) {
      if (root == null) {
         return;
      }
      inOrderTraversalRecursive(root.left);
      System.out.print(root.data + " ");
      inOrderTraversalRecursive(root.right);
   }

   public void inOrderTraversalIterative(TreeNode root) {
      if (root == null) {
         return;
      }
      LinkedList<TreeNode> stack = new LinkedList<>();
      TreeNode temp = root;
      while (temp != null || !stack.isEmpty()) {
         if (temp != null) {
            stack.push(temp);
            temp = temp.left;
         } else {
            temp = stack.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
         }
      }
   }

   class TreeNode {
      private TreeNode left;
      private TreeNode right;
      private final int data;

      public TreeNode(int data) {
         this.data = data;
      }
   }
}
