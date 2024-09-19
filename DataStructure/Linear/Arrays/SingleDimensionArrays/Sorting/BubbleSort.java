package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting;

public class BubbleSort {
   public static void bubbleSort(int[] arg) {
      boolean isSwapped;

      for (int i = 0; i < arg.length - 1; i++) {
         isSwapped = false;
         for (int j = 0; j < arg.length - i - 1; j++) {
            if (arg[j] > arg[j + 1]) {
               int temp = arg[j];
               arg[j] = arg[j + 1];
               arg[j + 1] = temp;
               isSwapped = true;
            }
         }

         if (!isSwapped) {
            break;
         }
      }
   }

   public static void main(String[] args) {
      int[] scores = {23, 47, 89, 67, 23};
      bubbleSort(scores);
      for (int i : scores) {
         System.out.println(i);
      }
   }

}

