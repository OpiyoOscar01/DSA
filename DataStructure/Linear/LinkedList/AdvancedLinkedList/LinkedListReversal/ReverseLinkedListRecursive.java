package DataStructure.Linear.LinkedList.AdvancedLinkedList.LinkedListReversal;


public class ReverseLinkedListRecursive {

   // Method to reverse the linked list recursively
   public static Node reverseRecursive(Node head) {
      // Base case: if the list is empty or only one node is left
      if (head == null || head.next == null) {
         return head;
      }

      // Recursively reverse the rest of the list
      Node newHead = reverseRecursive(head.next);

      // Set the next node's next pointer to the current node
      head.next.next = head;

      // Set the current node's next pointer to null (to break the original link)
      head.next = null;

      // Return the new head of the reversed list
      return newHead;
   }

   // Method to print the linked list
   public static void displayList(Node head) {
      Node current = head;
      while (current != null) {
         System.out.print(current.data + " -> ");
         current = current.next;
      }
      System.out.println("null");
   }

   public static void main(String[] args) {
      // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);

      // Display the original list
      System.out.println("Original Linked List:");
      displayList(head);

      // Reverse the linked list recursively
      Node reversedHead = reverseRecursive(head);

      // Display the reversed list
      System.out.println("Reversed Linked List (Recursive):");
      displayList(reversedHead);
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

