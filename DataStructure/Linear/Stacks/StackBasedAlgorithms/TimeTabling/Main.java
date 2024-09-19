package DataStructure.Linear.Stacks.StackBasedAlgorithms.TimeTabling;

// File: Main.java

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Timetable timetable = new Timetable();

      // Input for Rooms
      System.out.println("Enter number of rooms:");
      int numRooms = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      for (int i = 0; i < numRooms; i++) {
         System.out.println("Enter room name:");
         String roomName = scanner.nextLine();
         timetable.addRoom(new Room(roomName));
      }

      // Input for Lecturers
      System.out.println("Enter number of lecturers:");
      int numLecturers = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      for (int i = 0; i < numLecturers; i++) {
         System.out.println("Enter lecturer name:");
         String lecturerName = scanner.nextLine();
         timetable.addLecturer(new Lecturer(lecturerName));
      }

      // Input for Courses
      System.out.println("Enter number of courses:");
      int numCourses = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      for (int i = 0; i < numCourses; i++) {
         System.out.println("Enter course name:");
         String courseName = scanner.nextLine();
         System.out.println("Enter course start time (24-hour format):");
         int startTime = scanner.nextInt();
         System.out.println("Enter course end time (24-hour format):");
         int endTime = scanner.nextInt();
         scanner.nextLine(); // Consume newline
         timetable.addCourse(new Course(courseName, startTime, endTime));
      }

      // Allocate courses to rooms
      timetable.allocate();

      // Print the timetable
      timetable.printTimetable();

      scanner.close();
   }
}

