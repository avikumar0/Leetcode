class Solution {
    public int maxNumberOfBalloons(String text) {
         // Create a hashmap to store the frequencies of the necessary characters.
        HashMap<Character, Integer> countMap = new HashMap<>();
        String balloon = "balloon";
        
        // Initialize the required characters with zero count
        for (char c : balloon.toCharArray()) {
            countMap.put(c, 0);
        }
        
        // Count the occurrences of each character in the input text
        for (char ch : text.toCharArray()) {
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            }
        }
        
        // Now calculate the minimum possible number of "balloon" instances
        // We need 'b', 'a', 'n' once each, and 'l', 'o' twice each
        int bCount = countMap.get('b');
        int aCount = countMap.get('a');
        int lCount = countMap.get('l') / 2; // 'l' must be divided by 2
        int oCount = countMap.get('o') / 2; // 'o' must be divided by 2
        int nCount = countMap.get('n');
        
        // The maximum number of "balloon" words that can be formed is the minimum count of all these
        return Math.min(Math.min(Math.min(bCount, aCount), lCount), Math.min(oCount, nCount));
    }
}