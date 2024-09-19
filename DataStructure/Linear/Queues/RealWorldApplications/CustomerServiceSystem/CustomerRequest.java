package DataStructure.Linear.Queues.RealWorldApplications.CustomerServiceSystem;

class CustomerRequest {
   private final String requestType; // Type of request (e.g., call, ticket)
   private final int requestId; // Unique identifier for each request

   public CustomerRequest(int requestId, String requestType) {
      this.requestId = requestId;
      this.requestType = requestType;
   }

   public String getRequestType() {
      return requestType;
   }

   public int getRequestId() {
      return requestId;
   }

   @Override
   public String toString() {
      return "Request ID: " + requestId + ", Type: " + requestType;
   }
}


