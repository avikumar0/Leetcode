class Solution {
    public int subarraySum(int[] nums, int k) {
        // Initialize a hashmap to store the cumulative sum and its frequency.
        Map<Integer, Integer> cumulativeSumMap = new HashMap<>();
        cumulativeSumMap.put(0, 1); // Initialize with 0 cumulative sum to account for subarrays starting from index 0.
        
        int cumulativeSum = 0;
        int count = 0;
        
        for (int num : nums) {
            cumulativeSum += num;
            
            // Check if there is a subarray with a sum of (cumulativeSum - k).
            if (cumulativeSumMap.containsKey(cumulativeSum - k)) {
                count += cumulativeSumMap.get(cumulativeSum - k);
            }
            
            // Update the cumulative sum frequency.
            cumulativeSumMap.put(cumulativeSum, cumulativeSumMap.getOrDefault(cumulativeSum, 0) + 1);
        }
        
        return count;
    }
}
