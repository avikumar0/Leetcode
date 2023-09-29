class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int currentWater = h * width;
            maxWater = Math.max(maxWater, currentWater);
            
            // Move the pointer that points to the shorter line inward,
            // because moving the taller line inward cannot increase the area.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}
