package DataStructure.NonLinear.Trees.BinaryTrees.TreeTraversal.Level;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
   TreeNode root;

   public static void main(String[] args) {
      BinaryTree bt = new BinaryTree();

      // Create the binary tree
      bt.createBinaryTree();

      // Perform level-order traversal
      bt.levelOrderTraversal(bt.root);  // Expected output: 1 2 3 4 5 6 7
   }

   // Method to create the binary tree
   void createBinaryTree() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);
      TreeNode node6 = new TreeNode(6);
      TreeNode node7 = new TreeNode(7);

      // Correct root assignment
      root = node1;

      // Assign children
      node1.left = node2;
      node1.right = node3;
      node2.left = node4;
      node2.right = node5;
      node3.left = node6;
      node3.right = node7;
   }

   // Method for level-order traversal (Breadth-First Search)
   void levelOrderTraversal(TreeNode root) {
      if (root == null) {
         return;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         TreeNode temp = queue.poll();

         // Print the node's data instead of the object reference
         System.out.print(temp.data + " ");

         // Offer the left and right children to the queue
         if (temp.left != null) {
            queue.offer(temp.left);
         }
         if (temp.right != null) {
            queue.offer(temp.right);
         }
      }
   }

   // Inner class for TreeNode
   class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;

      // Constructor for TreeNode
      public TreeNode(int data) {
         this.data = data;
      }
   }
}
