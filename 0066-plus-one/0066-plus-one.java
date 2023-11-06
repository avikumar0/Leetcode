class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry, we are done
            } else {
                digits[i] = 0; // Set the current digit to 0 and continue to the next one
            }
        }
        
        // If we are here, it means we need to add a new most significant digit (1)
        int[] result = new int[n + 1];
        result[0] = 1;
        
        // The rest of the digits are already initialized to 0
        
        return result;
    }
}
