package DataStructure.NonLinear.Graph;

public class DirectedGraph_MatrixImpl {
   private final int nodes;
   private final int[][] adjacencyMatrix;

   public DirectedGraph_MatrixImpl(int nodes) {
      this.nodes = nodes;
      adjacencyMatrix = new int[nodes][nodes];
   }

   public static void main(String[] args) {
      DirectedGraph_MatrixImpl dg = new DirectedGraph_MatrixImpl(4);
      dg.addEdge(0, 1);
      dg.addEdge(0, 2);
      dg.addEdge(0, 3);
      dg.addEdge(1, 2);
      dg.printGraph();

   }

   public void addEdge(int v, int w) {
      adjacencyMatrix[v][w] = 1;
   }

   public void printGraph() {
      for (int i = 0; i < nodes; i++) {
         for (int j = 0; j < nodes; j++) {
            System.out.print(adjacencyMatrix[i][j] + " ");
         }
         System.out.println();
      }
   }
}
