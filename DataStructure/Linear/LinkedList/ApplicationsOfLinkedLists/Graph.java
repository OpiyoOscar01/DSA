package DataStructure.Linear.LinkedList.ApplicationsOfLinkedLists;

// Graph class representing adjacency list using linked lists
class Graph {
   private final int vertices; // Number of vertices in the graph
   private final Node[] adjList; // Array of linked lists to store adjacency list
   // Constructor to initialize the graph with given number of vertices
   public Graph(int vertices) {
      this.vertices = vertices;
      adjList = new Node[vertices]; // Initialize array of linked lists
   }

   public static void main(String[] args) {
      Graph graph = new Graph(5);

      graph.addEdge(0, 1);
      graph.addEdge(0, 4);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(1, 4);
      graph.addEdge(2, 3);
      graph.addEdge(3, 4);

      // Print adjacency list representation of the graph
      graph.printGraph();
   }

   // Function to add an edge to the graph
   public void addEdge(int source, int destination) {
      // Adding the edge from source to destination
      Node newNode = new Node(destination);
      newNode.next = adjList[source];
      adjList[source] = newNode;

      // For undirected graph, add the reverse edge as well
      newNode = new Node(source);
      newNode.next = adjList[destination];
      adjList[destination] = newNode;
   }

   // Function to print the adjacency list representation of the graph
   public void printGraph() {
      for (int i = 0; i < vertices; i++) {
         System.out.print("Adjacency list of vertex " + i + ": ");
         Node temp = adjList[i];
         while (temp != null) {
            System.out.print(temp.vertex + " -> ");
            temp = temp.next;
         }
         System.out.println("null");
      }
   }

   class Node {
      int vertex;
      Node next;

      // Constructor for creating a new node
      Node(int vertex) {
         this.vertex = vertex;
         next = null;
      }
   }
}

