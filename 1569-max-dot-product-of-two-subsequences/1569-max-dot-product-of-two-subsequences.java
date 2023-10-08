class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // Create a 2D array dp to store the maximum dot product for subarrays
        int[][] dp = new int[m][n];

        // Initialize the first element
        dp[0][0] = nums1[0] * nums2[0];

        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], nums1[0] * nums2[j]);
        }

        // Initialize the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }

        // Fill the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int currentProduct = nums1[i] * nums2[j];
                dp[i][j] = Math.max(currentProduct, dp[i - 1][j - 1] + currentProduct);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
