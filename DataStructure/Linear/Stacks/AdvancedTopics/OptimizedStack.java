package DataStructure.Linear.Stacks.AdvancedTopics;

import java.util.Arrays;

public class OptimizedStack {
   private int[] stackArray;
   private int top;
   private int capacity;

   // Constructor to initialize the stack with a small initial capacity
   public OptimizedStack() {
      capacity = 2; // Start with a small capacity to save memory
      stackArray = new int[capacity];
      top = -1;
   }

   public static void main(String[] args) {
      OptimizedStack stack = new OptimizedStack();

      // Test stack operations
      stack.push(10);
      stack.push(20);
      stack.push(30);
      System.out.println("Top element is: " + stack.peek());
      System.out.println("Popped element: " + stack.pop());
      System.out.println("Popped element: " + stack.pop());
      System.out.println("Is stack empty? " + stack.isEmpty());
   }

   // Push operation with dynamic resizing for memory efficiency
   public void push(int value) {
      if (top == capacity - 1) {
         resize(); // Double the capacity when stack is full
      }
      stackArray[++top] = value;
      System.out.println("Pushed: " + value);
   }

   // Pop operation
   public int pop() {
      if (top == -1) {
         throw new RuntimeException("Stack underflow");
      }
      return stackArray[top--];
   }

   // Peek operation
   public int peek() {
      if (top == -1) {
         throw new RuntimeException("Stack is empty");
      }
      return stackArray[top];
   }

   // Resize the stack array dynamically to optimize memory
   private void resize() {
      capacity = capacity * 2; // Double the size
      stackArray = Arrays.copyOf(stackArray, capacity); // Copy old elements to new array
   }

   public boolean isEmpty() {
      return top == -1;
   }

   public int size() {
      return top + 1;
   }
}

