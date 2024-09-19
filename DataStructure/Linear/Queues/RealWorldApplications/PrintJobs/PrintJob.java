package DataStructure.Linear.Queues.RealWorldApplications.PrintJobs;

class PrintJob {
   private final String documentName;
   private final int jobId;

   public PrintJob(int jobId, String documentName) {
      this.jobId = jobId;
      this.documentName = documentName;
   }

   public String getDocumentName() {
      return documentName;
   }

   public int getJobId() {
      return jobId;
   }

   @Override
   public String toString() {
      return "Print Job ID: " + jobId + ", Document: " + documentName;
   }
}


