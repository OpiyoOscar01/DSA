package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists;

import java.util.Random;

// Node class representing each element in the skip list


// Node class representing each element in the skip list


// Skip List class
public class SkipList {
   private final int MAX_LEVEL = 4; // Maximum number of levels
   private final SkipListNode head; // Head node of the skip list
   private int level; // Current level of the skip list
   private final Random random;
   // Constructor
   public SkipList() {
      head = new SkipListNode(-1, MAX_LEVEL); // Head node with dummy value
      level = 0; // Initially, the skip list has only one level
      random = new Random();
   }

   // Main method for testing
   public static void main(String[] args) {
      SkipList skipList = new SkipList();

      // Inserting elements
      skipList.insert(3);
      skipList.insert(6);
      skipList.insert(7);
      skipList.insert(9);
      skipList.insert(12);
      skipList.insert(19);
      skipList.insert(17);

      // Printing skip list
      skipList.printSkipList();

      // Searching for elements
      System.out.println("Searching for 7: " + skipList.search(7));

      // Deleting elements
      skipList.delete(7);

      // Printing skip list after deletion
      skipList.printSkipList();
   }

   // Method to generate a random level for insertion
   private int randomLevel() {
      int lvl = 0;
      while (lvl < MAX_LEVEL && random.nextDouble() < 0.5) {
         lvl++;
      }
      return lvl;
   }

   // Method to insert an element into the skip list
   public void insert(int value) {
      SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
      SkipListNode current = head;

      // Traverse through the skip list to find the position for insertion
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

      // Create a new node and insert it at the appropriate level
      SkipListNode newNode = new SkipListNode(value, newLevel);
      for (int i = 0; i <= newLevel; i++) {
         newNode.forward[i] = update[i].forward[i];
         update[i].forward[i] = newNode;
      }
   }

   // Method to search for an element in the skip list
   public boolean search(int value) {
      SkipListNode current = head;
      for (int i = level; i >= 0; i--) {
         while (current.forward[i] != null && current.forward[i].value < value) {
            current = current.forward[i];
         }
      }
      current = current.forward[0];
      return current != null && current.value == value;
   }

   // Method to delete an element from the skip list
   public void delete(int value) {
      SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
      SkipListNode current = head;

      // Traverse through the skip list to find the position for deletion
      for (int i = level; i >= 0; i--) {
         while (current.forward[i] != null && current.forward[i].value < value) {
            current = current.forward[i];
         }
         update[i] = current;
      }

      current = current.forward[0];

      if (current != null && current.value == value) {
         for (int i = 0; i <= level; i++) {
            if (update[i].forward[i] != current) break;
            update[i].forward[i] = current.forward[i];
         }

         while (level > 0 && head.forward[level] == null) {
            level--;
         }
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

   public static class SkipListNode {
      int value;
      SkipListNode[] forward;

      // Constructor for initializing a node
      public SkipListNode(int value, int level) {
         this.value = value;
         forward = new SkipListNode[level + 1]; // Array of forward pointers for each level
      }
   }
}


