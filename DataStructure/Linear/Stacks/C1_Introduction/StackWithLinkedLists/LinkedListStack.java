package DataStructure.Linear.Stacks.C1_Introduction.StackWithLinkedLists;

public class LinkedListStack {
   private Node top; // Points to the top element of the stack

   // Constructor
   public LinkedListStack() {
      top = null; // Stack is empty initially
   }

   public static void main(String[] args) {
      LinkedListStack stack = new LinkedListStack();

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
      Node newNode = new Node(value); // Create a new node
      newNode.next = top; // New node points to the current top
      top = newNode; // Update top to the new node
      System.out.println("Pushed: " + value);
   }

   // Pop operation
   public int pop() {
      if (top != null) {
         int value = top.value; // Get the value at the top
         top = top.next; // Update top to the next node
         return value;
      } else {
         System.out.println("Stack Underflow");
         return -1; // Return -1 if stack is empty
      }
   }

   // Peek operation
   public int peek() {
      if (top != null) {
         return top.value; // Return the value at the top
      } else {
         System.out.println("Stack is empty");
         return -1;
      }
   }

   // IsEmpty operation
   public boolean isEmpty() {
      return top == null; // Stack is empty if top is null
   }
}

