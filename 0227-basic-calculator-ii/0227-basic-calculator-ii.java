class Solution {
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        int prevNum = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (operator) {
                    case '+':
                        result += prevNum;
                        prevNum = num;
                        break;
                    case '-':
                        result += prevNum;
                        prevNum = -num;
                        break;
                    case '*':
                        prevNum *= num;
                        break;
                    case '/':
                        prevNum /= num;
                        break;
                }
                num = 0;
                operator = c;
            }
        }

        result += prevNum;
        return result;
    }
}
