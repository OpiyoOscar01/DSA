package DataStructure.Linear.HashTables;

public class HashTable {
   private final HashNode[] buckets;
   private final int numOfBuckets;
   private int size;

   // Constructor to initialize the hash table with a given size
   public HashTable(int size) {
      this.numOfBuckets = size;
      this.buckets = new HashNode[size];
      this.size = 0;
   }

   // Main method to test the HashTable operations
   public static void main(String[] args) {
      HashTable hashTable = new HashTable(10);

      // Adding key-value pairs
      hashTable.put(1, "Value1");
      hashTable.put(2, "Value2");
      hashTable.put(11, "Value11"); // Collision with key 1

      // Retrieving values
      System.out.println("Get key 1: " + hashTable.get(1)); // Output: Value1
      System.out.println("Get key 2: " + hashTable.get(2)); // Output: Value2
      System.out.println("Get key 11: " + hashTable.get(11)); // Output: Value11
      System.out.println("Get key 3: " + hashTable.get(3)); // Output: null

      // Checking if keys exist
      System.out.println("Contains key 1: " + hashTable.containsKey(1)); // Output: true
      System.out.println("Contains key 3: " + hashTable.containsKey(3)); // Output: false

      // Removing a key
      hashTable.remove(1);
      System.out.println("Get key 1 after removal: " + hashTable.get(1)); // Output: null

      // Printing the hash table
      hashTable.printHashTable();
   }

   // Method to calculate the hash index for a given key
   private int getBucketIndex(int key) {
      return key % numOfBuckets;
   }

   // Method to add or update key-value pair in the hash table
   public void put(int key, String value) {
      int index = getBucketIndex(key);
      HashNode newNode = new HashNode(key, value);

      if (buckets[index] == null) {
         buckets[index] = newNode; // No collision
      } else {
         HashNode current = buckets[index];
         while (current != null) {
            if (current.key == key) {
               current.value = value; // Update existing value
               return;
            }
            current = current.next;
         }
         // Collision: add the new node at the beginning of the list
         newNode.next = buckets[index];
         buckets[index] = newNode;
      }
      size++;
   }

   // Method to retrieve value for a given key
   public String get(int key) {
      int index = getBucketIndex(key);
      HashNode current = buckets[index];

      while (current != null) {
         if (current.key == key) {
            return current.value;
         }
         current = current.next;
      }
      return null; // Key not found
   }

   // Method to remove a key-value pair from the hash table
   public void remove(int key) {
      int index = getBucketIndex(key);
      HashNode current = buckets[index];
      HashNode previous = null;

      while (current != null) {
         if (current.key == key) {
            if (previous == null) {
               buckets[index] = current.next; // Removing the first node
            } else {
               previous.next = current.next; // Removing the node from middle or end
            }
            size--;
            return;
         }
         previous = current;
         current = current.next;
      }
   }

   // Method to check if a key exists in the hash table
   public boolean containsKey(int key) {
      int index = getBucketIndex(key);
      HashNode current = buckets[index];

      while (current != null) {
         if (current.key == key) {
            return true;
         }
         current = current.next;
      }
      return false;
   }

   // Method to print the hash table (for debugging purposes)
   public void printHashTable() {
      for (int i = 0; i < numOfBuckets; i++) {
         HashNode current = buckets[i];
         System.out.print("Bucket " + i + ": ");
         while (current != null) {
            System.out.print("[" + current.key + ": " + current.value + "] ");
            current = current.next;
         }
         System.out.println();
      }
   }

   // Inner class representing a node in the hash table
   class HashNode {
      int key;
      String value;
      HashNode next;

      public HashNode(int key, String value) {
         this.key = key;
         this.value = value;
         this.next = null;
      }
   }
}
