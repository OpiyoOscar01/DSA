package DataStructure.Linear.Queues.RealWorldApplications.LoadBalancing;

// Task class representing a request or task to be processed
class Task {
   private final String taskId;

   public Task(String taskId) {
      this.taskId = taskId;
   }

   public String getTaskId() {
      return taskId;
   }

   @Override
   public String toString() {
      return "Task ID: " + taskId;
   }
}



