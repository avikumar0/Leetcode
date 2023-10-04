class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Create a copy of the board to store the next state
        int[][] nextBoard = new int[m][n];
        
        // Define eight possible directions to check neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };
        
        // Iterate through each cell in the original board
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int liveNeighbors = 0;
                
                // Check neighbors in all eight directions
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 1) {
                        liveNeighbors++;
                    }
                }
                
                // Apply the Game of Life rules
                if (board[row][col] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextBoard[row][col] = 0; // Cell dies
                    } else {
                        nextBoard[row][col] = 1; // Cell lives
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextBoard[row][col] = 1; // Cell becomes alive
                    }
                }
            }
        }
        
        // Update the original board with the next state
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = nextBoard[row][col];
            }
        }
    }
}
