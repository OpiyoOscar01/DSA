package DataStructure.Linear.Arrays.SingleDimensionArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ArrayListClass {

   ArrayList<Integer> marks = new ArrayList<>();

   boolean isEmpty = marks.isEmpty();

   //iterating over list elements
   public static void main(String[] args) {
      ArrayListClass list = new ArrayListClass();
      list.addElement(1);
      list.addElement(2);
      list.addElement(5);
      list.addElement(10);
      list.addElement(4);
      System.out.println(list.printArrayElements());
      list.removeElementAt(list.size() - 1);
      System.out.println(list.printArrayElements());
      list.updateElementAt(1, 89);
      System.out.println(list.printArrayElements());
      System.out.println(list.findElementByValue(999));

      ArrayList<Integer> list1 = new ArrayList<>();
      list1.add(1);
      list1.add(2);
      list1.add(5);
      list1.add(10);
      list1.add(4);
      //iterating over list elements.
      list1.forEach(item -> System.out.print(item + " "));
      //converting arraylist to array
      Integer[] myarray = new Integer[list1.size()];//use wrapper classes.
      myarray = list1.toArray(myarray);
      for (Integer i : myarray) {
         System.out.print(i + " ");
      }
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(myarray));
      for (Integer i : list2) {
         System.out.print(i + " ");
      }

      //custom sorting of lists
      ArrayList<String> names = new ArrayList<>();
      names.add("Oscar");
      names.add("Steve");
      names.add("Mike");
      names.add("Kevin");
      names.sort(Comparator.comparing(String::length));
      names.sort(Comparator.comparing(String::toUpperCase));
      for (String name : names) {
         System.out.println(name);
      }

      ArrayList<Integer> points = new ArrayList<>();
      points.add(3);
      points.add(5);
      points.add(17);
      points.add(31);
      points.add(15);
      points.add(17);

      ArrayList<Integer> filteredList = (ArrayList<Integer>) points.stream().filter(x -> x > 10).collect(Collectors.toList());

      filteredList.forEach(listItem -> System.out.println(listItem));


   }

   public void addElement(int mark) {
      marks.add(mark);
   }

   public int getElementAt(int index) {
      return marks.get(index);
   }

   public void removeElementAt(int index) {
      if (isEmpty) {
         System.out.println("The list is empty.");
      }
      marks.remove(index);
   }

   public void updateElementAt(int index, int newMark) {
      marks.set(index, newMark);
   }

   public int size() {
      return marks.size();
   }

   public String printArrayElements() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < size(); i++) {
         sb.append(getElementAt(i) + " ");
      }
      return sb.toString();
   }

   //check if list contains and element
   public String findElementByValue(int value) {
      boolean isPresent = marks.contains(value);
      if (isPresent) {
         return "The value's index is:" + marks.indexOf(value);

      }
      return "Value does not exist in the aray";
   }

   public void sortListElementsAscending() {
      Collections.sort(marks);
   }

   public void sortListElemntsDescending() {
      Collections.sort(marks, Collections.reverseOrder());
   }
}
