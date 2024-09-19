package DataStructure.Linear.Queues.RealWorldApplications.UndoFunctionality;

// Action class representing user actions
class Action {
   private final String description;

   public Action(String description) {
      this.description = description;
   }

   public String getDescription() {
      return description;
   }

   @Override
   public String toString() {
      return description;
   }
}

// UndoManager class to manage undo operations

