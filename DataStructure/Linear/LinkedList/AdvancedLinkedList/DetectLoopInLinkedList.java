package DataStructure.Linear.LinkedList.AdvancedLinkedList;


public class DetectLoopInLinkedList {

   // Method to detect a loop in a linked list using Floyd's Cycle-Finding Algorithm
   public static boolean detectLoop(Node head) {
      // Initialize two pointers
      Node slow = head;  // Tortoise pointer
      Node fast = head;  // Hare pointer

      // Traverse the linked list with both pointers
      while (fast != null && fast.next != null) {
         slow = slow.next;       // Move slow pointer by 1 step
         fast = fast.next.next;  // Move fast pointer by 2 steps

         // If slow and fast meet, there is a loop
         if (slow == fast) {
            return true; // Loop detected
         }
      }

      // If we reach the end of the list, no loop exists
      return false;
   }

   // Method to create a loop in the linked list for testing purposes
   public static void createLoop(Node head, int position) {
      Node loopNode = head;
      Node tail = head;

      // Find the node at the given position where the loop will start
      for (int i = 1; i < position; i++) {
         loopNode = loopNode.next;
      }

      // Find the last node in the linked list
      while (tail.next != null) {
         tail = tail.next;
      }

      // Point the last node to the loop node, creating a cycle
      tail.next = loopNode;
   }

   // Method to display the linked list (only useful if no loop exists)
   public static void displayList(Node head) {
      Node current = head;
      int count = 0;

      // Limiting the print to avoid infinite loop in case of a cycle
      while (current != null && count < 20) { // Limit to 20 nodes to prevent infinite loop in case of a cycle
         System.out.print(current.data + " -> ");
         current = current.next;
         count++;
      }

      if (count >= 20) {
         System.out.println("... (list continues or loop detected)");
      } else {
         System.out.println("null");
      }
   }

   public static void main(String[] args) {
      // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);

      // Display the list
      System.out.println("Original Linked List:");
      displayList(head);

      // Test case without loop
      System.out.println("\nDetecting loop (without loop): " + (detectLoop(head) ? "Loop Detected" : "No Loop"));

      // Create a loop: Point the last node (5) to the second node (2)
      createLoop(head, 2);

      // Detect loop after creating one
      System.out.println("\nDetecting loop (after creating loop): " + (detectLoop(head) ? "Loop Detected" : "No Loop"));
   }

   // Node class representing each element in the linked list
   static class Node {
      int data;
      Node next;

      // Constructor to create a new node
      Node(int data) {
         this.data = data;
         this.next = null;
      }
   }
}

