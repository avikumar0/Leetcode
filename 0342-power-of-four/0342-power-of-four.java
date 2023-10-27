class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false; // Negative numbers and zero cannot be powers of four.
        }

        while (n > 1) {
            if (n % 4 != 0) {
                return false; // If n is not divisible by 4, it's not a power of four.
            }
            n /= 4;
        }

        return n == 1;
    }
}
