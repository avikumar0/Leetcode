class Solution {
    public boolean isPalindrome(int x) {
        // If x is negative or ends with a zero (except for zero itself), it can't be a palindrome.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int originalX = x;

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return originalX == reversed;
    }
}
