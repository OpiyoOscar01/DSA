package DataStructure.Linear.LinkedList.OptimisingLinkedLists;


public class LinkedListNthFromEnd {
   private Node head; // Head of the linked list

   public static void main(String[] args) {
      LinkedListNthFromEnd list = new LinkedListNthFromEnd();

      // Insert elements into the linked list
      list.insertAtEnd(10);
      list.insertAtEnd(20);
      list.insertAtEnd(30);
      list.insertAtEnd(40);
      list.insertAtEnd(50);

      // Display the list
      System.out.println("Linked List:");
      list.displayList();

      // Find and display the 2nd node from the end
      int nthNode = list.findNthFromEnd(2);
      System.out.println("2nd node from the end: " + nthNode);

      // Find and display the 4th node from the end
      nthNode = list.findNthFromEnd(4);
      System.out.println("4th node from the end: " + nthNode);
   }

   // Method to insert elements at the end of the linked list
   public void insertAtEnd(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
      } else {
         Node current = head;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newNode;
      }
   }

   // Method to find the Nth node from the end using the two-pointer technique
   public int findNthFromEnd(int n) {
      if (head == null) {
         throw new RuntimeException("The list is empty.");
      }

      Node fast = head;
      Node slow = head;

      // Move the fast pointer N steps ahead
      for (int i = 0; i < n; i++) {
         if (fast == null) {
            throw new RuntimeException("N is greater than the size of the list.");
         }
         fast = fast.next;
      }

      // Move both pointers until the fast pointer reaches the end
      while (fast != null) {
         fast = fast.next;
         slow = slow.next;
      }

      // Slow pointer is now at the Nth node from the end
      return slow.data;
   }

   // Method to display the elements of the linked list
   public void displayList() {
      Node current = head;
      while (current != null) {
         System.out.print(current.data + " -> ");
         current = current.next;
      }
      System.out.println("null");
   }

   // Node class representing each element in the linked list
   static class Node {
      int data;
      Node next;

      Node(int data) {
         this.data = data;
         this.next = null;
      }
   }
}

