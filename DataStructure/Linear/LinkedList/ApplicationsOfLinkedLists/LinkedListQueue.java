package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists;

public class LinkedListQueue {

   public static void main(String[] args) {
      Queue queue = new Queue();

      // Enqueue elements
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);

      // Display the queue
      System.out.println("Queue after enqueues:");
      queue.displayQueue();

      // Peek front element
      System.out.println("Front element: " + queue.peek());

      // Dequeue an element
      System.out.println("Dequeued element: " + queue.dequeue());

      // Display the queue after dequeue
      System.out.println("Queue after dequeue:");
      queue.displayQueue();

      // Check if the queue is empty
      System.out.println("Is queue empty? " + queue.isEmpty());
   }

   // Node class representing each element in the queue
   static class Node {
      int data;
      Node next;

      // Constructor to create a new node
      Node(int data) {
         this.data = data;
         this.next = null;
      }
   }

   // Queue class
   static class Queue {
      Node front;
      Node rear;
      int size;

      // Constructor to initialize the queue
      Queue() {
         front = null;
         rear = null;
         size = 0;
      }

      // Method to add an element to the rear of the queue
      public void enqueue(int data) {
         Node newNode = new Node(data);
         if (rear == null) {
            // If queue is empty, new node becomes both front and rear
            front = rear = newNode;
         } else {
            // Add the new node at the end and update rear
            rear.next = newNode;
            rear = newNode;
         }
         size++;
      }

      // Method to remove an element from the front of the queue
      public int dequeue() {
         if (front == null) {
            throw new RuntimeException("Queue is empty");
         }
         int data = front.data;
         front = front.next;
         if (front == null) {
            // If the queue becomes empty, update rear to null
            rear = null;
         }
         size--;
         return data;
      }

      // Method to retrieve the front element without removing it
      public int peek() {
         if (front == null) {
            throw new RuntimeException("Queue is empty");
         }
         return front.data;
      }

      // Method to check if the queue is empty
      public boolean isEmpty() {
         return front == null;
      }

      // Method to display the queue elements
      public void displayQueue() {
         Node current = front;
         while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
         }
         System.out.println("null");
      }
   }
}

