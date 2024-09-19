package DataStructure.Linear.Stacks.StackVariation;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleEndedStack {

   public static void main(String[] args) {
      // Create a Deque to function as a double-ended stack
      Deque<Integer> deque = new ArrayDeque<>();

      // Push elements to the front and back
      deque.addFirst(10); // Push to the front
      deque.addLast(20);  // Push to the back
      deque.addFirst(5);  // Push to the front again
      deque.addLast(30);  // Push to the back again

      // Peek elements from both ends
      System.out.println("Front element: " + deque.peekFirst()); // Outputs 5
      System.out.println("Back element: " + deque.peekLast());   // Outputs 30

      // Pop elements from both ends
      System.out.println("Popped from front: " + deque.removeFirst()); // Outputs 5
      System.out.println("Popped from back: " + deque.removeLast());   // Outputs 30

      // Final state of deque
      System.out.println("Remaining deque: " + deque); // Outputs [10, 20]

      // Pop remaining elements
      System.out.println("Popped from front: " + deque.removeFirst()); // Outputs 10
      System.out.println("Popped from back: " + deque.removeLast());   // Outputs 20

      // Check if deque is empty
      System.out.println("Is deque empty? " + deque.isEmpty()); // Outputs true
   }
}

