package DataStructure.Linear.Queues.RealWorldApplications.LoadBalancing;

class Server {
   private final String serverId;

   public Server(String serverId) {
      this.serverId = serverId;
   }

   public String getServerId() {
      return serverId;
   }

   // Method to process a task
   public void processTask(Task task) {
      System.out.println("Server " + serverId + " is processing " + task);
   }
}

