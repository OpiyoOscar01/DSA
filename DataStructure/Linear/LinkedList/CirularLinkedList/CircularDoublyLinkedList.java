package DataStructure.Linear.LinkedList.CirularLinkedList;

public class CircularDoublyLinkedList {
   Node head;

   // Main method to test the circular doubly linked list
   public static void main(String[] args) {
      CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

      // Insert nodes at the head
      cdll.insertAtHead(10);
      cdll.insertAtHead(20);
      cdll.insertAtHead(30);

      // Insert a node at the tail
      cdll.insertAtTail(40);

      System.out.println("Original List:");
      cdll.printListNodes();

      // Delete the node at the head
      cdll.deleteAtHead();
      System.out.println("After deleting at head:");
      cdll.printListNodes();

      // Delete the node at the tail
      cdll.deleteAtTail();
      System.out.println("After deleting at tail:");
      cdll.printListNodes();

      // Delete node at index 1
      cdll.deleteAtIndex(1);
      System.out.println("After deleting at index 1:");
      cdll.printListNodes();
   }

   // Method to insert a node at the head of the circular doubly linked list
   public void insertAtHead(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
         head.next = head;
         head.prev = head; // Point to itself (circular)
      } else {
         Node tail = head.prev; // Get the last node (tail)
         newNode.next = head;
         newNode.prev = tail;
         tail.next = newNode;
         head.prev = newNode;
         head = newNode; // Update head to the new node
      }
   }

   // Method to insert a node at the tail of the circular doubly linked list
   public void insertAtTail(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
         head.next = head;
         head.prev = head; // Point to itself (circular)
      } else {
         Node tail = head.prev; // Get the last node (tail)
         newNode.next = head;
         newNode.prev = tail;
         tail.next = newNode;
         head.prev = newNode;
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
         Node tail = head.prev; // Get the last node (tail)
         head = head.next; // Move head to the second node
         head.prev = tail;
         tail.next = head; // Update the last node to point to the new head
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
         Node tail = head.prev; // Get the last node (tail)
         tail.prev.next = head; // Set second last node's next to head
         head.prev = tail.prev; // Update head.prev to point to the new tail
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
      for (int i = 0; i < index; i++) {
         current = current.next;
         if (current == head) { // If index is out of bounds
            System.out.println("Index out of bounds.");
            return;
         }
      }

      current.prev.next = current.next; // Skip the node at the specified index
      current.next.prev = current.prev; // Update the next node's previous pointer
   }

   // Method to display the nodes in the circular doubly linked list
   public void printListNodes() {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }

      Node current = head;
      do {
         System.out.print(current.data + " <-> ");
         current = current.next;
      } while (current != head); // Loop until back at head
      System.out.println("(back to head)");
   }

   // Inner class representing a node in the circular doubly linked list
   private static class Node {
      int data; // Data in the node
      Node next; // Pointer to the next node
      Node prev; // Pointer to the previous node

      Node(int data) {
         this.data = data;
         this.next = null;
         this.prev = null;
      }
   }
}

