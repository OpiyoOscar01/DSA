package DataStructure.Linear.Stacks.RealWorldApplications;

import java.util.Stack;

public class BrowserHistory {

   // Stack for back navigation
   private final Stack<String> backStack;
   // Stack for forward navigation
   private final Stack<String> forwardStack;
   private String currentPage;

   // Constructor
   public BrowserHistory() {
      backStack = new Stack<>();
      forwardStack = new Stack<>();
      currentPage = null;
   }

   public static void main(String[] args) {
      BrowserHistory browser = new BrowserHistory();

      browser.visit("Page1");
      browser.visit("Page2");
      browser.visit("Page3");

      System.out.println("Current page: " + browser.getCurrentPage());

      browser.back();
      browser.back();
      browser.forward();
      browser.forward();
      browser.back();
      browser.back(); // Trying to go back when there's no page

      System.out.println("Current page: " + browser.getCurrentPage());
   }

   // Visit a new page
   public void visit(String url) {
      if (currentPage != null) {
         backStack.push(currentPage);
         // Clear forward stack because visiting a new page makes future forward navigation irrelevant
         forwardStack.clear();
      }
      currentPage = url;
      System.out.println("Visited: " + currentPage);
   }

   // Go back to the previous page
   public void back() {
      if (!backStack.isEmpty()) {
         forwardStack.push(currentPage); // Save current page to forward stack
         currentPage = backStack.pop(); // Go back to the previous page
         System.out.println("Back to: " + currentPage);
      } else {
         System.out.println("No previous page.");
      }
   }

   // Go forward to the next page
   public void forward() {
      if (!forwardStack.isEmpty()) {
         backStack.push(currentPage); // Save current page to back stack
         currentPage = forwardStack.pop(); // Go forward to the next page
         System.out.println("Forward to: " + currentPage);
      } else {
         System.out.println("No forward page.");
      }
   }

   // Get current page
   public String getCurrentPage() {
      return currentPage;
   }
}

