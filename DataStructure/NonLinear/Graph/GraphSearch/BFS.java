package DataStructure.NonLinear.Graph.GraphSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

   // Define the number of vertices (nodes)
   private final int vertices;

   // Create an array of lists for adjacency list representation
   private final LinkedList<Integer>[] adjacencyList;

   // Constructor to initialize the graph
   public BFS(int vertices) {
      this.vertices = vertices;
      adjacencyList = new LinkedList[vertices];

      // Initialize the adjacency list for each vertex
      for (int i = 0; i < vertices; i++) {
         adjacencyList[i] = new LinkedList<>();
      }
   }

   public static void main(String[] args) {
      // Create an undirected graph with 7 vertices (indexed from 0 to 6)
      BFS bfs = new BFS(7);

      // Add edges between nodes
      bfs.addEdge(0, 1);
      bfs.addEdge(0, 4);
      bfs.addEdge(1, 2);
      bfs.addEdge(1, 3);
      bfs.addEdge(1, 4);
      bfs.addEdge(2, 3);
      bfs.addEdge(3, 4);

      // Print the graph's adjacency list
      bfs.printGraph();

      // Perform BFS traversal starting from vertex 0 (or any valid vertex from 0 to 6)
      System.out.println("BFS traversal starting from vertex 0:");
      bfs.breadthFirstSearch(0);
   }

   // Add an edge (undirected, so both directions)
   public void addEdge(int source, int destination) {
      adjacencyList[source].add(destination);
      adjacencyList[destination].add(source);
   }

   // Perform BFS traversal from the given source node
   public void breadthFirstSearch(int source) {
      boolean[] visited = new boolean[vertices];  // Array to track visited nodes
      Queue<Integer> queue = new LinkedList<>();  // Queue for BFS traversal
      visited[source] = true;  // Mark the source node as visited
      queue.offer(source);  // Add the source node to the queue

      // Continue BFS traversal while the queue is not empty
      while (!queue.isEmpty()) {
         int node = queue.poll();  // Dequeue a node from the queue
         System.out.print(node + " ");  // Print the dequeued node

         // Iterate over all the adjacent vertices of the dequeued node
         for (int i = 0; i < adjacencyList[node].size(); i++) {
            int neighbor = adjacencyList[node].get(i);  // Get the adjacent node
            if (!visited[neighbor]) {  // If the adjacent node has not been visited
               visited[neighbor] = true;  // Mark it as visited
               queue.offer(neighbor);  // Enqueue the adjacent node for future traversal
            }
         }
      }
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
