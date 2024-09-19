package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists;


import java.util.LinkedList;

public class HashTable<K, V> {

   private final int capacity; // Number of slots in the hash table
   private final LinkedList<Entry<K, V>>[] table;
   // Constructor to initialize the hash table
   public HashTable(int capacity) {
      this.capacity = capacity;
      // Create an array of linked lists
      table = new LinkedList[capacity];
      for (int i = 0; i < capacity; i++) {
         table[i] = new LinkedList<>();
      }
   }

   public static void main(String[] args) {
      HashTable<String, Integer> hashTable = new HashTable<>(10);

      // Insert some key-value pairs
      hashTable.put("Alice", 30);
      hashTable.put("Bob", 25);
      hashTable.put("Charlie", 35);

      // Retrieve values
      System.out.println("Alice's age: " + hashTable.get("Alice"));
      System.out.println("Bob's age: " + hashTable.get("Bob"));

      // Display the hash table
      System.out.println("Hash Table:");
      hashTable.displayTable();

      // Remove an entry
      hashTable.remove("Bob");

      // Display the hash table after removal
      System.out.println("Hash Table after removing Bob:");
      hashTable.displayTable();
   }

   // Method to hash the key to an index
   private int hash(K key) {
      return Math.abs(key.hashCode()) % capacity;
   }

   // Method to insert or update an entry
   public void put(K key, V value) {
      int index = hash(key);
      LinkedList<Entry<K, V>> bucket = table[index];

      // Check if key already exists, if so, update the value
      for (Entry<K, V> entry : bucket) {
         if (entry.key.equals(key)) {
            entry.value = value;
            return;
         }
      }

      // If key does not exist, add a new entry
      bucket.add(new Entry<>(key, value));
   }

   // Method to retrieve a value by key
   public V get(K key) {
      int index = hash(key);
      LinkedList<Entry<K, V>> bucket = table[index];

      // Search for the key in the linked list
      for (Entry<K, V> entry : bucket) {
         if (entry.key.equals(key)) {
            return entry.value;
         }
      }

      // Return null if key is not found
      return null;
   }

   // Method to remove an entry by key
   public void remove(K key) {
      int index = hash(key);
      LinkedList<Entry<K, V>> bucket = table[index];

      // Iterate over the linked list to find and remove the entry
      for (Entry<K, V> entry : bucket) {
         if (entry.key.equals(key)) {
            bucket.remove(entry);
            return;
         }
      }
   }

   // Method to display the hash table
   public void displayTable() {
      for (int i = 0; i < capacity; i++) {
         System.out.print("Bucket " + i + ": ");
         for (Entry<K, V> entry : table[i]) {
            System.out.print("[" + entry.key + "=" + entry.value + "] ");
         }
         System.out.println();
      }
   }

   // Node class representing each entry in the hash table
   static class Entry<K, V> {
      K key;
      V value;

      // Constructor to create a new entry
      Entry(K key, V value) {
         this.key = key;
         this.value = value;
      }
   }
}

