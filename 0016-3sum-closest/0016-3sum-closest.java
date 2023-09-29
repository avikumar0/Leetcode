class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums); // Sort the array to simplify the process
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closestSum to the sum of the first three elements
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Update closestSum if the current sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestSum;
    
    }
}