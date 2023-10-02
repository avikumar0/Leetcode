class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canReach = new boolean[n]; // Create a boolean array to track reachability.
        canReach[0] = true; // You can reach the first position.

        // Iterate through the array and update the reachability array.
        for (int i = 0; i < n; i++) {
            if (canReach[i]) {
                int maxJump = nums[i];
                for (int j = 1; j <= maxJump && i + j < n; j++) {
                    canReach[i + j] = true;
                }
            }
        }

        return canReach[n - 1]; // Check if you can reach the last position.
    }
}
