package DataStructure.NonLinear.Graph;

import java.util.LinkedList;

public class UndirectedGraph {
   // Define the number of vertices (nodes)
   private final int vertices;

   // Create an array of lists for adjacency list representation
   private final LinkedList<Integer>[] adjacencyList;

   // Constructor to initialize the graph
   public UndirectedGraph(int vertices) {
      this.vertices = vertices;
      adjacencyList = new LinkedList[vertices];

      // Initialize the adjacency list for each vertex
      for (int i = 0; i < vertices; i++) {
         adjacencyList[i] = new LinkedList<>();
      }
   }

   public static void main(String[] args) {
      // Create an undirected graph with 5 vertices
      UndirectedGraph graph = new UndirectedGraph(5);

      // Add edges between nodes
      graph.addEdge(0, 1);
      graph.addEdge(0, 4);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(1, 4);
      graph.addEdge(2, 3);
      graph.addEdge(3, 4);

      // Print the graph's adjacency list
      graph.printGraph();
   }

   // Add an edge (undirected, so both directions)
   public void addEdge(int source, int destination) {
      adjacencyList[source].add(destination);
      adjacencyList[destination].add(source);
   }

   // Print the graph's adjacency list representation
   public void printGraph() {
      for (int i = 0; i < vertices; i++) {
         System.out.print("Vertex " + i + ": ");
         for (Integer node : adjacencyList[i]) {
            System.out.print(node + " ");
         }
         System.out.println();
      }
   }
}

