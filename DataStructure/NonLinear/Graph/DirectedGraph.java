package DataStructure.NonLinear.Graph;

import java.util.LinkedList;

public class DirectedGraph {
   // Define the number of vertices
   private final int vertices;

   // Array of lists for adjacency list representation
   private final LinkedList<Integer>[] adjacencyList;

   // Constructor to initialize the graph
   public DirectedGraph(int vertices) {
      this.vertices = vertices;
      adjacencyList = new LinkedList[vertices];

      // Initialize the adjacency list for each vertex
      for (int i = 0; i < vertices; i++) {
         adjacencyList[i] = new LinkedList<>();
      }
   }

   public static void main(String[] args) {
      // Create a directed graph with 5 vertices
      DirectedGraph graph = new DirectedGraph(5);

      // Add directed edges between nodes
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

   // Add an edge (directed, so only one direction)
   public void addEdge(int source, int destination) {
      adjacencyList[source].add(destination);
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

