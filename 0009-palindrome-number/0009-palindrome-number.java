class Solution {
    public boolean isPalindrome(int x) {
        // If x is negative or ends with a zero (except for zero itself), it can't be a palindrome.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Convert the integer to a string.
        String strX = String.valueOf(x);

        int left = 0;
        int right = strX.length() - 1;

        while (left < right) {
            // Compare characters from the left and right ends of the string.
            if (strX.charAt(left) != strX.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
