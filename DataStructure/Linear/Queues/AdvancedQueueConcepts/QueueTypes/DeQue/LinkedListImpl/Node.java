package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.DeQue.LinkedListImpl;

class Node {
   int data;
   Node next, prev;

   // Constructor
   public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
   }
}
