package DataStructure.Linear.Queues.RealWorldApplications.RealTimeDataProcessing;

import java.util.LinkedList;
import java.util.Queue;

public class RealTimeDataProcessor {
   // Queue to manage incoming data streams
   private final Queue<DataStream> dataQueue;

   // Constructor to initialize the data processor
   public RealTimeDataProcessor() {
      dataQueue = new LinkedList<>();
   }

   // Main method to test the real-time data processing system
   public static void main(String[] args) {
      RealTimeDataProcessor processor = new RealTimeDataProcessor();

      // Adding data to the queue
      processor.addData("Stock price: $150");
      processor.addData("Sensor reading: 75°C");
      processor.addData("Trade executed: Buy 100 shares");

      // Processing the data
      System.out.println("Real-time data processing:");
      processor.processData();
   }

   // Method to add new data to the queue
   public void addData(String data) {
      long currentTime = System.currentTimeMillis();
      DataStream newData = new DataStream(data, currentTime);
      dataQueue.offer(newData); // Add the data to the queue
      System.out.println("Data added to queue: " + newData);
   }

   // Method to process the data from the queue
   public void processData() {
      while (!dataQueue.isEmpty()) {
         DataStream currentData = dataQueue.poll(); // Retrieve and remove the data from the front of the queue
         System.out.println("Processing: " + currentData);
         simulateDataProcessing();
      }
      System.out.println("All data processed.");
   }

   // Method to simulate data processing time (for demonstration purposes)
   private void simulateDataProcessing() {
      try {
         Thread.sleep(1000); // Simulate time taken to process data
      } catch (InterruptedException e) {
         System.out.println("Error occurred during data processing.");
      }
   }
}

