package DataStructure.Linear.Stacks.StackVariation;

import java.util.Stack;

public class MinStack {
   // Main stack to store elements
   private final Stack<Integer> stack;
   // Stack to store the minimum values
   private final Stack<Integer> minStack;

   // Constructor to initialize both stacks
   public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
   }

   public static void main(String[] args) {
      MinStack minStack = new MinStack();

      minStack.push(5);
      minStack.push(3);
      minStack.push(7);
      minStack.push(2);

      System.out.println("Minimum element: " + minStack.getMin()); // Output: 2

      minStack.pop();
      System.out.println("Minimum element after popping: " + minStack.getMin()); // Output: 3

      minStack.pop();
      System.out.println("Top element: " + minStack.top()); // Output: 3
      System.out.println("Minimum element: " + minStack.getMin()); // Output: 3
   }

   // Push operation: Add element to the stack
   public void push(int value) {
      stack.push(value);

      // If minStack is empty or the new value is less than or equal to the current min, push it onto the minStack
      if (minStack.isEmpty() || value <= minStack.peek()) {
         minStack.push(value);
      }
   }

   // Pop operation: Remove the top element from the stack
   public void pop() {
      // Remove the top element from the main stack
      if (!stack.isEmpty()) {
         int removedElement = stack.pop();

         // If the removed element is the current minimum, pop from minStack as well
         if (removedElement == minStack.peek()) {
            minStack.pop();
         }
      }
   }

   // Top operation: Return the top element of the stack without removing it
   public int top() {
      return stack.peek();
   }

   // GetMin operation: Return the minimum element from the stack in O(1) time
   public int getMin() {
      return minStack.peek();
   }
}
