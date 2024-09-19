package DataStructure.NonLinear.Graph.GraphSearch;


import java.util.LinkedList;
import java.util.Stack;

public class DFS {
   // Define the number of vertices (nodes)
   private final int vertices;

   // Create an array of lists for adjacency list representation
   private final LinkedList<Integer>[] adjacencyList;

   // Constructor to initialize the graph
   public DFS(int vertices) {
      this.vertices = vertices;
      adjacencyList = new LinkedList[vertices];

      // Initialize the adjacency list for each vertex
      for (int i = 0; i < vertices; i++) {
         adjacencyList[i] = new LinkedList<>();
      }
   }

   public static void main(String[] args) {
      // Create an undirected graph with 5 vertices
      DFS dfs = new DFS(5);

      // Add edges between nodes
      dfs.addEdge(0, 1);
      dfs.addEdge(0, 4);
      dfs.addEdge(1, 2);
      dfs.addEdge(1, 3);
      dfs.addEdge(1, 4);
      dfs.addEdge(2, 3);
      dfs.addEdge(3, 4);

      // Print the graph's adjacency list
      dfs.printGraph();

      // Perform DFS traversal starting from vertex 0
      dfs.depthFirstSearch(0);
   }

   // Add an edge (undirected, so both directions)
   public void addEdge(int source, int destination) {
      adjacencyList[source].add(destination);
      adjacencyList[destination].add(source); // Since the graph is undirected
   }

   // Perform DFS using an explicit stack
   public void depthFirstSearch(int source) {
      boolean[] visited = new boolean[vertices];  // Array to track visited nodes
      Stack<Integer> stack = new Stack<>();       // Stack for DFS traversal

      stack.push(source);  // Start from the source node
      visited[source] = true;  // Mark the source node as visited

      System.out.println("DFS Traversal starting from node " + source + ":");

      while (!stack.isEmpty()) {
         int node = stack.pop();  // Pop a node from the stack
         System.out.print(node + " ");  // Print the popped node

         // Visit all the unvisited neighbors of the node
         for (int neighbor : adjacencyList[node]) {
            if (!visited[neighbor]) {
               stack.push(neighbor);  // Push unvisited neighbor to the stack
               visited[neighbor] = true;  // Mark the neighbor as visited
            }
         }
      }
      System.out.println();
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

