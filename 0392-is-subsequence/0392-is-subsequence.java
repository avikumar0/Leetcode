class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // Pointer for string s
        int j = 0; // Pointer for string t

        // Traverse through string t
        while (j < t.length()) {
            // If characters match, move pointer i
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move pointer j
            j++;
        }

        // If pointer i reached the end of s, it means s is a subsequence of t
        return i == s.length();
    }
}
