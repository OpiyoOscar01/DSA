package DataStructure.Linear.LinkedList.AdvancedLinkedList.RemovingDuplicates;

public class RemoveDuplicatesSortedLinkedList {

   // Method to remove duplicates from a sorted linked list
   public static void removeDuplicatesSorted(Node head) {
      if (head == null) return;

      Node current = head;

      // Traverse through the list
      while (current != null && current.next != null) {
         // If current node's data is the same as the next node's data, remove the next node
         if (current.data == current.next.data) {
            current.next = current.next.next;
         } else {
            current = current.next;  // Move to the next distinct element
         }
      }
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
      // Create a sorted linked list: 1 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5 -> null
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(2);
      head.next.next.next = new Node(3);
      head.next.next.next.next = new Node(4);
      head.next.next.next.next.next = new Node(4);
      head.next.next.next.next.next.next = new Node(5);

      // Display the original list
      System.out.println("Original Sorted Linked List:");
      displayList(head);

      // Remove duplicates
      removeDuplicatesSorted(head);

      // Display the list after removing duplicates
      System.out.println("Sorted Linked List after removing duplicates:");
      displayList(head);
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

