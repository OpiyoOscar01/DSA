package DataStructure.NonLinear.Trees.BinaryTrees.TreeTraversal.PostOrder;

import java.util.Stack;

public class BinaryTree {
   TreeNode root;

   public static void main(String[] args) {
      BinaryTree bt = new BinaryTree();
      bt.createBinaryTree();
      bt.postOrderTraversalRecursive(bt.root);

   }

   void postOrderTraversalRecursive(TreeNode root) {
      if (root == null) {
         return;
      }
      postOrderTraversalRecursive(root.left);
      postOrderTraversalRecursive(root.right);
      System.out.println(root.data);

   }

   void createBinaryTree() {
      TreeNode first = new TreeNode(1);
      TreeNode second = new TreeNode(2);
      TreeNode third = new TreeNode(3);
      TreeNode fourth = new TreeNode(4);
      TreeNode fifth = new TreeNode(5);
      TreeNode sixth = new TreeNode(6);
      TreeNode seventh = new TreeNode(7);
      root = first;
      first.left = second;
      first.right = third;
      second.left = fourth;
      second.right = fifth;
      third.left = sixth;
      third.right = seventh;
   }

   // Iterative postorder traversal function
   public void postOrderIterative(TreeNode root) {
      TreeNode current = root;  // Start with the root node
      if (current == null) {
         return;  // If the tree is empty, exit the function
      }

      Stack<TreeNode> stack = new Stack<>();  // Stack to keep track of the nodes
      TreeNode lastVisitedNode = null;  // This will track the last visited node in the tree

      // Continue the loop as long as there are nodes on the stack or the current node is not null
      while (!stack.isEmpty() || current != null) {
         if (current != null) {
            // Keep going left as much as possible and push the nodes onto the stack
            stack.push(current);
            current = current.left;
         } else {
            TreeNode peekNode = stack.peek();  // Look at the top node in the stack

            // If the right child is null or the right child was last visited, process the current node
            if (peekNode.right == null || peekNode.right == lastVisitedNode) {
               System.out.println(peekNode.data + " ");  // Print the node's value (process the node)
               lastVisitedNode = stack.pop();  // Mark this node as last visited and pop it from the stack
            } else {
               // If the right child hasn't been processed, move to the right child
               current = peekNode.right;
            }
         }
      }
   }

   class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;

      public TreeNode(int data) {
         this.data = data;
      }
   }
}
