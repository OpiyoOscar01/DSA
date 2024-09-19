package DataStructure.Linear.LinkedList.PracticalApplications;

class BrowserHistory {
   private Node current;  // The current page in the history

   public static void main(String[] args) {
      BrowserHistory browserHistory = new BrowserHistory();

      browserHistory.visit("https://example.com");
      browserHistory.visit("https://google.com");
      browserHistory.visit("https://youtube.com");

      browserHistory.currentPage();  // Should show youtube.com

      browserHistory.back();  // Go back to google.com
      browserHistory.currentPage();

      browserHistory.forward();  // Go forward to youtube.com
      browserHistory.currentPage();

      browserHistory.back();  // Go back to google.com
      browserHistory.back();  // Go back to example.com
      browserHistory.currentPage();
   }

   // Visit a new webpage, add it to the history
   public void visit(String url) {
      Node newNode = new Node(url);
      if (current != null) {
         current.next = newNode;
         newNode.prev = current;
      }
      current = newNode;  // Move to the new page
      System.out.println("Visited: " + url);
   }

   // Go back to the previous webpage
   public void back() {
      if (current != null && current.prev != null) {
         current = current.prev;
         System.out.println("Back to: " + current.url);
      } else {
         System.out.println("No previous page.");
      }
   }

   // Go forward to the next webpage
   public void forward() {
      if (current != null && current.next != null) {
         current = current.next;
         System.out.println("Forward to: " + current.url);
      } else {
         System.out.println("No forward page.");
      }
   }

   // Display the current webpage
   public void currentPage() {
      if (current != null) {
         System.out.println("Current page: " + current.url);
      } else {
         System.out.println("No pages in history.");
      }
   }

   class Node {
      String url;
      Node prev, next;

      public Node(String url) {
         this.url = url;
      }
   }
}

