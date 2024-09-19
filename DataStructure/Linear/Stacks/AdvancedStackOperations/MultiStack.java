package DataStructure.Linear.Stacks.AdvancedStackOperations;

public class MultiStack {
   private final int[] stackArray;
   private final int[] stackTop;
   private final int numStacks;
   private final int stackSize;

   // Constructor
   public MultiStack(int numStacks, int stackSize) {
      this.numStacks = numStacks;
      this.stackSize = stackSize;
      this.stackArray = new int[numStacks * stackSize];
      this.stackTop = new int[numStacks];

      // Initialize all stack tops to -1
      for (int i = 0; i < numStacks; i++) {
         stackTop[i] = -1;
      }
   }

   public static void main(String[] args) {
      MultiStack multiStack = new MultiStack(3, 5); // 3 stacks, each with size 5

      // Push values to different stacks
      multiStack.push(0, 10);
      multiStack.push(1, 20);
      multiStack.push(2, 30);

      // Peek top values
      System.out.println("Top element of stack 0: " + multiStack.peek(0));
      System.out.println("Top element of stack 1: " + multiStack.peek(1));
      System.out.println("Top element of stack 2: " + multiStack.peek(2));

      // Pop values from different stacks
      System.out.println("Popped element from stack 0: " + multiStack.pop(0));
      System.out.println("Popped element from stack 1: " + multiStack.pop(1));
      System.out.println("Popped element from stack 2: " + multiStack.pop(2));

      // Check if stacks are empty
      System.out.println("Is stack 0 empty? " + multiStack.isEmpty(0));
      System.out.println("Is stack 1 empty? " + multiStack.isEmpty(1));
      System.out.println("Is stack 2 empty? " + multiStack.isEmpty(2));
   }

   // Push operation
   public void push(int stackNum, int value) {
      if (stackNum < 0 || stackNum >= numStacks) {
         throw new IllegalArgumentException("Invalid stack number");
      }

      int topIndex = stackNum * stackSize + stackTop[stackNum] + 1;
      if (topIndex >= (stackNum + 1) * stackSize) {
         System.out.println("Stack " + stackNum + " Overflow");
         return;
      }

      stackArray[topIndex] = value;
      stackTop[stackNum]++;
      System.out.println("Pushed " + value + " to stack " + stackNum);
   }

   // Pop operation
   public int pop(int stackNum) {
      if (stackNum < 0 || stackNum >= numStacks) {
         throw new IllegalArgumentException("Invalid stack number");
      }

      if (stackTop[stackNum] < 0) {
         System.out.println("Stack " + stackNum + " Underflow");
         return -1;
      }

      int topIndex = stackNum * stackSize + stackTop[stackNum];
      int value = stackArray[topIndex];
      stackTop[stackNum]--;
      return value;
   }

   // Peek operation
   public int peek(int stackNum) {
      if (stackNum < 0 || stackNum >= numStacks) {
         throw new IllegalArgumentException("Invalid stack number");
      }

      if (stackTop[stackNum] < 0) {
         System.out.println("Stack " + stackNum + " is empty");
         return -1;
      }

      int topIndex = stackNum * stackSize + stackTop[stackNum];
      return stackArray[topIndex];
   }

   // IsEmpty operation
   public boolean isEmpty(int stackNum) {
      if (stackNum < 0 || stackNum >= numStacks) {
         throw new IllegalArgumentException("Invalid stack number");
      }
      return stackTop[stackNum] < 0;
   }
}

