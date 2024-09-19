package DataStructure.NonLinear.Trie;

public class Trie {
   private final TrieNode root;

   // Constructor
   public Trie() {
      root = new TrieNode();
   }

   // Main method for testing
   public static void main(String[] args) {
      Trie trie = new Trie();

      trie.insert("apple");
      trie.insert("app");
      trie.insert("apricot");

      System.out.println(trie.search("apple"));   // Output: true
      System.out.println(trie.search("app"));     // Output: true
      System.out.println(trie.startsWith("apr")); // Output: true
      System.out.println(trie.startsWith("apx")); // Output: false

      trie.delete("apple");
      System.out.println(trie.search("apple"));   // Output: false
      System.out.println(trie.search("app"));     // Output: true
   }

   // Insert a word into the Trie
   public void insert(String word) {
      TrieNode currentNode = root;
      for (int i = 0; i < word.length(); i++) {
         char c = word.charAt(i);
         int index = c - 'a'; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25

         if (currentNode.children[index] == null) {
            currentNode.children[index] = new TrieNode(); // Create a new node if it doesn't exist
         }
         currentNode = currentNode.children[index];
      }
      currentNode.isEnd = true; // Mark the end of the word
   }

   // Search for a word in the Trie
   public boolean search(String word) {
      TrieNode currentNode = root;
      for (int i = 0; i < word.length(); i++) {
         char c = word.charAt(i);
         int index = c - 'a';

         if (currentNode.children[index] == null) {
            return false; // If a character doesn't exist, the word is not present
         }
         currentNode = currentNode.children[index];
      }
      return currentNode.isEnd; // Return true only if the node is the end of a word
   }

   // Check if any word in the Trie starts with the given prefix
   public boolean startsWith(String prefix) {
      TrieNode currentNode = root;
      for (int i = 0; i < prefix.length(); i++) {
         char c = prefix.charAt(i);
         int index = c - 'a';

         if (currentNode.children[index] == null) {
            return false; // If the prefix doesn't exist, return false
         }
         currentNode = currentNode.children[index];
      }
      return true; // If all characters of the prefix exist, return true
   }

   // Delete a word from the Trie
   public boolean delete(String word) {
      return deleteHelper(root, word, 0);
   }

   // Recursive function to delete a word from the Trie
   private boolean deleteHelper(TrieNode currentNode, String word, int index) {
      if (index == word.length()) {
         // Base case: when we've reached the end of the word
         if (!currentNode.isEnd) {
            return false; // Word not found
         }
         currentNode.isEnd = false; // Unmark the end of the word

         // If the current node has no other children, it can be deleted
         return noChildren(currentNode);
      }

      char c = word.charAt(index);
      int charIndex = c - 'a';
      TrieNode childNode = currentNode.children[charIndex];

      if (childNode == null) {
         return false; // Word not found
      }

      // Recursively delete the child node
      boolean shouldDeleteChild = deleteHelper(childNode, word, index + 1);

      if (shouldDeleteChild) {
         currentNode.children[charIndex] = null; // Remove the reference to the child node

         // Return true if the current node has no other children and is not the end of another word
         return !currentNode.isEnd && noChildren(currentNode);
      }

      return false;
   }

   // Helper method to check if a node has no children
   private boolean noChildren(TrieNode currentNode) {
      for (TrieNode child : currentNode.children) {
         if (child != null) {
            return false;
         }
      }
      return true;
   }

   // TrieNode class representing each node of the Trie
   class TrieNode {
      TrieNode[] children;
      boolean isEnd;

      public TrieNode() {
         this.children = new TrieNode[26]; // Each node has 26 children (one for each letter)
         this.isEnd = false;
      }
   }
}
