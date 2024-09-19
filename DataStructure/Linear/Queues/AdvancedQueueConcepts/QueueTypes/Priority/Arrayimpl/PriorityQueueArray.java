package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.Priority.Arrayimpl;

public class PriorityQueueArray {
   private final int[] data;
   private final int[] priority;
   private final int capacity;
   private int size;

   // Constructor to initialize the priority queue
   public PriorityQueueArray(int capacity) {
      this.capacity = capacity;
      data = new int[capacity];
      priority = new int[capacity];
      size = 0;
   }

   // Main method to test the implementation
   public static void main(String[] args) {
      PriorityQueueArray pq = new PriorityQueueArray(5);

      pq.enqueue(10, 2);
      pq.enqueue(20, 1);
      pq.enqueue(30, 3);

      pq.display();

      System.out.println("Dequeued: " + pq.dequeue());
      pq.display();

      System.out.println("Front element: " + pq.peek());
   }

   // Enqueue operation: Insert elements and sort based on priority
   public void enqueue(int value, int priorityValue) {
      if (isFull()) {
         System.out.println("Queue is full. Cannot enqueue " + value);
         return;
      }

      data[size] = value;
      priority[size] = priorityValue;
      size++;

      // Sort based on priority (smaller priority value means higher priority)
      for (int i = 0; i < size - 1; i++) {
         for (int j = i + 1; j < size; j++) {
            if (priority[i] > priority[j]) {
               // Swap both data and priority values
               int tempData = data[i];
               data[i] = data[j];
               data[j] = tempData;

               int tempPriority = priority[i];
               priority[i] = priority[j];
               priority[j] = tempPriority;
            }
         }
      }
   }

   // Dequeue operation: Remove and return the element with the highest priority
   public int dequeue() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty. Cannot dequeue.");
      }

      int value = data[0];

      // Shift elements to the left after dequeuing
      for (int i = 1; i < size; i++) {
         data[i - 1] = data[i];
         priority[i - 1] = priority[i];
      }

      size--;
      return value;
   }

   // Peek operation: Return the highest priority element without removing it
   public int peek() {
      if (isEmpty()) {
         throw new RuntimeException("Queue is empty. Cannot peek.");
      }
      return data[0];
   }

   // Check if the queue is empty
   public boolean isEmpty() {
      return size == 0;
   }

   // Check if the queue is full
   public boolean isFull() {
      return size == capacity;
   }

   // Display the elements in the queue
   public void display() {
      if (isEmpty()) {
         System.out.println("Queue is empty.");
         return;
      }

      System.out.print("Queue elements (data, priority): ");
      for (int i = 0; i < size; i++) {
         System.out.print("(" + data[i] + ", " + priority[i] + ") ");
      }
      System.out.println();
   }
}

