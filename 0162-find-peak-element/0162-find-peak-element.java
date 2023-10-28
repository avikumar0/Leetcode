class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Move to the left side, as the peak is on the left.
                right = mid;
            } else {
                // Move to the right side, as the peak is on the right.
                left = mid + 1;
            }
        }

        // At this point, 'left' and 'right' will be equal, and it represents the peak element.
        return left;
    }
}
