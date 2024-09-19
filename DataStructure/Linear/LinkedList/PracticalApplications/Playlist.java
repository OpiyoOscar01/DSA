package DataStructure.Linear.LinkedList.PracticalApplications;

class Playlist {
   private Node current; // Current song in the playlist

   public static void main(String[] args) {
      Playlist playlist = new Playlist();
      playlist.addSong("Song 1");
      playlist.addSong("Song 2");
      playlist.addSong("Song 3");

      playlist.play();  // Play the first song

      playlist.next();  // Move to and play the next song
      playlist.previous();  // Move to and play the previous song

      playlist.removeCurrentSong();  // Remove the current song
      playlist.play();  // Play the next song
   }

   // Add a new song to the playlist
   public void addSong(String songTitle) {
      Node newNode = new Node(songTitle);
      if (current == null) {
         current = newNode;  // Set as the current song if the playlist is empty
      } else {
         Node last = current;
         while (last.next != null) {
            last = last.next;
         }
         last.next = newNode;
         newNode.prev = last;
      }
      System.out.println("Added song: " + songTitle);
   }

   // Play the current song
   public void play() {
      if (current != null) {
         System.out.println("Playing: " + current.songTitle);
      } else {
         System.out.println("No song in the playlist.");
      }
   }

   // Move to the next song
   public void next() {
      if (current != null && current.next != null) {
         current = current.next;
         play();  // Play the next song
      } else {
         System.out.println("No next song.");
      }
   }

   // Move to the previous song
   public void previous() {
      if (current != null && current.prev != null) {
         current = current.prev;
         play();  // Play the previous song
      } else {
         System.out.println("No previous song.");
      }
   }

   // Remove the current song from the playlist
   public void removeCurrentSong() {
      if (current == null) {
         System.out.println("No song to remove.");
         return;
      }

      System.out.println("Removing: " + current.songTitle);

      if (current.prev != null) {
         current.prev.next = current.next;  // Bypass current node
      }
      if (current.next != null) {
         current.next.prev = current.prev;
         current = current.next;  // Move to the next song
      } else {
         current = current.prev;  // Move to the previous song
      }

      if (current != null) {
         play();
      } else {
         System.out.println("Playlist is empty.");
      }
   }

   // Node representing a song in the playlist
   class Node {
      String songTitle;
      Node prev, next;

      public Node(String songTitle) {
         this.songTitle = songTitle;
      }
   }
}

