package DataStructure.Linear.Queues.AdvancedQueueConcepts.QueueTypes.Priority.LinkedListImp;

class Node {
   int data;
   int priority;
   Node next;

   // Constructor to create a new node
   public Node(int data, int priority) {
      this.data = data;
      this.priority = priority;
      this.next = null;
   }
}
