package DataStructure.Linear.Stacks.AdvancedTopics;

import java.util.ArrayList;

public class DynamicArrayStack<T> {
   private final ArrayList<T> stackList;

   // Constructor to initialize the dynamic stack
   public DynamicArrayStack() {
      stackList = new ArrayList<>();
   }

   // Main method to test the dynamic stack
   public static void main(String[] args) {
      DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();

      // Test push operation
      stack.push(10);
      stack.push(20);
      stack.push(30);

      // Test peek operation
      System.out.println("Top element is: " + stack.peek());

      // Test pop operation
      System.out.println("Popped element: " + stack.pop());
      System.out.println("Popped element: " + stack.pop());

      // Test if stack is empty
      System.out.println("Is stack empty? " + stack.isEmpty());

      // Test remaining size
      System.out.println("Stack size is: " + stack.size());
   }

   // Push operation to add an element to the stack
   public void push(T value) {
      stackList.add(value);
      System.out.println("Pushed: " + value);
   }

   // Pop operation to remove the top element from the stack
   public T pop() {
      if (isEmpty()) {
         System.out.println("Stack Underflow - Stack is empty");
         return null;
      }
      return stackList.remove(stackList.size() - 1); // Remove and return the top element
   }

   // Peek operation to look at the top element without removing it
   public T peek() {
      if (isEmpty()) {
         System.out.println("Stack is empty");
         return null;
      }
      return stackList.get(stackList.size() - 1); // Return the top element
   }

   // Check if the stack is empty
   public boolean isEmpty() {
      return stackList.isEmpty();
   }

   // Get the size of the stack
   public int size() {
      return stackList.size();
   }
}

