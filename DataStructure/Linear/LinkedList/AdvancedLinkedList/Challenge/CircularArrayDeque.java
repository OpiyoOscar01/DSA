package DataStructure.Linear.LinkedList.AdvancedLinkedList.Challenge;

public class CircularArrayDeque {
   private final int capacity; // Maximum capacity of the deque
   private final int[] array; // Array to store elements
   private int front; // Pointer to the front of the deque
   private int rear; // Pointer to the rear of the deque
   private int size; // Number of elements in the deque

   // Constructor to initialize the deque
   public CircularArrayDeque(int capacity) {
      this.capacity = capacity;
      this.array = new int[capacity];
      this.front = -1;
      this.rear = -1;
      this.size = 0;
   }

   public static void main(String[] args) {
      CircularArrayDeque deque = new CircularArrayDeque(5);

      // Add elements to the deque
      deque.addLast(10);
      deque.addLast(20);
      deque.addFirst(5);
      deque.addFirst(2);

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

   // Method to add an element to the front of the deque
   public void addFirst(int data) {
      if (isFull()) {
         throw new RuntimeException("Deque is full");
      }
      if (isEmpty()) {
         front = rear = 0;
      } else {
         front = (front - 1 + capacity) % capacity;
      }
      array[front] = data;
      size++;
   }

   // Method to add an element to the rear of the deque
   public void addLast(int data) {
      if (isFull()) {
         throw new RuntimeException("Deque is full");
      }
      if (isEmpty()) {
         front = rear = 0;
      } else {
         rear = (rear + 1) % capacity;
      }
      array[rear] = data;
      size++;
   }

   // Method to remove an element from the front of the deque
   public int removeFirst() {
      if (isEmpty()) {
         throw new RuntimeException("Deque is empty");
      }
      int data = array[front];
      if (front == rear) {
         front = rear = -1; // Deque is now empty
      } else {
         front = (front + 1) % capacity;
      }
      size--;
      return data;
   }

   // Method to remove an element from the rear of the deque
   public int removeLast() {
      if (isEmpty()) {
         throw new RuntimeException("Deque is empty");
      }
      int data = array[rear];
      if (front == rear) {
         front = rear = -1; // Deque is now empty
      } else {
         rear = (rear - 1 + capacity) % capacity;
      }
      size--;
      return data;
   }

   // Method to retrieve the first element without removing it
   public int peekFirst() {
      if (isEmpty()) {
         throw new RuntimeException("Deque is empty");
      }
      return array[front];
   }

   // Method to retrieve the last element without removing it
   public int peekLast() {
      if (isEmpty()) {
         throw new RuntimeException("Deque is empty");
      }
      return array[rear];
   }

   // Method to check if the deque is empty
   public boolean isEmpty() {
      return size == 0;
   }

   // Method to check if the deque is full
   public boolean isFull() {
      return size == capacity;
   }

   // Method to display the elements of the deque
   public void displayDeque() {
      if (isEmpty()) {
         System.out.println("Deque is empty");
         return;
      }
      int i = front;
      while (true) {
         System.out.print(array[i] + " ");
         if (i == rear) {
            break;
         }
         i = (i + 1) % capacity;
      }
      System.out.println();
   }
}

