package DataStructure.Linear.Arrays.SingleDimensionArrays;

public class ArrayOperation {
   public static void main(String[] args) {
      double[] scores = new double[10];
      scores[0] = 10;
      scores[1] = 45;
      scores[2] = 18;
      for (int i = 3; i < scores.length; i++) {
         System.out.println("Score " + scores[i]);
      }
   }
}
