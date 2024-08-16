class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l_arr = new int[n];
        int[] r_arr = new int[n];
        
        // Initialize the products for left and right sides
        int l_mult = 1;
        int r_mult = 1;
        
        // Calculate left products
        for (int i = 0; i < n; i++) {
            l_arr[i] = l_mult;
            l_mult *= nums[i];
        }
        
        // Calculate right products
        for (int i = n - 1; i >= 0; i--) {
            r_arr[i] = r_mult;
            r_mult *= nums[i];
        }
        
        // Compute result array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = l_arr[i] * r_arr[i];
        }
        
        return result;
    }
}