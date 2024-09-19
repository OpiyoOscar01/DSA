package DataStructure.Linear.LinkedList.AdvancedLinkedList.Challenge;


import java.util.Random;

public class SkipListCustom {
   private final int MAX_LEVEL;
   private final SkipListNode head;
   private int level;
   private final Random random;
   private final double probability;

   // Constructor with customizable max level and probability
   public SkipListCustom(int maxLevel, double probability) {
      MAX_LEVEL = maxLevel;
      head = new SkipListNode(-1, MAX_LEVEL); // Head node with dummy value
      level = 0;
      random = new Random();
      this.probability = probability; // Custom probability for promotion
   }

   // Main method for testing
   public static void main(String[] args) {
      SkipListCustom skipList = new SkipListCustom(4, 0.7); // Custom probability of 0.7

      // Inserting elements
      skipList.insert(5);
      skipList.insert(15);
      skipList.insert(25);
      skipList.insert(35);
      skipList.insert(45);

      // Printing the skip list
      skipList.printSkipList();
   }

   // Method to generate a random level for insertion based on probability
   private int randomLevel() {
      int lvl = 0;
      while (lvl < MAX_LEVEL && random.nextDouble() < probability) {
         lvl++;
      }
      return lvl;
   }

   // Method to insert an element into the skip list
   public void insert(int value) {
      SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
      SkipListNode current = head;

      // Traverse the skip list to find the position for insertion
      for (int i = level; i >= 0; i--) {
         while (current.forward[i] != null && current.forward[i].value < value) {
            current = current.forward[i];
         }
         update[i] = current;
      }

      // Generate a random level for the new node
      int newLevel = randomLevel();

      if (newLevel > level) {
         for (int i = level + 1; i <= newLevel; i++) {
            update[i] = head;
         }
         level = newLevel;
      }

      // Create a new node and insert it at the appropriate levels
      SkipListNode newNode = new SkipListNode(value, newLevel);
      for (int i = 0; i <= newLevel; i++) {
         newNode.forward[i] = update[i].forward[i];
         update[i].forward[i] = newNode;
      }
   }

   // Method to print the skip list
   public void printSkipList() {
      for (int i = 0; i <= level; i++) {
         SkipListNode current = head.forward[i];
         System.out.print("Level " + i + ": ");
         while (current != null) {
            System.out.print(current.value + " ");
            current = current.forward[i];
         }
         System.out.println();
      }
   }
}
