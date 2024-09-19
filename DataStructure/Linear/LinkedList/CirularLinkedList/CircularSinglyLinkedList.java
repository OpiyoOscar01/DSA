package DataStructure.Linear.LinkedList.CirularLinkedList;


public class CircularSinglyLinkedList {
   Node head;

   // Main method to test the circular singly linked list
   public static void main(String[] args) {
      CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

      // Insert nodes at the head
      csll.insertAtHead(10);
      csll.insertAtHead(20);
      csll.insertAtHead(30);

      // Insert a node at the tail
      csll.insertAtTail(40);

      System.out.println("Original List:");
      csll.printListNodes();

      // Delete the node at the head
      csll.deleteAtHead();
      System.out.println("After deleting at head:");
      csll.printListNodes();

      // Delete the node at the tail
      csll.deleteAtTail();
      System.out.println("After deleting at tail:");
      csll.printListNodes();

      // Delete node at index 1 (between 20 and 40)
      csll.deleteAtIndex(1);
      System.out.println("After deleting at index 1:");
      csll.printListNodes();
   }

   // Method to insert a node at the head of the circular singly linked list
   public void insertAtHead(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
         head.next = head; // Point to itself
      } else {
         Node current = head;
         while (current.next != head) { // Traverse to the last node
            current = current.next;
         }
         newNode.next = head;
         current.next = newNode; // Point the last node to the new head
         head = newNode;
      }
   }

   // Method to insert a node at the tail of the circular singly linked list
   public void insertAtTail(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
         head.next = head; // Point to itself
      } else {
         Node current = head;
         while (current.next != head) { // Traverse to the last node
            current = current.next;
         }
         current.next = newNode;
         newNode.next = head; // Link the new node to head to make it circular
      }
   }

   // Method to delete the node at the head
   public void deleteAtHead() {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }

      if (head.next == head) { // If there is only one node
         head = null;
      } else {
         Node current = head;
         while (current.next != head) { // Traverse to the last node
            current = current.next;
         }
         current.next = head.next; // Link the last node to the second node
         head = head.next; // Move head to the second node
      }
   }

   // Method to delete the node at the tail
   public void deleteAtTail() {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }

      if (head.next == head) { // If there is only one node
         head = null;
      } else {
         Node current = head;
         Node prev = null;
         while (current.next != head) { // Traverse to the last node
            prev = current;
            current = current.next;
         }
         prev.next = head; // Set second last node's next to head
      }
   }

   // Method to delete a node at a specific index
   public void deleteAtIndex(int index) {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }

      if (index == 0) { // Delete at head if index is 0
         deleteAtHead();
         return;
      }

      Node current = head;
      Node prev = null;
      for (int i = 0; i < index; i++) {
         prev = current;
         current = current.next;
         if (current == head) { // If index is out of bounds
            System.out.println("Index out of bounds.");
            return;
         }
      }
      prev.next = current.next; // Skip the node at the specified index
   }

   // Method to display the nodes in the circular linked list
   public void printListNodes() {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }

      Node current = head;
      do {
         System.out.print(current.data + " -> ");
         current = current.next;
      } while (current != head); // Loop until back at head
      System.out.println("(back to head)");
   }

   // Inner class representing a node in the circular singly linked list
   private static class Node {
      int data; // Data in the node
      Node next; // Pointer to the next node

      Node(int data) {
         this.data = data;
         this.next = null;
      }
   }
}

