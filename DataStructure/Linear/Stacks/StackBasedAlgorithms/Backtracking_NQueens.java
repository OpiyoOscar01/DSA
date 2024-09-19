package DataStructure.Linear.Stacks.StackBasedAlgorithms;

public class Backtracking_NQueens {

   private static void printSolution(int[][] board) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
   }

   private static boolean isSafe(int[][] board, int row, int col) {
      int N = board.length;

      // Check this row on the left side
      for (int i = 0; i < col; i++) {
         if (board[row][i] == 1) {
            return false;
         }
      }

      // Check upper diagonal on the left side
      for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
         if (board[i][j] == 1) {
            return false;
         }
      }

      // Check lower diagonal on the left side
      for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
         if (board[i][j] == 1) {
            return false;
         }
      }

      return true;
   }

   private static boolean solveNQueensUtil(int[][] board, int col) {
      int N = board.length;
      if (col >= N) {
         return true; // All queens are placed
      }

      for (int i = 0; i < N; i++) {
         if (isSafe(board, i, col)) {
            board[i][col] = 1; // Place queen
            if (solveNQueensUtil(board, col + 1)) {
               return true; // Continue with next column
            }
            board[i][col] = 0; // Backtrack
         }
      }

      return false; // Trigger backtracking
   }

   public static void solveNQueens(int N) {
      int[][] board = new int[N][N];

      if (!solveNQueensUtil(board, 0)) {
         System.out.println("Solution does not exist");
         return;
      }

      printSolution(board);
   }

   public static void main(String[] args) {
      int N = 4; // Size of the board
      solveNQueens(N);
   }
}

