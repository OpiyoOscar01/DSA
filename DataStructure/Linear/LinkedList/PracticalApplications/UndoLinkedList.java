package DataStructure.Linear.LinkedList.PracticalApplications;

class UndoLinkedList {
   private Node head;

   public static void main(String[] args) {
      UndoLinkedList editorHistory = new UndoLinkedList();

      editorHistory.addState("Initial text");
      editorHistory.addState("Added first sentence");
      editorHistory.addState("Added second sentence");
      editorHistory.displayCurrentState();

      editorHistory.undo(); // Undo second sentence
      editorHistory.displayCurrentState();

      editorHistory.undo(); // Undo first sentence
      editorHistory.displayCurrentState();
   }

   // Push a new state to the linked list
   public void addState(String newState) {
      Node newNode = new Node(newState);
      newNode.next = head;
      head = newNode;
   }

   // Undo the last operation by removing the top of the list
   public void undo() {
      if (head != null) {
         System.out.println("Undo: " + head.state);
         head = head.next;
      } else {
         System.out.println("No more actions to undo.");
      }
   }

   // Display the current state
   public void displayCurrentState() {
      if (head != null) {
         System.out.println("Current State: " + head.state);
      } else {
         System.out.println("No current state.");
      }
   }

   class Node {
      String state;
      Node next;

      public Node(String state) {
         this.state = state;
      }
   }
}

