package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists.FileSystem;

import java.util.ArrayList;
import java.util.List;

class FileSystemNode {
   String name;
   boolean isDirectory;
   List<FileSystemNode> children;

   // Constructor
   public FileSystemNode(String name, boolean isDirectory) {
      this.name = name;
      this.isDirectory = isDirectory;
      this.children = new ArrayList<>();
   }
}
