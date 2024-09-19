package DataStructure.Linear.Arrays.ArrayPractice;

public class ls {
   public static void main(String[] args) {
      int target = 2;
      int[] marks = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      for (int i = 0; i < marks.length; i++) {
         if (i == target) {
            System.out.println(i);
            break;
         }
      }
   }
}
