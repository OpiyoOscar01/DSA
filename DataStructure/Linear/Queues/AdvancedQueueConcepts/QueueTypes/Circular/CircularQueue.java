package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.Circular;

// Circular Queue class implemented using linked list
public class CircularQueue {
   private Node front, rear;
   private int size;

   // Constructor
   public CircularQueue() {
      front = null;
      rear = null;
      size = 0;
   }

   // Main method to test the circular queue implementation
   public static void main(String[] args) {
      CircularQueue queue = new CircularQueue();

      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
      queue.enqueue(40);

      System.out.println("Queue elements:");
      queue.display();

      System.out.println("Front item is: " + queue.peek());
      System.out.println("Queue size is: " + queue.size());

      System.out.println("Dequeued item is: " + queue.dequeue());
      System.out.println("Queue elements after dequeue:");
      queue.display();

      System.out.println("Queue size after dequeue: " + queue.size());
   }

   // Enqueue operation to add an element to the rear of the queue
   public void enqueue(int data) {
      Node newNode = new Node(data);

      // If the queue is empty, the new node becomes both the front and rear
      if (isEmpty()) {
         front = newNode;
         rear = newNode;
         newNode.next = front;  // Pointing the rear to the front to make it circular
      } else {
         // Add the new node at the end and update rear
         rear.next = newNode;
         rear = newNode;
         rear.next = front;  // Pointing the rear to the front to maintain the circular nature
      }
      size++;
   }

   // Dequeue operation to remove and return the front element
   public int dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty");
      }

      int data;

      // If there's only one element, set both front and rear to null
      if (front == rear) {
         data = front.data;
         front = rear = null;
      } else {
         data = front.data;
         front = front.next;
         rear.next = front;  // Updating the rear's next pointer to point to the new front
      }
      size--;
      return data;
   }

   // Peek operation to return the front element without removing it
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

      Node temp = front;
      do {
         System.out.print(temp.data + " ");
         temp = temp.next;
      } while (temp != front);  // Stop when we've traversed back to the front
      System.out.println();
   }
}
