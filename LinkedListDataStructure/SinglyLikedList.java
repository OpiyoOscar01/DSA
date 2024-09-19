public class SinglyLikedList {
   private NodeList head;

   public static void main(String[] args) {
      SinglyLikedList ssl = new SinglyLikedList();
      ssl.head = new NodeList(10);
      NodeList second = new NodeList(1);
      NodeList third = new NodeList(8);
      NodeList fourth = new NodeList(11);
      ssl.head.next = second;
      second.next = third;
      third.next = fourth;

      System.out.println(second.data);
      System.out.println(ssl.head.data);
      System.out.println(third.data);

      //Inserting an element to linked List
      ssl.addElementToHead(9);
      ssl.addElementToHead(18);
      //inserting node element at the end of the list
      ssl.addElementToTail(19);
      //Looping through the elemnets of singly LinkedList
      ssl.displayNodeElements();
      System.out.println("The size of the list is: " + ssl.singlyLikedListSize());

      //deleting first element
      ssl.deleteFirstElement();
      ssl.displayNodeElements();
      System.out.println("The size of the list is: " + ssl.singlyLikedListSize());
      //Deleting last node element
      ssl.deleteLast();
      ssl.displayNodeElements();
      System.out.println("The size of the list is: " + ssl.singlyLikedListSize());
      ssl.insertAtPosition(-304, 3);
      ssl.displayNodeElements();
      System.out.println("The size of the list is: " + ssl.singlyLikedListSize());


   }

   //Display the node elements in a list
   public void displayNodeElements() {
      NodeList current = head;
      while (current != null) {
         System.out.print(current.data + "-->");
         current = current.next;
      }
      System.out.println("Null");
   }

   //Counting the number of nodes in a list.
   public int singlyLikedListSize() {
      NodeList current = head;
      int count = 0;
      while (current != null) {
         count++;
         current = current.next;
      }
      return count;
   }

   //Adding Element to List Head
   public void addElementToHead(int data) {
      NodeList newNode = new NodeList(data);
      if (head == null) {
         head = newNode;
      } else {
         newNode.next = head;
         head = newNode;
      }
   }

   // Method to add an element to the tail of the linked list
   public void addElementToTail(int data) {
      NodeList newNode = new NodeList(data); // Create a new node with the provided data

      if (head == null) {
         // If the list is empty, set the new node as the head
         head = newNode;
      } else {
         // Traverse the list to find the last node
         NodeList current = head;
         while (current.next != null) {
            current = current.next;
         }
         // Append the new node to the end of the list
         current.next = newNode;
      }
   }

   //Methode to delete the first node.
   public void deleteFirstElement() {
      if (head == null) {
         System.out.println("This list is empty");
      } else {
         head = head.next;
      }
   }

   // Method to delete the last node
   public void deleteLast() {
      if (head == null) {
         throw new IllegalStateException("Cannot delete from an empty list.");
      }

      if (head.next == null) {
         // Only one node in the list
         head = null;
      } else {
         // Traverse to the second last node
         NodeList current = head;
         while (current.next.next != null) {
            current = current.next;
         }
         // Remove the last node
         current.next = null;
      }
   }

   // Method to insert a node at a given position
   public void insertAtPosition(int data, int position) {
      NodeList newNode = new NodeList(data);

      if (position < 0) {
         throw new IllegalArgumentException("Position cannot be negative.");
      }

      if (position == 0) {
         // Insert at the beginning
         newNode.next = head;
         head = newNode;
      } else {
         // Traverse to the node just before the insertion point
         NodeList current = head;
         for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
         }

         if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds.");
         }

         // Insert the new node
         newNode.next = current.next;
         current.next = newNode;
      }
   }

   // Method to delete the first node
   public void deleteFirst() {
      if (head == null) {
         throw new IllegalStateException("Cannot delete from an empty list.");
      }
      head = head.next;
   }

   void med() {
      System.out.println("Hello");
   }

   private static class NodeList {
      private final int data;
      private NodeList next;

      public NodeList(int data) {
         this.data = data;
         this.next = null;
      }
   }

}