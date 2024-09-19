package DataStructure.Linear.LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
   Node head;

   // Main method to test the doubly linked list
   public static void main(String[] args) {
      DoublyLinkedList ddl = new DoublyLinkedList();

      // Insert nodes at the head
      ddl.insertAtHead(10);
      ddl.insertAtHead(20);
      ddl.insertAtHead(30);

      // Insert a node at the tail
      ddl.insertAtTail(40);

      System.out.println("Original List:");
      ddl.printListNodes();

      // Delete the node at the head
      ddl.deleteAtHead();
      System.out.println("After deleting at head:");
      ddl.printListNodes();

      // Delete the node at the tail
      ddl.deleteAtTail();
      System.out.println("After deleting at tail:");
      ddl.printListNodes();

      // Delete node at index 1 (between 20 and 40)
      ddl.deleteAtIndex(1);
      System.out.println("After deleting at index 1:");
      ddl.printListNodes();
   }

   // Method to insert a node at the head of the list
   public void insertAtHead(int data) {
      Node newNode = new Node(data);
      if (head != null) {
         head.prev = newNode;
      }
      newNode.next = head;
      head = newNode;
   }

   // Method to insert a node at the tail of the list
   public void insertAtTail(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
      } else {
         Node current = head;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newNode;
         newNode.prev = current;
      }
   }

   // Method to delete a node at the head of the list
   public void deleteAtHead() {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }
      head = head.next; // Move head to the next node
      if (head != null) {
         head.prev = null; // Set the new head's prev to null
      }
   }

   // Method to delete a node at the tail of the list
   public void deleteAtTail() {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }

      if (head.next == null) { // If there is only one node
         head = null;
         return;
      }

      Node current = head;
      while (current.next != null) {
         current = current.next; // Traverse to the last node
      }
      current.prev.next = null; // Remove the last node by setting the second last node's next to null
   }

   // Method to delete a node at a specific index
   public void deleteAtIndex(int index) {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }

      if (index == 0) { // If index is 0, delete at head
         deleteAtHead();
         return;
      }

      Node current = head;
      for (int i = 0; i < index; i++) {
         current = current.next;
         if (current == null) { // If index is out of bounds
            System.out.println("Index out of bounds.");
            return;
         }
      }

      // If the node to delete is the last node, call deleteAtTail
      if (current.next == null) {
         deleteAtTail();
         return;
      }

      // Otherwise, delete the node at the specific index
      current.prev.next = current.next;
      current.next.prev = current.prev;
   }

   // Method to display the nodes in the list
   public void printListNodes() {
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.data + "<->");
         temp = temp.next;
      }
      System.out.println("null");
   }


}
