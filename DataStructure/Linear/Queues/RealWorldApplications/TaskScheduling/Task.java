package DataStructure.Linear.Queues.RealWorldApplications.TaskScheduling;

class Task {
   private final String taskName;
   private final int taskId;

   public Task(int taskId, String taskName) {
      this.taskId = taskId;
      this.taskName = taskName;
   }

   public String getTaskName() {
      return taskName;
   }

   public int getTaskId() {
      return taskId;
   }

   @Override
   public String toString() {
      return "Task ID: " + taskId + ", Task Name: " + taskName;
   }
}


