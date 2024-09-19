package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.Priority.LinkedListImp;

public class PriorityQueueLinkedList {
   private Node front; // Front points to the highest priority element

   // Constructor to initialize the priority queue
   public PriorityQueueLinkedList() {
      front = null;
   }

   // Main method to test the implementation
   public static void main(String[] args) {
      PriorityQueueLinkedList pq = new PriorityQueueLinkedList();

      pq.enqueue(10, 2);
      pq.enqueue(20, 1);
      pq.enqueue(30, 3);

      pq.display(); // Displaying the priority queue

      System.out.println("Dequeued: " + pq.dequeue()); // Dequeue the highest priority element
      pq.display();

      System.out.println("Front element: " + pq.peek());
   }

   // Enqueue operation: Insert elements in sorted order based on priority
   public void enqueue(int data, int priority) {
      Node newNode = new Node(data, priority);

      // If the queue is empty or the new node has higher priority than the front node
      if (front == null || front.priority > priority) {
         newNode.next = front;
         front = newNode;
      } else {
         // Traverse and find the correct position for the new node
         Node current = front;
         while (current.next != null && current.next.priority <= priority) {
            current = current.next;
         }
         newNode.next = current.next;
         current.next = newNode;
      }
   }

   // Dequeue operation: Remove and return the highest priority element
   public int dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty. Cannot dequeue.");
      }
      int data = front.data;
      front = front.next;
      return data;
   }

   // Peek operation: Return the highest priority element without removing it
   public int peek() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty. Cannot peek.");
      }
      return front.data;
   }

   // Check if the queue is empty
   public boolean isEmpty() {
      return front == null;
   }

   // Display the elements in the queue
   public void display() {
      if (isEmpty()) {
         System.out.println("Queue is empty.");
         return;
      }

      System.out.print("Queue elements (data, priority): ");
      Node current = front;
      while (current != null) {
         System.out.print("(" + current.data + ", " + current.priority + ") ");
         current = current.next;
      }
      System.out.println();
   }
}
