class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        if (n == 0) {
            return 0; // Empty needle is always found at index 0.
        }
        
        if (m < n) {
            return -1; // If haystack is shorter than needle, needle cannot be found.
        }
        
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i; // Found a match.
            }
        }
        
        return -1; // Needle not found in haystack.
    }
}
