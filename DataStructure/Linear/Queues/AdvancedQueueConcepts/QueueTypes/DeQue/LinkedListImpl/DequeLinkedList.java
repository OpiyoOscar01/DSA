package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.DeQue.LinkedListImpl;

public class DequeLinkedList {
   private Node front, rear;

   // Constructor to initialize the deque
   public DequeLinkedList() {
      front = rear = null;
   }

   // Main method to test the deque
   public static void main(String[] args) {
      DequeLinkedList deque = new DequeLinkedList();

      deque.insertRear(10);
      deque.insertRear(20);
      deque.insertRear(25);
      deque.insertFront(30);
      deque.insertFront(35);

      deque.display();  // Output: Deque elements: 30 10 20

      System.out.println("Front: " + deque.getFront()); // Output: 30
      System.out.println("Rear: " + deque.getRear());   // Output: 20

      deque.deleteFront();
      deque.display();  // Output: Deque elements: 10 20

      deque.deleteRear();
      deque.deleteRear();
      deque.display();  // Output: Deque elements: 10
   }

   // Check if the deque is empty
   public boolean isEmpty() {
      return front == null;
   }

   // Insert element at the front
   public void insertFront(int data) {
      Node newNode = new Node(data);

      if (isEmpty()) {
         front = rear = newNode;
      } else {
         newNode.next = front;
         front.prev = newNode;
         front = newNode;
      }
   }

   // Insert element at the rear
   public void insertRear(int data) {
      Node newNode = new Node(data);

      if (isEmpty()) {
         front = rear = newNode;
      } else {
         rear.next = newNode;
         newNode.prev = rear;
         rear = newNode;
      }
   }

   // Delete element from the front
   public void deleteFront() {
      if (isEmpty()) {
         System.out.println("Deque is empty. Cannot delete from front.");
         return;
      }

      if (front == rear) {
         front = rear = null;  // If there was only one element
      } else {
         front = front.next;
         front.prev = null;
      }
   }

   // Delete element from the rear
   public void deleteRear() {
      if (isEmpty()) {
         System.out.println("Deque is empty. Cannot delete from rear.");
         return;
      }

      if (front == rear) {
         front = rear = null;  // If there was only one element
      } else {
         rear = rear.prev;
         rear.next = null;
      }
   }

   // Get the front element
   public int getFront() {
      if (isEmpty()) {
         System.out.println("Deque is empty.");
         return -1;
      }
      return front.data;
   }

   // Get the rear element
   public int getRear() {
      if (isEmpty()) {
         System.out.println("Deque is empty.");
         return -1;
      }
      return rear.data;
   }

   // Display the elements in the deque
   public void display() {
      if (isEmpty()) {
         System.out.println("Deque is empty.");
         return;
      }

      System.out.print("Deque elements: ");
      Node current = front;
      while (current != null) {
         System.out.print(current.data + " ");
         current = current.next;
      }
      System.out.println();
   }
}
