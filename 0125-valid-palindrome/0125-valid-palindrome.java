class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Normalize the string by converting to lowercase
        s = s.toLowerCase();

        // Step 2: Remove all non-alphanumeric characters
        StringBuilder filteredString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredString.append(c);
            }
        }

        // Step 3: Check if the resulting string is a palindrome
        String filtered = filteredString.toString();
        int left = 0;
        int right = filtered.length() - 1;

        while (left < right) {
            if (filtered.charAt(left) != filtered.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
