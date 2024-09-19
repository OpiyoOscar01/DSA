package DataStructure.Linear.Queues.QueueImplementation.Arrays;

public class ArrayQueue {
   private final int[] queue;
   private int front;
   private int rear;
   private int size;
   private final int capacity;

   // Constructor
   public ArrayQueue(int capacity) {
      this.capacity = capacity;
      queue = new int[capacity];
      front = 0;
      rear = -1;
      size = 0;
   }

   // Main method to test the queue
   public static void main(String[] args) {
      ArrayQueue queue = new ArrayQueue(5);
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);

      System.out.println("Front item is " + queue.peek());
      System.out.println("Queue size is " + queue.size());

      System.out.println("Dequeued item is " + queue.dequeue());
      System.out.println("Queue size is " + queue.size());

      System.out.println("Is queue empty? " + queue.isEmpty());
      System.out.println("Is queue full? " + queue.isFull());
   }

   // Enqueue operation
   public void enqueue(int data) {
      if (isFull()) {
         throw new RuntimeException("Queue is full");
      }
      rear = (rear + 1) % capacity;
      queue[rear] = data;
      size++;
   }

   // Dequeue operation
   public int dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty");
      }
      int data = queue[front];
      front = (front + 1) % capacity;
      size--;
      return data;
   }

   // Peek operation
   public int peek() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty");
      }
      return queue[front];
   }

   // Check if the queue is empty
   public boolean isEmpty() {
      return size == 0;
   }

   // Check if the queue is full
   public boolean isFull() {
      return size == capacity;
   }

   // Get the size of the queue
   public int size() {
      return size;
   }
}

