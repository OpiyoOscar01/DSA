package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists.FileSystem;

public class FileSystem {
   private final FileSystemNode root;

   // Constructor
   public FileSystem() {
      root = new FileSystemNode("/", true); // Root directory
   }

   // Main method for testing
   public static void main(String[] args) {
      FileSystem fs = new FileSystem();
      fs.create("/home/user/docs", true); // Create directory
      fs.create("/home/user/docs/file1.txt", false); // Create file
      fs.create("/home/user/music", true); // Create another directory

      System.out.println("Listing contents of /home/user:");
      fs.list("/home/user");

      System.out.println("Deleting /home/user/docs/file1.txt");
      fs.delete("/home/user/docs/file1.txt");

      System.out.println("Listing contents of /home/user:");
      fs.list("/home/user");
   }

   // Method to create a file or directory
   public void create(String path, boolean isDirectory) {
      String[] parts = path.split("/");
      FileSystemNode current = root;

      for (int i = 1; i < parts.length; i++) {
         String part = parts[i];
         FileSystemNode node = findNode(current, part);

         if (node == null) {
            node = new FileSystemNode(part, i < parts.length - 1);
            current.children.add(node);
         }
         current = node;
      }

      if (isDirectory && !current.isDirectory) {
         System.out.println("Cannot create directory. A file with the same name exists.");
      } else if (!isDirectory && current.isDirectory) {
         System.out.println("Cannot create file. A directory with the same name exists.");
      } else if (current.isDirectory) {
         current.children.add(new FileSystemNode(parts[parts.length - 1], isDirectory));
      }
   }

   // Method to delete a file or directory
   public void delete(String path) {
      String[] parts = path.split("/");
      FileSystemNode current = root;

      for (int i = 1; i < parts.length - 1; i++) {
         String part = parts[i];
         FileSystemNode node = findNode(current, part);

         if (node == null) {
            System.out.println("Path not found.");
            return;
         }
         current = node;
      }

      String name = parts[parts.length - 1];
      FileSystemNode nodeToDelete = findNode(current, name);

      if (nodeToDelete != null) {
         current.children.remove(nodeToDelete);
      } else {
         System.out.println("File or directory not found.");
      }
   }

   // Method to list all files and directories
   public void list(String path) {
      FileSystemNode current = root;

      String[] parts = path.split("/");
      for (int i = 1; i < parts.length; i++) {
         String part = parts[i];
         FileSystemNode node = findNode(current, part);

         if (node == null || !node.isDirectory) {
            System.out.println("Path not found.");
            return;
         }
         current = node;
      }

      printDirectory(current, "");
   }

   // Helper method to find a node in a directory
   private FileSystemNode findNode(FileSystemNode current, String name) {
      for (FileSystemNode child : current.children) {
         if (child.name.equals(name)) {
            return child;
         }
      }
      return null;
   }

   // Helper method to print directory contents
   private void printDirectory(FileSystemNode node, String indent) {
      if (node.isDirectory) {
         System.out.println(indent + "[DIR] " + node.name);
         for (FileSystemNode child : node.children) {
            printDirectory(child, indent + "  ");
         }
      } else {
         System.out.println(indent + "[FILE] " + node.name);
      }
   }
}
