package DataStructure.Linear.Queues.RealWorldApplications.RealTimeDataProcessing;

class DataStream {
   private final String data;
   private final long timestamp; // Timestamp of when the data was received

   public DataStream(String data, long timestamp) {
      this.data = data;
      this.timestamp = timestamp;
   }

   public String getData() {
      return data;
   }

   public long getTimestamp() {
      return timestamp;
   }

   @Override
   public String toString() {
      return "Data: " + data + ", Timestamp: " + timestamp;
   }
}


