package DataStructure.Linear.Arrays.SingleDimensionArrays;

public class StringBuilderExample {
   public static void main(String[] args) {
      StringBuilder sb = new StringBuilder("Welcome to ");

      // Append
      sb.append("Java Programming!");
      System.out.println("After append: " + sb);

      // Insert
      sb.insert(11, "the world of ");
      System.out.println("After insert: " + sb);

      // Replace
      sb.replace(11, 23, "awesome");
      System.out.println("After replace: " + sb);

      // Delete
      sb.delete(11, 19);
      System.out.println("After delete: " + sb);

      // Reverse
      sb.reverse();
      System.out.println("After reverse: " + sb);
   }
}

