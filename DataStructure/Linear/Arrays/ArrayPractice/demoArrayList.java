package DataStructure.Linear.Arrays.ArrayPractice;

import java.util.ArrayList;
import java.util.List;

public class demoArrayList {
   public static void main(String[] args) {
      demoArrayList list = new demoArrayList();
      ArrayList<Integer> intList = new ArrayList<>();
      intList.add(1);
      intList.add(2);
      intList.add(3);
      list.printArrayList(intList);
      ArrayList<String> intList2 = new ArrayList<>();
      intList2.add("1");
      intList2.add("2");
      intList2.add("3");
      list.printArrayList(intList2);


   }

   <T> void printArrayList(List<T> list) {
      for (T t : list) {
         System.out.println(t);
      }
   }
}
