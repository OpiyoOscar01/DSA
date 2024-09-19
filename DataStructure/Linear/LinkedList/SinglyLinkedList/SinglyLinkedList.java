package DataStructure.Linear.LinkedList.SinglyLinkedList;

public class SinglyLinkedList {
   private Node head;

   public static void main(String[] args) {
      SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
      singlyLinkedList.insertAtHead(29);
      singlyLinkedList.insertAtHead(12);
      singlyLinkedList.insertAtHead(26);
      singlyLinkedList.insertAtTail(10);
      singlyLinkedList.deleteLastNode();
      singlyLinkedList.insertAtSpecificPoint(100, 2);
      System.out.println(singlyLinkedList.searchValue(206)
      );
      singlyLinkedList.dispkayListNode();


   }

   public void insertAtHead(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
      } else {
         newNode.next = head;
         head = newNode;
      }
   }

   public void insertAtTail(int data) {
      Node newNode = new Node(data);
      if (head == null) {
         head = newNode;
      } else {
         Node current = head;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newNode;
      }
   }

   public void deleteLastNode() {
      if (head == null) {
         System.out.println("This list is empty");
      } else if (head.next == null) {
         head = null;
      } else {
         Node current = head;
         while (current.next.next != null) {
            current = current.next;
         }
         current.next = null;

      }

   }

   public void dispkayListNode() {
      Node current = head;
      while (current != null) {
         System.out.print(current.data + "->");
         current = current.next;
      }
      System.out.println("null");
   }

   public String searchValue(int target) {
      Node current = head;
      int count = 0;
      while (current != null) {
         if (current.data == target) {
            return current.data + " found at position " + count;
         }
         count++;
         current = current.next;
      }
      return target + " not found in the LinkedList";
   }

   public void insertAtSpecificPoint(int data, int position) {
      Node newData = new Node(data);
      if (position < 0) {
         System.out.println("Position can neve be less than zero");
      } else if (position == 0) {//insert at the head
         newData.next = head;
         newData = head;
      } else {
         Node current = head;
         for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
         }
         newData.next = current.next;
         current.next = newData;
      }
   }
}
