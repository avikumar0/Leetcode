class Solution {
    public boolean exist(char[][] board, String word) {
        // Convert the word to a character array for easier manipulation.
        char[] wordArray = word.toCharArray();
        
        // Iterate through the board to find the starting point.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArray[0] && dfs(board, i, j, wordArray, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, char[] word, int index) {
        // Check if we have found the entire word.
        if (index == word.length) {
            return true;
        }
        
        // Check if the current cell is out of bounds or doesn't match the word character.
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[index]) {
            return false;
        }
        
        // Mark the current cell as visited by changing its value.
        char temp = board[i][j];
        board[i][j] = '#'; // You can use any character that won't match any valid character.
        
        // Recursively search in all four directions (up, down, left, right).
        boolean found = dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1);
        
        // Restore the original value of the cell.
        board[i][j] = temp;
        
        return found;
    }
}
