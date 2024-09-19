package DataStructure.Linear.LinkedList.AdvancedLinkedList.Challenge;

class SkipListNode {
   int value;
   SkipListNode[] forward;

   // Constructor for initializing a node
   public SkipListNode(int value, int level) {
      this.value = value;
      forward = new SkipListNode[level + 1]; // Array of forward pointers for each level
   }
}
