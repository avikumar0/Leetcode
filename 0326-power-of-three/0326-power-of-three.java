class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        
        double result = Math.log(n) / Math.log(3);
        // Check if the result is very close to an integer.
        return Math.abs(result - Math.round(result)) < 1e-10;
    }
}
