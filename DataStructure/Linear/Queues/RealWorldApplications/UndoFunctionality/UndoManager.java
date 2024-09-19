package DataStructure.Linear.Queues.RealWorldApplications.UndoFunctionality;

import java.util.LinkedList;
import java.util.Queue;

public class UndoManager {
   // Queue to store actions for undo
   private final Queue<Action> actionQueue;

   // Constructor to initialize UndoManager
   public UndoManager() {
      actionQueue = new LinkedList<>();
   }

   // Main method to test undo mechanism
   public static void main(String[] args) {
      UndoManager undoManager = new UndoManager();

      // Performing actions
      undoManager.performAction("Open file");
      undoManager.performAction("Edit file");
      undoManager.performAction("Save file");

      // Displaying actions
      undoManager.displayActions();

      // Undoing actions
      System.out.println("Starting undo operations:");
      undoManager.undo(); // Undo Save file
      undoManager.undo(); // Undo Edit file
      undoManager.undo(); // Undo Open file
      undoManager.undo(); // No actions to undo
   }

   // Method to add a new action to the queue
   public void performAction(String description) {
      Action action = new Action(description);
      actionQueue.offer(action); // Add the action to the queue
      System.out.println("Performed action: " + action);
   }

   // Method to undo the most recent action
   public void undo() {
      if (!actionQueue.isEmpty()) {
         Action lastAction = ((LinkedList<Action>) actionQueue).removeLast(); // Remove and get the most recent action
         System.out.println("Undone action: " + lastAction);
      } else {
         System.out.println("No actions to undo.");
      }
   }

   // Method to display all actions in the queue
   public void displayActions() {
      if (actionQueue.isEmpty()) {
         System.out.println("No actions performed.");
      } else {
         System.out.println("Actions in queue:");
         for (Action action : actionQueue) {
            System.out.println(action);
         }
      }
   }
}

