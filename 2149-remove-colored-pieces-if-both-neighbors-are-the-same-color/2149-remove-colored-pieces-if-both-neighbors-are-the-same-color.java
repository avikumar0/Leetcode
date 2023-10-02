class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int aliceCount = 0;
        int bobCount = 0;
        
        for (int i = 1; i < n - 1; i++) {
            // Check for valid moves for Alice.
            if (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                aliceCount++;
            }
            
            // Check for valid moves for Bob.
            if (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                bobCount++;
            }
        }
        
        return aliceCount > bobCount;
    }
}
