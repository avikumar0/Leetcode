class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;

        s = s.trim();
        int n = s.length();
        boolean seenDigit = false;
        boolean seenE = false;
        boolean seenDot = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                seenDigit = true;
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit || i == n - 1)
                    return false;
                seenE = true;
                seenDigit = false;
            } else if (c == '.') {
                if (seenDot || seenE)
                    return false;
                seenDot = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else {
                return false;
            }
        }

        return seenDigit;
    }
}
