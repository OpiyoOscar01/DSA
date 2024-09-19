package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.DeQue.ArrayImpl;

public class DequeArray {
   private final int[] deque;
   private int front;
   private int rear;
   private int size;
   private final int capacity;

   // Constructor to initialize the deque
   public DequeArray(int capacity) {
      this.capacity = capacity;
      deque = new int[capacity];
      front = -1;
      rear = 0;
      size = 0;
   }

   // Main method to test the deque
   public static void main(String[] args) {
      DequeArray deque = new DequeArray(5);

      deque.insertRear(10);
      deque.insertRear(20);
      deque.insertFront(30);

      deque.display();  // Output: Deque elements: 30 10 20

      System.out.println("Front: " + deque.getFront()); // Output: 30
      System.out.println("Rear: " + deque.getRear());   // Output: 20

      deque.deleteFront();
      deque.display();  // Output: Deque elements: 10 20

      deque.deleteRear();
      deque.display();  // Output: Deque elements: 10
   }

   // Check if the deque is full
   public boolean isFull() {
      return size == capacity;
   }

   // Check if the deque is empty
   public boolean isEmpty() {
      return size == 0;
   }

   // Insert element at the front
   public void insertFront(int data) {
      if (isFull()) {
         System.out.println("Deque is full. Cannot insert at front.");
         return;
      }

      // Circular indexing
      front = (front == -1) ? 0 : (front - 1 + capacity) % capacity;
      deque[front] = data;
      size++;

      if (rear == -1) rear = 0;  // If inserting the first element
   }

   // Insert element at the rear
   public void insertRear(int data) {
      if (isFull()) {
         System.out.println("Deque is full. Cannot insert at rear.");
         return;
      }

      rear = (rear + 1) % capacity;
      deque[rear] = data;
      size++;

      if (front == -1) front = 0;  // If inserting the first element
   }

   // Delete element from the front
   public void deleteFront() {
      if (isEmpty()) {
         System.out.println("Deque is empty. Cannot delete from front.");
         return;
      }

      front = (front + 1) % capacity;
      size--;
   }

   // Delete element from the rear
   public void deleteRear() {
      if (isEmpty()) {
         System.out.println("Deque is empty. Cannot delete from rear.");
         return;
      }

      rear = (rear - 1 + capacity) % capacity;
      size--;
   }

   // Get the front element
   public int getFront() {
      if (isEmpty()) {
         System.out.println("Deque is empty.");
         return -1;
      }
      return deque[front];
   }

   // Get the rear element
   public int getRear() {
      if (isEmpty()) {
         System.out.println("Deque is empty.");
         return -1;
      }
      return deque[rear];
   }

   // Display the elements of the deque
   public void display() {
      if (isEmpty()) {
         System.out.println("Deque is empty.");
         return;
      }

      System.out.print("Deque elements: ");
      for (int i = 0; i < size; i++) {
         int index = (front + i) % capacity;
         System.out.print(deque[index] + " ");
      }
      System.out.println();
   }
}

