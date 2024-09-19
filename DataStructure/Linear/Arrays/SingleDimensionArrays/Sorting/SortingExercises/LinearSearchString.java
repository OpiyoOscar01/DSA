package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting.SortingExercises;

public class LinearSearchString {

   // Linear search method to find a target word in an array
   public static int linearSearch(String[] arr, String target) {
      // Traverse through the array
      for (int i = 0; i < arr.length; i++) {
         if (arr[i].equals(target)) {
            return i;  // Return the index of the target word if found
         }
      }
      return -1;  // Return -1 if the target word is not found
   }

   public static void main(String[] args) {
      // Sample array of strings
      String[] words = {"apple", "banana", "cherry", "date", "elderberry"};

      // Target word to search for
      String target = "cherry";

      // Perform the linear search
      int result = linearSearch(words, target);

      // Display the result
      if (result != -1) {
         System.out.println("Word found at index: " + result);
      } else {
         System.out.println("Word not found.");
      }
   }
}

