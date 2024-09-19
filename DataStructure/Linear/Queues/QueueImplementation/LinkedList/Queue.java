/*
package DataStructure.Linear.Queues.QueueImplementation.LinkedList;

public class Queue<T> {
   private Node front, rear;
   private int size;

   // Constructor
   public Queue() {
      front = rear = null;
      size = 0;
   }

   // Enqueue operation
   public void enqueue(int data) {
      Node newNode = new Node(data);
      if (rear == null) {
         front = rear = newNode;
      } else {
         rear.next = newNode;
         rear = newNode;
      }
      size++;
   }

   // Dequeue operation
   public int dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty");
      }
      int data = front.data;
      front = front.next;
      if (front == null) {
         rear = null;
      }
      size--;
      return data;
   }

   // Peek operation
   public int peek() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty");
      }
      return front.data;
   }

   // Check if the queue is empty
   public boolean isEmpty() {
      return front == null;
   }

   // Get the size of the queue
   public int size() {
      return size;
   }

   // Main method to test the queue
   public static void main(String[] args) {
      Queue<T> queue = new Queue<T>();
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);

      System.out.println("Front item is " + queue.peek());
      System.out.println("Queue size is " + queue.size());

      System.out.println("Dequeued item is " + queue.dequeue());
      System.out.println("Queue size is " + queue.size());

      System.out.println("Is queue empty? " + queue.isEmpty());
   }
}

*/