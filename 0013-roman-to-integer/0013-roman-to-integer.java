class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0; // Initialize the previous value to 0.

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentSymbol = s.charAt(i);
            int curValue = 0;

            switch (currentSymbol) {
                case 'I':
                    curValue = 1;
                    break;
                case 'V':
                    curValue = 5;
                    break;
                case 'X':
                    curValue = 10;
                    break;
                case 'L':
                    curValue = 50;
                    break;
                case 'C':
                    curValue = 100;
                    break;
                case 'D':
                    curValue = 500;
                    break;
                case 'M':
                    curValue = 1000;
                    break;
                default:
                    break;
            }

            // If the current value is smaller than the previous value, subtract it.
            if (curValue < prevValue) {
                result -= curValue;
            } else {
                result += curValue;
            }

            prevValue = curValue; // Update the previous value.
        }

        return result;
    }
}
