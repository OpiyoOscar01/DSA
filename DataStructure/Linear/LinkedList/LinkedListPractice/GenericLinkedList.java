package DataStructure.Linear.LinkedList.LinkedListPractice;

public class GenericLinkedList {
   Node<Integer> head;

   void insert(int data) {
      Node<Integer> newNode = new Node<>(data);
      if (head == null) {
         head = newNode;
      } else {
         newNode.next = head;
         head = newNode;
      }
   }

   private static class Node<T> {
      T data;
      Node<T> next;

      public Node(T data) {
         this.data = data;
         this.next = null;
      }
   }

}
