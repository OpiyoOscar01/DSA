package DataStructure.Linear.Stacks.StackBasedAlgorithms;

import java.util.*;

public class DFSExample {

   // Method to perform DFS on a graph
   public static void depthFirstSearch(Map<Integer, List<Integer>> graph, int start) {
      Stack<Integer> stack = new Stack<>();
      Set<Integer> visited = new HashSet<>();

      // Push the starting node onto the stack
      stack.push(start);

      // Continue while there are nodes to explore
      while (!stack.isEmpty()) {
         // Pop a node from the stack
         int node = stack.pop();

         // If the node has not been visited, mark it as visited
         if (!visited.contains(node)) {
            System.out.println("Visited: " + node);
            visited.add(node);

            // Push all adjacent nodes that have not been visited onto the stack
            for (int neighbor : graph.get(node)) {
               if (!visited.contains(neighbor)) {
                  stack.push(neighbor);
               }
            }
         }
      }
   }

   // Main method to test DFS
   public static void main(String[] args) {
      // Create a graph as an adjacency list
      Map<Integer, List<Integer>> graph = new HashMap<>();
      graph.put(1, Arrays.asList(2, 3));
      graph.put(2, Arrays.asList(4, 5));
      graph.put(3, List.of(6));
      graph.put(4, List.of());
      graph.put(5, List.of());
      graph.put(6, List.of());

      // Perform DFS starting from node 1
      depthFirstSearch(graph, 1);
   }
}

