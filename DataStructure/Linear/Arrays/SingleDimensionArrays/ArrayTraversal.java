package DataStructure.Linear.Arrays.SingleDimensionArrays;

public class ArrayTraversal {
   public static void main(String[] args) {
      double[] marks = {90.5, 80.5, 70.5, 65.0};
      ArrayTraversal arrayTraversal = new ArrayTraversal();

      System.out.println(arrayTraversal.maxMark(marks));
      System.out.println(arrayTraversal.minMark(marks));
      System.out.println(arrayTraversal.sumOfMarks(marks));
      arrayTraversal.displayMarks(marks);

   }

   // Sum of marks
   public String sumOfMarks(double[] arr) {
      double sum = 0;
      for (int i = 0; i < arr.length; i++) {
         sum += arr[i];
      }
      return "The sum is: " + sum;
   }

   // Maximum mark
   public String maxMark(double[] arr) {
      double max = arr[0];
      for (int i = 1; i < arr.length; i++) { // Start loop from index 1 since max is initialized with arr[0]
         if (arr[i] > max) {
            max = arr[i];
         }
      }
      return "The maximum value is " + max;
   }

   // Minimum mark
   public String minMark(double[] arr) {
      double min = arr[0];
      for (int i = 1; i < arr.length; i++) { // Start loop from index 1 since min is initialized with arr[0]
         if (arr[i] < min) {
            min = arr[i];
         }
      }
      return "The minimum value is " + min;
   }

   // Format string
   public String formatMark(double mark) {
      return String.format("%.2f", mark);
   }

   // Display and format marks
   public void displayMarks(double[] marks) {
      for (int i = 0; i < marks.length; i++) {
         System.out.println(formatMark(marks[i]));
      }
      System.out.println(); // To move to the next line after printing all marks
   }

   // Insert an element into the array at the specified index
   public String insertElement(double mark, double[] marks, int index) {
      try {
         if (index < 0 || index >= marks.length) {
            throw new IllegalArgumentException("Index out of bounds for the array.");
         }

         marks[index] = mark;
         return "Mark has been successfully inserted";
      } catch (IllegalArgumentException e) {
         return "Error: " + e.getMessage();
      }
   }

   public void removeElement(int index, double[] marks) {
      try {
         if (index < 0 || index >= marks.length) {
            throw new IllegalArgumentException("Index out of bounds for the array.");
         }
         for (int i = index; i < marks.length; i++) {
            marks[i] = marks[i + 1];
         }
         displayMarks(marks);
      } catch (IllegalArgumentException e) {
         System.out.println("Error: " + e.getMessage());
      }

   }
}
