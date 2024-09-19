package DataStructure.Linear.Queues.RealWorldApplications.PrintJobs;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {
   // Queue to manage print jobs
   private final Queue<PrintJob> jobQueue;

   // Constructor to initialize the print spooler
   public PrintSpooler() {
      jobQueue = new LinkedList<>();
   }

   // Main method to test the print spooler
   public static void main(String[] args) {
      PrintSpooler spooler = new PrintSpooler();

      // Adding print jobs to the spooler
      spooler.addPrintJob(1, "Document1.pdf");
      spooler.addPrintJob(2, "Report.docx");
      spooler.addPrintJob(3, "Invoice.xlsx");

      // Processing the print jobs
      spooler.processPrintJobs();
   }

   // Method to add a new print job to the spooler
   public void addPrintJob(int jobId, String documentName) {
      PrintJob newJob = new PrintJob(jobId, documentName);
      jobQueue.offer(newJob); // Add the print job to the queue
      System.out.println("Added to print queue: " + newJob);
   }

   // Method to process the print jobs from the queue
   public void processPrintJobs() {
      while (!jobQueue.isEmpty()) {
         PrintJob currentJob = jobQueue.poll(); // Get the next job from the queue
         System.out.println("Printing: " + currentJob);
         simulatePrintJob();
      }
      System.out.println("All print jobs completed.");
   }

   // Method to simulate printing process (for demonstration purposes)
   private void simulatePrintJob() {
      try {
         Thread.sleep(2000); // Simulating time taken to print a document
      } catch (InterruptedException e) {
         System.out.println("Error occurred during printing.");
      }
   }
}

