package DataStructure.Linear.Arrays.SingleDimensionArrays;

public class LinearSearch {
   public static String singleDimensionSearch(double[] marks, double target) {
      if (marks.length == 0) {
         return "No single dimension found";
      }
      for (int i = 0; i < marks.length; i++) {
         if (marks[i] == target) {
            return target + " found at index " + i;
         }
      }
      return "Search completed!";
   }

   public static void main(String[] args) {
      double[] marks = {78.1, 34, 89.6};
      String searchResult = singleDimensionSearch(marks, 89.6);
      System.out.println(searchResult);

   }
}
