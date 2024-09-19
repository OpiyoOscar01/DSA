package DataStructure.Linear.Queues.RealWorldApplications.NetworkPacketMagt;

import java.util.LinkedList;
import java.util.Queue;

public class PacketRouter {
   // Queue to manage incoming packets
   private final Queue<Packet> packetQueue;

   // Constructor to initialize the router
   public PacketRouter() {
      packetQueue = new LinkedList<>();
   }

   // Main method to test packet management simulation
   public static void main(String[] args) {
      PacketRouter router = new PacketRouter();

      // Receiving packets
      router.receivePacket("Packet 1: Hello, World!");
      router.receivePacket("Packet 2: Network Packet Management");
      router.receivePacket("Packet 3: Java Simulation");

      // Processing packets
      System.out.println("Starting packet processing:");
      router.processPackets();
   }

   // Method to add a new packet to the queue
   public void receivePacket(String data) {
      long currentTime = System.currentTimeMillis();
      Packet newPacket = new Packet(data, currentTime);
      packetQueue.offer(newPacket); // Add the packet to the queue
      System.out.println("Received and queued: " + newPacket);
   }

   // Method to process packets from the queue
   public void processPackets() {
      while (!packetQueue.isEmpty()) {
         Packet packet = packetQueue.poll(); // Retrieve and remove the packet from the front of the queue
         System.out.println("Processing: " + packet);
         simulatePacketProcessing();
      }
      System.out.println("All packets processed.");
   }

   // Method to simulate packet processing time (for demonstration purposes)
   private void simulatePacketProcessing() {
      try {
         Thread.sleep(500); // Simulate time taken to process each packet
      } catch (InterruptedException e) {
         System.out.println("Error occurred during packet processing.");
      }
   }
}

