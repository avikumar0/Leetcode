class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            // Reverse each word and append it to the result string.
            StringBuilder reversedWord = new StringBuilder(word);
            result.append(reversedWord.reverse()).append(" ");
        }
        
        // Remove the trailing whitespace and return the reversed sentence.
        return result.toString().trim();
    }
}