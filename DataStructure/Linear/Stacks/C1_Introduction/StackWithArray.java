package DataStructure.Linear.Stacks.C1_Introduction;

public class StackWithArray {
   private final int maxSize;
   private int top;
   private final int[] stackArray;

   // Constructor
   public StackWithArray(int size) {
      maxSize = size;
      stackArray = new int[maxSize];
      top = -1; // Stack is empty initially
   }

   public static void main(String[] args) {
      StackWithArray stack = new StackWithArray(5);

      // Test stack operations
      stack.push(10);
      stack.push(20);
      stack.push(30);

      System.out.println("Top element is: " + stack.peek());

      System.out.println("Popped element: " + stack.pop());
      System.out.println("Popped element: " + stack.pop());

      System.out.println("Is stack empty? " + stack.isEmpty());
   }

   // Push operation
   public void push(int value) {
      if (top < maxSize - 1) {
         stackArray[++top] = value;
         System.out.println("Pushed: " + value);
      } else {
         System.out.println("Stack Overflow");
      }
   }

   // Pop operation
   public int pop() {
      if (top >= 0) {
         return stackArray[top--];
      } else {
         System.out.println("Stack Underflow");
         return -1; // Return -1 if stack is empty
      }
   }

   // Peek operation
   public int peek() {
      if (top >= 0) {
         return stackArray[top];
      } else {
         System.out.println("Stack is empty");
         return -1;
      }
   }

   // IsEmpty operation
   public boolean isEmpty() {
      return top == -1;
   }
}

