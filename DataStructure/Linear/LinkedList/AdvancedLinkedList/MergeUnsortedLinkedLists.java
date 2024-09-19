package DataStructure.Linear.LinkedList.AdvancedLinkedList;


import java.util.PriorityQueue;

public class MergeUnsortedLinkedLists {

   // Method to merge multiple unsorted linked lists and sort the result
   public static Node mergeUnsortedLists(Node... lists) {
      // If no lists are provided, return null
      if (lists.length == 0) return null;

      // Priority queue to automatically sort the elements by their value
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();

      // Traverse through each linked list and add each node's value to the priority queue
      for (Node list : lists) {
         Node current = list;
         while (current != null) {
            minHeap.add(current.data); // Add data to min-heap (automatically sorted)
            current = current.next;
         }
      }

      // Create a dummy node for the result
      Node dummy = new Node(0);
      Node tail = dummy;

      // Remove the elements from the heap (in sorted order) and create the merged sorted list
      while (!minHeap.isEmpty()) {
         tail.next = new Node(minHeap.poll()); // Remove smallest element and add to list
         tail = tail.next;
      }

      return dummy.next; // Return the merged and sorted list
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
      // Create first unsorted linked list: 5 -> 1 -> 3 -> null
      Node l1 = new Node(5);
      l1.next = new Node(1);
      l1.next.next = new Node(3);

      // Create second unsorted linked list: 6 -> 2 -> 4 -> null
      Node l2 = new Node(6);
      l2.next = new Node(2);
      l2.next.next = new Node(4);

      // Create third unsorted linked list: 8 -> 7 -> 9 -> null
      Node l3 = new Node(8);
      l3.next = new Node(7);
      l3.next.next = new Node(9);

      // Display original unsorted lists
      System.out.println("List 1:");
      displayList(l1);
      System.out.println("List 2:");
      displayList(l2);
      System.out.println("List 3:");
      displayList(l3);

      // Merge and sort all unsorted linked lists
      Node mergedList = mergeUnsortedLists(l1, l2, l3);
      System.out.println("Merged and Sorted List:");
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

