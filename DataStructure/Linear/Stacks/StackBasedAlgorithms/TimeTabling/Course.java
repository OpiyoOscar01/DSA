package DataStructure.Linear.Stacks.StackBasedAlgorithms.TimeTabling;

// File: Course.java
public class Course {
   private final String courseName;
   private final int startTime;
   private final int endTime;

   public Course(String courseName, int startTime, int endTime) {
      this.courseName = courseName;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public String getCourseName() {
      return courseName;
   }

   public int getStartTime() {
      return startTime;
   }

   public int getEndTime() {
      return endTime;
   }

   @Override
   public String toString() {
      return courseName + ": " + startTime + " - " + endTime;
   }
}

