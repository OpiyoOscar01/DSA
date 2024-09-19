package DataStructure.Linear.Arrays.ArrayPractice;

import java.util.ArrayList;

public class bs {
   ArrayList<Integer> list = new ArrayList<>();

   public static void main(String[] args) {
      int[] arr = {3, 4, 5, 8, 9};
      int target = 9;
      int low = 0, high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (arr[mid] == target) {
            high = mid;
            System.out.println(mid);
            break;
         } else if (arr[mid] > target) {
            high = mid - 1;
         } else {
            low = mid + 1;
         }
      }
   }
}
