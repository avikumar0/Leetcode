class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);  // Initialize left to be the maximum element in the array.
            right += num;  // Initialize right to be the sum of all elements in the array.
        }

        // Perform binary search to find the minimum largest sum.
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossibleToSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Function to check if it's possible to split the array into k subarrays with a given maximum sum.
    private boolean isPossibleToSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return count <= k;
    }
}
