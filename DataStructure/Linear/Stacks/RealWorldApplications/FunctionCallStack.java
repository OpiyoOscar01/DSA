package DataStructure.Linear.Stacks.RealWorldApplications;

public class FunctionCallStack {

   // Function A
   public static void functionA() {
      System.out.println("Entering function A");
      functionB(); // Call function B
      System.out.println("Exiting function A");
   }

   // Function B
   public static void functionB() {
      System.out.println("Entering function B");
      functionC(); // Call function C
      System.out.println("Exiting function B");
   }

   // Function C
   public static void functionC() {
      System.out.println("Entering function C");
      // No further calls, return to function B
      System.out.println("Exiting function C");
   }

   public static void main(String[] args) {
      System.out.println("Program started");
      functionA(); // Call function A
      System.out.println("Program finished");
   }
}

