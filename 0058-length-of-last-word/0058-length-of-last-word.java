class Solution {
    public int lengthOfLastWord(String s) {
        // Split the input string into words using spaces as delimiters
        String[] words = s.split(" ");

        // Find the last non-empty word
        int lastIndex = words.length - 1;
        while (lastIndex >= 0 && words[lastIndex].isEmpty()) {
            lastIndex--;
        }

        // If a non-empty word is found, return its length; otherwise, return 0
        return (lastIndex >= 0) ? words[lastIndex].length() : 0;
    }
}
