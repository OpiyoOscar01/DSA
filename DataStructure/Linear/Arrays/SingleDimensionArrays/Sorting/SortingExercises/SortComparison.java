package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting.SortingExercises;

import java.util.Arrays;

public class SortComparison {

   // Bubble Sort implementation
   public static void bubbleSort(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }
   }

   // Insertion Sort implementation
   public static void insertionSort(int[] arr) {
      int n = arr.length;
      for (int i = 1; i < n; i++) {
         int key = arr[i];
         int j = i - 1;

         while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
         }
         arr[j + 1] = key;
      }
   }

   // Merge Sort implementation
   public static void mergeSort(int[] arr, int left, int right) {
      if (left < right) {
         int mid = (left + right) / 2;
         mergeSort(arr, left, mid);
         mergeSort(arr, mid + 1, right);
         merge(arr, left, mid, right);
      }
   }

   // Merge two halves for Merge Sort
   public static void merge(int[] arr, int left, int mid, int right) {
      int n1 = mid - left + 1;
      int n2 = right - mid;

      int[] L = new int[n1];
      int[] R = new int[n2];

      System.arraycopy(arr, left + 0, L, 0, n1);
      for (int j = 0; j < n2; j++)
         R[j] = arr[mid + 1 + j];

      int i = 0, j = 0, k = left;

      while (i < n1 && j < n2) {
         if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
         } else {
            arr[k] = R[j];
            j++;
         }
         k++;
      }

      while (i < n1) {
         arr[k] = L[i];
         i++;
         k++;
      }

      while (j < n2) {
         arr[k] = R[j];
         j++;
         k++;
      }
   }

   public static void main(String[] args) {
      // Create a large array of integers
      int[] arr = new int[10000];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = (int) (Math.random() * 10000);
      }

      // Measure time for Bubble Sort
      int[] bubbleArr = Arrays.copyOf(arr, arr.length);
      long startTime = System.currentTimeMillis();
      bubbleSort(bubbleArr);
      long endTime = System.currentTimeMillis();
      System.out.println("Bubble Sort time: " + (endTime - startTime) + "ms");

      // Measure time for Insertion Sort
      int[] insertionArr = Arrays.copyOf(arr, arr.length);
      startTime = System.currentTimeMillis();
      insertionSort(insertionArr);
      endTime = System.currentTimeMillis();
      System.out.println("Insertion Sort time: " + (endTime - startTime) + "ms");

      // Measure time for Merge Sort
      int[] mergeArr = Arrays.copyOf(arr, arr.length);
      startTime = System.currentTimeMillis();
      mergeSort(mergeArr, 0, mergeArr.length - 1);
      endTime = System.currentTimeMillis();
      System.out.println("Merge Sort time: " + (endTime - startTime) + "ms");
   }
}

