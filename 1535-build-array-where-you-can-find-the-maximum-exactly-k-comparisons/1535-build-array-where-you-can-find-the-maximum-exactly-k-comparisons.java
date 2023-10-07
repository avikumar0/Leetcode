class Solution {
    public int numOfArrays(int n, int m, int k) {
        int MOD = 1000000007;

        // If k is 0 or greater than n or m < k, there are no valid ways.
        if (k == 0 || k > n || m < k) {
            return 0;
        }
        
        long[][][] dp = new long[n + 1][m + 1][k + 1];

        // Initialize the dp array for k = 1 and m values from 1 to m.
        for (int i = 1; i <= m; i++) {
            dp[1][i][1] = 1;
        }

        // Fill the dp array using dynamic programming.
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    // Choose the maximum value for the current position.
                    dp[i][j][l] = (dp[i][j][l] + dp[i - 1][j][l] * j) % MOD;

                    // Choose a non-maximum value for the current position.
                    for (int prev = 1; prev < j; prev++) {
                        dp[i][j][l] = (dp[i][j][l] + dp[i - 1][prev][l - 1]) % MOD;
                    }
                }
            }
        }

        long result = 0;
        for (int i = 1; i <= m; i++) {
            result = (result + dp[n][i][k]) % MOD;
        }

        return (int) result;
    }
}
