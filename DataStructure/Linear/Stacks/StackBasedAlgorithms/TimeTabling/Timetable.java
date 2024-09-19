package DataStructure.Linear.Stacks.StackBasedAlgorithms.TimeTabling;

// File: Timetable.java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timetable {
   private final List<Course> courses;
   private final List<Lecturer> lecturers;
   private final List<Room> rooms;
   private final Map<String, List<String>> schedule; // Room -> List of scheduled courses

   public Timetable() {
      courses = new ArrayList<>();
      lecturers = new ArrayList<>();
      rooms = new ArrayList<>();
      schedule = new HashMap<>();
   }

   public void addCourse(Course course) {
      courses.add(course);
   }

   public void addLecturer(Lecturer lecturer) {
      lecturers.add(lecturer);
   }

   public void addRoom(Room room) {
      rooms.add(room);
      schedule.put(room.getRoomName(), new ArrayList<>());
   }

   public void allocate() {
      // Simple allocation algorithm (greedy)
      for (Course course : courses) {
         for (Room room : rooms) {
            if (isAvailable(room, course)) {
               schedule.get(room.getRoomName()).add(course.toString());
               break;
            }
         }
      }
   }

   private boolean isAvailable(Room room, Course course) {
      // Check room availability based on the course schedule
      // For simplicity, assume all rooms are always available in this example
      return true;
   }

   public void printTimetable() {
      for (Map.Entry<String, List<String>> entry : schedule.entrySet()) {
         System.out.println("Room " + entry.getKey() + ":");
         for (String course : entry.getValue()) {
            System.out.println("  " + course);
         }
      }
   }
}

