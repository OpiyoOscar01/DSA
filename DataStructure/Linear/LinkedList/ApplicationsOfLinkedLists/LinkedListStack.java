package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists;


public class LinkedListStack {

   public static void main(String[] args) {
      Stack stack = new Stack();

      // Push elements onto the stack
      stack.push(10);
      stack.push(20);
      stack.push(30);

      // Display the stack
      System.out.println("Stack after pushes:");
      stack.displayStack();

      // Peek top element
      System.out.println("Top element: " + stack.peek());

      // Pop an element
      System.out.println("Popped element: " + stack.pop());

      // Display the stack after pop
      System.out.println("Stack after pop:");
      stack.displayStack();

      // Check if the stack is empty
      System.out.println("Is stack empty? " + stack.isEmpty());
   }

   // Node class representing each element in the stack
   static class Node {
      int data;
      Node next;

      // Constructor to create a new node
      Node(int data) {
         this.data = data;
         this.next = null;
      }
   }

   // Stack class
   static class Stack {
      Node top; // Points to the top node of the stack

      // Constructor to initialize the stack
      Stack() {
         top = null;
      }

      // Method to add an element to the top of the stack
      public void push(int data) {
         Node newNode = new Node(data);
         newNode.next = top; // New node points to the old top
         top = newNode; // Update top to be the new node
      }

      // Method to remove an element from the top of the stack
      public int pop() {
         if (top == null) {
            throw new RuntimeException("Stack is empty");
         }
         int data = top.data;
         top = top.next; // Move top to the next node
         return data;
      }

      // Method to retrieve the top element without removing it
      public int peek() {
         if (top == null) {
            throw new RuntimeException("Stack is empty");
         }
         return top.data;
      }

      // Method to check if the stack is empty
      public boolean isEmpty() {
         return top == null;
      }

      // Method to display the stack elements
      public void displayStack() {
         Node current = top;
         while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
         }
         System.out.println("null");
      }
   }
}

