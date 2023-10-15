import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder("/");
        for (String component : stack) {
            simplifiedPath.append(component).append("/");
        }

        if (simplifiedPath.length() > 1) {
            simplifiedPath.setLength(simplifiedPath.length() - 1); // Remove the trailing slash
        }

        return simplifiedPath.toString();
    }
}
