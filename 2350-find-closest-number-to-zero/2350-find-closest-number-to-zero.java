class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = Integer.MAX_VALUE;

        for (int num : nums) {
            // Check if the absolute value of the current number is less
            // than the absolute value of the current closest number
            if (Math.abs(num) < Math.abs(closest)) {
                closest = num;
            } else if (Math.abs(num) == Math.abs(closest)) {
                // If the absolute values are the same, pick the larger number
                if (num > closest) {
                    closest = num;
                }
            }
        }

        return closest;
    }
}
