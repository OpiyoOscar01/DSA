package DataStructure.Linear.LinkedList.AdvancedLinkedList;


public class MergeSortedLinkedLists {

   // Method to merge two sorted linked lists
   public static Node mergeSortedLists(Node l1, Node l2) {
      // If one of the lists is empty, return the other list
      if (l1 == null) return l2;
      if (l2 == null) return l1;

      // Create a dummy node to act as the start of the merged list
      Node dummy = new Node(0); // Dummy node doesn't hold meaningful data
      Node tail = dummy; // Tail will track the end of the merged list

      // Traverse both lists, choosing the smaller element each time
      while (l1 != null && l2 != null) {
         if (l1.data <= l2.data) {
            tail.next = l1; // Add l1 to the merged list
            l1 = l1.next;   // Move to the next node in l1
         } else {
            tail.next = l2; // Add l2 to the merged list
            l2 = l2.next;   // Move to the next node in l2
         }
         tail = tail.next;   // Move tail to the new end of the merged list
      }

      // If there are remaining elements in either list, append them
      if (l1 != null) {
         tail.next = l1;
      } else if (l2 != null) {
         tail.next = l2;
      }

      // Return the merged list, which starts after the dummy node
      return dummy.next;
   }

   // Method to display the linked list
   public static void displayList(Node head) {
      Node current = head;
      while (current != null) {
         System.out.print(current.data + " -> ");
         current = current.next;
      }
      System.out.println("null");
   }

   public static void main(String[] args) {
      // Create first sorted linked list: 1 -> 3 -> 5 -> null
      Node l1 = new Node(1);
      l1.next = new Node(3);
      l1.next.next = new Node(5);

      // Create second sorted linked list: 2 -> 4 -> 6 -> null
      Node l2 = new Node(2);
      l2.next = new Node(4);
      l2.next.next = new Node(6);

      // Display original lists
      System.out.println("List 1:");
      displayList(l1);
      System.out.println("List 2:");
      displayList(l2);

      // Merge the sorted linked lists
      Node mergedList = mergeSortedLists(l1, l2);
      System.out.println("Merged List:");
      displayList(mergedList);
   }

   // Node class representing each element in the linked list
   static class Node {
      int data;
      Node next;

      // Constructor to create a new node
      Node(int data) {
         this.data = data;
         this.next = null;
      }
   }
}

