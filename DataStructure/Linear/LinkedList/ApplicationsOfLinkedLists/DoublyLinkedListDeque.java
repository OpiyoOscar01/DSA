package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists;


public class DoublyLinkedListDeque {

   public static void main(String[] args) {
      Deque deque = new Deque();

      // Add elements to the deque
      deque.addFirst(10);
      deque.addLast(20);
      deque.addFirst(5);
      deque.addLast(30);

      // Display the deque
      System.out.println("Deque:");
      deque.displayDeque();

      // Peek elements
      System.out.println("First element: " + deque.peekFirst());
      System.out.println("Last element: " + deque.peekLast());

      // Remove elements
      System.out.println("Removed first element: " + deque.removeFirst());
      System.out.println("Removed last element: " + deque.removeLast());

      // Display the deque after removals
      System.out.println("Deque after removals:");
      deque.displayDeque();
   }

   // Node class representing each element in the doubly linked list
   static class Node {
      int data;
      Node prev;
      Node next;

      // Constructor to create a new node
      Node(int data) {
         this.data = data;
         this.prev = null;
         this.next = null;
      }
   }

   // Deque class
   static class Deque {
      private Node head;
      private Node tail;

      // Constructor to initialize the deque
      Deque() {
         head = null;
         tail = null;
      }

      // Method to add an element to the front of the deque
      public void addFirst(int data) {
         Node newNode = new Node(data);
         if (head == null) {
            head = newNode;
            tail = newNode;
         } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
         }
      }

      // Method to add an element to the rear of the deque
      public void addLast(int data) {
         Node newNode = new Node(data);
         if (tail == null) {
            head = newNode;
            tail = newNode;
         } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
         }
      }

      // Method to remove an element from the front of the deque
      public int removeFirst() {
         if (head == null) {
            throw new RuntimeException("Deque is empty");
         }
         int data = head.data;
         head = head.next;
         if (head != null) {
            head.prev = null;
         } else {
            tail = null;
         }
         return data;
      }

      // Method to remove an element from the rear of the deque
      public int removeLast() {
         if (tail == null) {
            throw new RuntimeException("Deque is empty");
         }
         int data = tail.data;
         tail = tail.prev;
         if (tail != null) {
            tail.next = null;
         } else {
            head = null;
         }
         return data;
      }

      // Method to retrieve the first element without removing it
      public int peekFirst() {
         if (head == null) {
            throw new RuntimeException("Deque is empty");
         }
         return head.data;
      }

      // Method to retrieve the last element without removing it
      public int peekLast() {
         if (tail == null) {
            throw new RuntimeException("Deque is empty");
         }
         return tail.data;
      }

      // Method to display the elements of the deque
      public void displayDeque() {
         Node current = head;
         while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
         }
         System.out.println("null");
      }
   }
}

