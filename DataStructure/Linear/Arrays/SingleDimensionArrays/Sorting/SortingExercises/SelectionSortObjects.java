package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting.SortingExercises;

public class SelectionSortObjects {

   // Selection Sort method to sort students by grades
   public static void selectionSort(Student[] students) {
      int n = students.length;

      for (int i = 0; i < n - 1; i++) {
         int minIndex = i;

         // Find the student with the lowest grade
         for (int j = i + 1; j < n; j++) {
            if (students[j].grade < students[minIndex].grade) {
               minIndex = j;
            }
         }

         // Swap the found student with the first unsorted student
         Student temp = students[minIndex];
         students[minIndex] = students[i];
         students[i] = temp;
      }
   }

   public static void main(String[] args) {
      // Sample array of students
      Student[] students = {
              new Student("Alice", 85),
              new Student("Bob", 90),
              new Student("Charlie", 80),
              new Student("David", 95)
      };

      // Perform selection sort
      selectionSort(students);

      // Display the sorted students
      for (Student student : students) {
         System.out.println(student.name + " - " + student.grade);
      }
   }
}
