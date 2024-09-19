package DataStructure.Linear.LinkedList.AdvancedLinkedList.RemovingDuplicates;

import java.util.HashSet;

public class RemoveDuplicatesLinkedList {

   // Method to remove duplicates from an unsorted linked list
   public static void removeDuplicates(Node head) {
      if (head == null) return;

      HashSet<Integer> seen = new HashSet<>();  // Set to track seen data
      Node current = head;
      Node prev = null;

      while (current != null) {
         if (seen.contains(current.data)) {
            // If the data has been seen, remove the current node
            prev.next = current.next;
         } else {
            // If the data hasn't been seen, add it to the set
            seen.add(current.data);
            prev = current;
         }
         current = current.next;
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
      // Create a linked list: 1 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5 -> null
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(2);
      head.next.next.next = new Node(3);
      head.next.next.next.next = new Node(4);
      head.next.next.next.next.next = new Node(4);
      head.next.next.next.next.next.next = new Node(5);

      // Display the original list
      System.out.println("Original Linked List:");
      displayList(head);

      // Remove duplicates
      removeDuplicates(head);

      // Display the list after removing duplicates
      System.out.println("Linked List after removing duplicates:");
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

