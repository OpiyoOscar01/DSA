package DataStructure.Linear.Queues.RealWorldApplications.NetworkPacketMagt;

// Packet class representing network packets
class Packet {
   private final String data;
   private final long timestamp; // Timestamp of when the packet was received

   public Packet(String data, long timestamp) {
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
      return "Packet Data: " + data + ", Timestamp: " + timestamp;
   }
}

// Router class simulating packet management

