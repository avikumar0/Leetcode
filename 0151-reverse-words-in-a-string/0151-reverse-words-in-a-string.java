class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // Split the string by one or more spaces and trim leading/trailing spaces
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}
