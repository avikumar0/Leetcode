class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisDFS(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisDFS(List<String> result, String current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (openCount < n) {
            generateParenthesisDFS(result, current + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            generateParenthesisDFS(result, current + ")", openCount, closeCount + 1, n);
        }
    }
}