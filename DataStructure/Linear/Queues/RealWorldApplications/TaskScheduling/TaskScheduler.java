package DataStructure.Linear.Queues.RealWorldApplications.TaskScheduling;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {
   // Queue to store tasks
   private final Queue<Task> taskQueue;

   // Constructor to initialize the task scheduler
   public TaskScheduler() {
      taskQueue = new LinkedList<>();
   }

   // Main method to test the task scheduling
   public static void main(String[] args) {
      TaskScheduler scheduler = new TaskScheduler();

      // Adding tasks to the queue
      scheduler.addTask(1, "Task 1 - Data Backup");
      scheduler.addTask(2, "Task 2 - Security Check");
      scheduler.addTask(3, "Task 3 - Software Update");

      // Processing tasks in the order they were added
      scheduler.processTasks();
   }

   // Method to add a task to the queue
   public void addTask(int taskId, String taskName) {
      Task newTask = new Task(taskId, taskName);
      taskQueue.offer(newTask); // Add task to the end of the queue
      System.out.println("Added: " + newTask);
   }

   // Method to process tasks in the queue
   public void processTasks() {
      while (!taskQueue.isEmpty()) {
         Task currentTask = taskQueue.poll(); // Retrieve and remove the task from the front of the queue
         System.out.println("Processing: " + currentTask);
      }
      System.out.println("All tasks processed.");
   }
}

