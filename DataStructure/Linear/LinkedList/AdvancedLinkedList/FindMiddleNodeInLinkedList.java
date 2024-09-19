package DataStructure.Linear.LinkedList.AdvancedLinkedList;


public class FindMiddleNodeInLinkedList {

   // Method to find the middle node of the linked list
   public static Node findMiddle(Node head) {
      if (head == null) return null;

      Node slow = head;
      Node fast = head;

      // Fast moves two steps while slow moves one step
      while (fast != null && fast.next != null) {
         slow = slow.next;  // Move slow by 1 step
         fast = fast.next.next;  // Move fast by 2 steps
      }

      // Slow will now point to the middle node
      return slow;
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
      head.next.next.next.next.next = new Node(9);

      // Display the original list
      System.out.println("Original Linked List:");
      displayList(head);

      // Find the middle node
      Node middle = findMiddle(head);
      System.out.println("Middle Node: " + (middle != null ? middle.data : "List is empty"));
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

