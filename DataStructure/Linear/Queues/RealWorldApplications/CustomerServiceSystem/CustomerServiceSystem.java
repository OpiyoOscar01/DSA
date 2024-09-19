package DataStructure.Linear.Queues.RealWorldApplications.CustomerServiceSystem;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceSystem {
   // Queue to manage customer requests
   private final Queue<CustomerRequest> requestQueue;

   // Constructor to initialize the customer service system
   public CustomerServiceSystem() {
      requestQueue = new LinkedList<>();
   }

   // Main method to test the customer service system
   public static void main(String[] args) {
      CustomerServiceSystem serviceSystem = new CustomerServiceSystem();

      // Adding customer requests to the queue
      serviceSystem.addRequest(1, "Call - Technical Support");
      serviceSystem.addRequest(2, "Ticket - Billing Issue");
      serviceSystem.addRequest(3, "Call - General Inquiry");

      // Processing the customer requests
      System.out.println("Customer service system processing requests:");
      serviceSystem.processRequests();
   }

   // Method to add a new customer request to the queue
   public void addRequest(int requestId, String requestType) {
      CustomerRequest newRequest = new CustomerRequest(requestId, requestType);
      requestQueue.offer(newRequest); // Add the request to the queue
      System.out.println("Added to request queue: " + newRequest);
   }

   // Method to process customer requests from the queue
   public void processRequests() {
      while (!requestQueue.isEmpty()) {
         CustomerRequest currentRequest = requestQueue.poll(); // Retrieve and remove the request from the front of the queue
         System.out.println("Processing: " + currentRequest);
         simulateRequestProcessing();
      }
      System.out.println("All requests processed.");
   }

   // Method to simulate processing time (for demonstration purposes)
   private void simulateRequestProcessing() {
      try {
         Thread.sleep(1500); // Simulate time taken to process a request
      } catch (InterruptedException e) {
         System.out.println("Error occurred during request processing.");
      }
   }
}

