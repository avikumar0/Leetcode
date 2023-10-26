class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            int remainder = (columnNumber % 26);
            if (remainder == 0) {
                remainder = 26;
            }
            result.append((char) ('A' + remainder - 1));
            columnNumber = (columnNumber - 1) / 26;
        }
        
        return result.reverse().toString();
    }
}
