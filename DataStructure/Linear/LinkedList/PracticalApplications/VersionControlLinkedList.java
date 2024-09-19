package DataStructure.Linear.LinkedList.PracticalApplications;

class VersionControlLinkedList {
   private Node head;

   public static void main(String[] args) {
      VersionControlLinkedList versionControl = new VersionControlLinkedList();

      versionControl.commit("Version 1.0");
      versionControl.commit("Version 1.1");
      versionControl.commit("Version 2.0");

      versionControl.displayCurrentVersion(); // Current: Version 2.0

      versionControl.checkout(); // Go back to Version 1.1
      versionControl.checkout(); // Go back to Version 1.0
      versionControl.displayCurrentVersion(); // Current: Version 1.0
   }

   // Add a new version to the version control system
   public void commit(String versionName) {
      Node newNode = new Node(versionName);
      newNode.next = head;
      head = newNode;
      System.out.println("Committed: " + versionName);
   }

   // Check out a previous version
   public void checkout() {
      if (head != null) {
         System.out.println("Checked out version: " + head.version);
         head = head.next;
      } else {
         System.out.println("No previous versions available.");
      }
   }

   // Display the current version
   public void displayCurrentVersion() {
      if (head != null) {
         System.out.println("Current Version: " + head.version);
      } else {
         System.out.println("No current version.");
      }
   }

   class Node {
      String version;
      Node next;

      public Node(String version) {
         this.version = version;
      }
   }
}

