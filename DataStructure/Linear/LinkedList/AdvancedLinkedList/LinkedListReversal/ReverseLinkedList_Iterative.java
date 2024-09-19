package DataStructure.Linear.LinkedList.AdvancedLinkedList.LinkedListReversal;


public class ReverseLinkedList_Iterative {

   // Method to reverse the linked list iteratively
   public static Node reverseIterative(Node head) {
      Node prev = null;  // Initially, previous is null
      Node current = head;  // Start with the head node
      Node next = null;  // To temporarily store the next node

      // Traverse the list and reverse the next pointers
      while (current != null) {
         next = current.next;   // Store the next node
         current.next = prev;   // Reverse the current node's pointer
         prev = current;        // Move prev to current node
         current = next;        // Move current to next node
      }

      // At the end, prev will be the new head of the reversed list
      return prev;
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

      // Reverse the linked list
      Node reversedHead = reverseIterative(head);

      // Display the reversed list
      System.out.println("Reversed Linked List:");
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

