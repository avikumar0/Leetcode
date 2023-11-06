class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the least significant digit
        int carry = 1; // Initialize carry to 1 to add one
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum >= 10) {
                digits[i] = 0; // Set the current digit to 0
                carry = 1; // Set carry for the next iteration
            } else {
                digits[i] = sum; // Set the current digit
                carry = 0; // No carry needed
                break; // Since there's no carry, we are done
            }
        }

        // If carry is still 1, it means we need to add a new most significant digit (1)
        if (carry == 1) {
            int[] result = new int[n + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, n); // Copy the remaining digits
            return result;
        } else {
            return digits; // No new most significant digit is needed
        }
    }
}
