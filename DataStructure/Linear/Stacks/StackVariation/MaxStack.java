package DataStructure.Linear.Stacks.StackVariation;

import java.util.Stack;

public class MaxStack {
   // Main stack to store elements
   private final Stack<Integer> stack;
   // Stack to store the maximum values
   private final Stack<Integer> maxStack;

   // Constructor to initialize both stacks
   public MaxStack() {
      stack = new Stack<>();
      maxStack = new Stack<>();
   }

   public static void main(String[] args) {
      MaxStack maxStack = new MaxStack();

      maxStack.push(5);
      maxStack.push(3);
      maxStack.push(7);
      maxStack.push(2);

      System.out.println("Maximum element: " + maxStack.getMax()); // Output: 7

      maxStack.pop();
      System.out.println("Maximum element after popping: " + maxStack.getMax()); // Output: 7

      maxStack.pop();
      System.out.println("Top element: " + maxStack.top()); // Output: 3
      System.out.println("Maximum element: " + maxStack.getMax()); // Output: 5
   }

   // Push operation: Add element to the stack
   public void push(int value) {
      stack.push(value);

      // If maxStack is empty or the new value is greater than or equal to the current max, push it onto the maxStack
      if (maxStack.isEmpty() || value >= maxStack.peek()) {
         maxStack.push(value);
      }
   }

   // Pop operation: Remove the top element from the stack
   public void pop() {
      // Remove the top element from the main stack
      if (!stack.isEmpty()) {
         int removedElement = stack.pop();

         // If the removed element is the current maximum, pop from maxStack as well
         if (removedElement == maxStack.peek()) {
            maxStack.pop();
         }
      }
   }

   // Top operation: Return the top element of the stack without removing it
   public int top() {
      return stack.peek();
   }

   // GetMax operation: Return the maximum element from the stack in O(1) time
   public int getMax() {
      return maxStack.peek();
   }
}

