package DataStructure.Linear.Stacks.StackVariation;

import java.util.PriorityQueue;

class PriorityStack {
   // Priority queue based on priority and timestamp (for LIFO order in same priority)
   private final PriorityQueue<Element> pq;
   private int currentTime; // To track order of insertion
   // Constructor
   public PriorityStack() {
      // Define the priority queue with custom comparator
      pq = new PriorityQueue<>((a, b) -> {
         // Higher priority first
         if (a.priority != b.priority) {
            return b.priority - a.priority;
         } else {
            // If same priority, follow LIFO order
            return b.timestamp - a.timestamp;
         }
      });
      currentTime = 0;
   }

   public static void main(String[] args) {
      PriorityStack stack = new PriorityStack();

      // Push elements with priorities
      stack.push(10, 2);  // Element 10 with priority 2
      stack.push(20, 1);  // Element 20 with priority 1
      stack.push(30, 3);  // Element 30 with priority 3
      stack.push(40, 2);  // Element 40 with priority 2

      // Peek the top element
      stack.peek(); // Outputs 30 (highest priority)

      // Pop elements and observe priority behavior
      stack.pop();  // Outputs 30 (highest priority)
      stack.pop();  // Outputs 10 (priority 2, LIFO behavior)
      stack.pop();  // Outputs 40 (priority 2, LIFO behavior)
      stack.pop();  // Outputs 20 (priority 1)

      // Check if the stack is empty
      System.out.println("Is stack empty? " + stack.isEmpty());
   }

   // Push an element with priority
   public void push(int value, int priority) {
      pq.offer(new Element(value, priority, currentTime++));
      System.out.println("Pushed: " + value + " with priority: " + priority);
   }

   // Pop the element with the highest priority (LIFO for same priority)
   public int pop() {
      if (pq.isEmpty()) {
         System.out.println("Stack Underflow");
         return -1;
      } else {
         Element top = pq.poll();
         System.out.println("Popped: " + top.value + " with priority: " + top.priority);
         return top.value;
      }
   }

   // Check if stack is empty
   public boolean isEmpty() {
      return pq.isEmpty();
   }

   // Peek the element with the highest priority
   public int peek() {
      if (pq.isEmpty()) {
         System.out.println("Stack is empty");
         return -1;
      } else {
         Element top = pq.peek();
         System.out.println("Peeked: " + top.value + " with priority: " + top.priority);
         return top.value;
      }
   }

   // Inner class to represent an element in the stack with priority
   static class Element {
      int value;
      int priority;
      int timestamp; // To keep track of order for LIFO behavior with same priority

      public Element(int value, int priority, int timestamp) {
         this.value = value;
         this.priority = priority;
         this.timestamp = timestamp;
      }
   }
}

