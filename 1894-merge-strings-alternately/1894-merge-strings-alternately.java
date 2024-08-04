class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0; // Pointer for word1
        int j = 0;

        // Merge characters from both words alternately
        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        // Append remaining characters from word1 if any
        while (i < word1.length()) {
            result.append(word1.charAt(i++));
        }

        // Append remaining characters from word2 if any
        while (j < word2.length()) {
            result.append(word2.charAt(j++));
        }

        return result.toString();
    }
}
