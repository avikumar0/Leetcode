class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int wordCount = words.length;

        if (wordCount == 0) {
            return "";
        }

        String reversed = words[wordCount - 1];

        for (int i = wordCount - 2; i >= 0; i--) {
            reversed = reversed + " " + words[i];
        }

        return reversed;
    }
}
