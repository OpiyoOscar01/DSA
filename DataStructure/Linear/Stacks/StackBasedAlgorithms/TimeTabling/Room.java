package DataStructure.Linear.Stacks.StackBasedAlgorithms.TimeTabling;

// File: Room.java
public class Room {
   private final String roomName;

   public Room(String roomName) {
      this.roomName = roomName;
   }

   public String getRoomName() {
      return roomName;
   }

   @Override
   public String toString() {
      return roomName;
   }
}

