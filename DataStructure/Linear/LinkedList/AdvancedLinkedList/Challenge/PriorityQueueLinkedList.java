package DataStructure.Linear.LinkedList.AdvancedLinkedList.Challenge;

public class PriorityQueueLinkedList {

   private Node head; // Head of the linked list

   // Constructor to initialize the priority queue
   public PriorityQueueLinkedList() {
      this.head = null;
   }

   public static void main(String[] args) {
      PriorityQueueLinkedList pq = new PriorityQueueLinkedList();

      // Insert elements into the priority queue
      pq.enqueue(10, 2);
      pq.enqueue(20, 1);
      pq.enqueue(30, 3);
      pq.enqueue(40, 2);

      // Display the priority queue
      System.out.println("Priority Queue:");
      pq.displayQueue();

      // Remove and display elements
      System.out.println("Dequeued: " + pq.dequeue());
      System.out.println("Dequeued: " + pq.dequeue());

      // Display the priority queue after removals
      System.out.println("Priority Queue after removals:");
      pq.displayQueue();
   }

   // Method to insert an element with a given priority
   public void enqueue(int data, int priority) {
      Node newNode = new Node(data, priority);

      // If the queue is empty or the new node has higher priority than the head
      if (head == null || head.priority < priority) {
         newNode.next = head;
         head = newNode;
      } else {
         // Traverse the list to find the correct position for the new node
         Node current = head;
         while (current.next != null && current.next.priority >= priority) {
            current = current.next;
         }
         newNode.next = current.next;
         current.next = newNode;
      }
   }

   // Method to remove and return the element with the highest priority
   public int dequeue() {
      if (head == null) {
         throw new RuntimeException("Priority Queue is empty");
      }
      int data = head.data;
      head = head.next;
      return data;
   }

   // Method to display the elements of the priority queue
   public void displayQueue() {
      Node current = head;
      while (current != null) {
         System.out.print("(" + current.data + ", Priority: " + current.priority + ") -> ");
         current = current.next;
      }
      System.out.println("null");
   }

   // Node class representing each element in the priority queue
   static class Node {
      int data; // The value of the node
      int priority; // The priority of the node
      Node next; // Pointer to the next node

      Node(int data, int priority) {
         this.data = data;
         this.priority = priority;
         this.next = null;
      }
   }

}
