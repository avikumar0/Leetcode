class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        // Calculate the total sum of all cards
        int totalSum = 0;
        for (int card : cardPoints) {
            totalSum += card;
        }
        
        // Calculate the sum of the first (n-k) cards from the beginning
        int windowSum = 0;
        for (int i = 0; i < n - k; i++) {
            windowSum += cardPoints[i];
        }
        
        int minWindowSum = windowSum;
        
        // Slide the window to the right and keep track of the minimum window sum
        for (int i = n - k; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - (n - k)];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }
        
        // The maximum score is the total sum minus the minimum window sum
        return totalSum - minWindowSum;
    }
}
