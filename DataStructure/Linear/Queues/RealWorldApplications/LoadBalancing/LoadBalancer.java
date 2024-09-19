package DataStructure.Linear.Queues.RealWorldApplications.LoadBalancing;

import java.util.LinkedList;
import java.util.Queue;

public class LoadBalancer {
   private final Queue<Task> taskQueue;
   private final Server[] servers;
   private int serverIndex;

   // Constructor to initialize LoadBalancer
   public LoadBalancer(Server[] servers) {
      this.servers = servers;
      this.taskQueue = new LinkedList<>();
      this.serverIndex = 0;
   }

   // Main method to test load balancing simulation
   public static void main(String[] args) {
      // Create servers
      Server[] servers = {
              new Server("Server1"),
              new Server("Server2"),
              new Server("Server3")
      };

      // Create LoadBalancer
      LoadBalancer loadBalancer = new LoadBalancer(servers);

      // Adding tasks
      loadBalancer.addTask(new Task("T1"));
      loadBalancer.addTask(new Task("T2"));
      loadBalancer.addTask(new Task("T3"));
      loadBalancer.addTask(new Task("T4"));
      loadBalancer.addTask(new Task("T5"));

      // Distribute tasks
      System.out.println("Starting task distribution:");
      loadBalancer.distributeTasks();
   }

   // Method to add a task to the queue
   public void addTask(Task task) {
      taskQueue.offer(task);
      System.out.println("Task added to the queue: " + task);
   }

   // Method to distribute tasks to servers
   public void distributeTasks() {
      while (!taskQueue.isEmpty()) {
         Task task = taskQueue.poll(); // Retrieve and remove the task from the queue
         Server server = servers[serverIndex];
         server.processTask(task);

         // Move to the next server (round-robin)
         serverIndex = (serverIndex + 1) % servers.length;
      }
      System.out.println("All tasks have been distributed.");
   }
}

