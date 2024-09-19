package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.Circular;

public class CircularQueueUsingArray {
   private final int[] queue;  // Array to hold the queue elements
   private int front;    // Front points to the first element in the queue
   private int rear;     // Rear points to the last element in the queue
   private int size;     // Current number of elements in the queue
   private final int capacity; // Capacity of the queue (size of the array)

   // Constructor to initialize the queue with a given capacity
   public CircularQueueUsingArray(int capacity) {
      this.capacity = capacity;
      queue = new int[capacity];
      front = -1;
      rear = -1;
      size = 0;
   }

   // Main method to test the circular queue implementation
   public static void main(String[] args) {
      CircularQueueUsingArray queue = new CircularQueueUsingArray(5);

      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
      queue.enqueue(40);
      queue.enqueue(50);

      queue.display();

      queue.dequeue();
      queue.dequeue();

      queue.display();

      queue.enqueue(60);
      queue.enqueue(70);

      queue.display();

      System.out.println("Front item: " + queue.peek());
      System.out.println("Queue size: " + queue.size());
   }

   // Enqueue operation to add an element to the rear of the queue
   public void enqueue(int data) {
      if (isFull()) {
         System.out.println("Queue is full. Cannot enqueue " + data);
         return;
      }

      if (isEmpty()) {
         front = 0; // Set front to 0 if the queue is empty
      }

      // Circular increment of rear index
      rear = (rear + 1) % capacity;
      queue[rear] = data;
      size++;
      System.out.println("Enqueued: " + data);
   }

   // Dequeue operation to remove and return the front element
   public int dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty. Cannot dequeue.");
      }

      int data = queue[front];

      // If there is only one element left, reset both front and rear
      if (front == rear) {
         front = rear = -1;
      } else {
         // Circular increment of front index
         front = (front + 1) % capacity;
      }

      size--;
      System.out.println("Dequeued: " + data);
      return data;
   }

   // Peek operation to return the front element without removing it
   public int peek() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty. Cannot peek.");
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

   // Get the current size of the queue
   public int size() {
      return size;
   }

   // Display the elements in the queue
   public void display() {
      if (isEmpty()) {
         System.out.println("Queue is empty");
         return;
      }

      System.out.print("Queue elements: ");
      int i = front;
      do {
         System.out.print(queue[i] + " ");
         i = (i + 1) % capacity;
      } while (i != (rear + 1) % capacity); // Stop when reaching rear
      System.out.println();
   }
}

