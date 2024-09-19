package DataStructure.Linear.LinkedList.AdvancedLinkedList.Challenge;

import java.util.*;

public class Graph {

   // Graph class representing the graph structure
   private final Map<Integer, List<Integer>> adjList;

   // Constructor for initializing the graph
   public Graph() {
      adjList = new HashMap<>();
   }

   // Main method for testing
   public static void main(String[] args) {
      Graph graph = new Graph();
      graph.addEdge(0, 1);
      graph.addEdge(0, 2);
      graph.addEdge(1, 2);
      graph.addEdge(2, 3);
      graph.addEdge(3, 4);

      System.out.println("DFS Traversal starting from vertex 0:");
      graph.DFS(0);  // Output: 0 1 2 3 4

      System.out.println("\nBFS Traversal starting from vertex 0:");
      graph.BFS(0);  // Output: 0 1 2 3 4
   }

   // Method to add an edge between two vertices
   public void addEdge(int src, int dest) {
      adjList.putIfAbsent(src, new ArrayList<>());
      adjList.putIfAbsent(dest, new ArrayList<>());
      adjList.get(src).add(dest);
      adjList.get(dest).add(src); // If undirected graph
   }

   // Method for DFS traversal
   public void DFS(int startVertex) {
      Set<Integer> visited = new HashSet<>();
      DFSUtil(startVertex, visited);
   }

   // Utility function for DFS traversal
   private void DFSUtil(int vertex, Set<Integer> visited) {
      visited.add(vertex);
      System.out.print(vertex + " ");

      for (int neighbor : adjList.get(vertex)) {
         if (!visited.contains(neighbor)) {
            DFSUtil(neighbor, visited);
         }
      }
   }

   // Method for BFS traversal
   public void BFS(int startVertex) {
      Set<Integer> visited = new HashSet<>();
      Queue<Integer> queue = new LinkedList<>();
      visited.add(startVertex);
      queue.add(startVertex);

      while (!queue.isEmpty()) {
         int vertex = queue.poll();
         System.out.print(vertex + " ");

         for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
               visited.add(neighbor);
               queue.add(neighbor);
            }
         }
      }
   }
}


