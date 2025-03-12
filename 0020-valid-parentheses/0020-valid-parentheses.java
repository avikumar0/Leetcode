class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> hashmap = new HashMap<>();
        hashmap.put(')', '(');
        hashmap.put('}', '{');
        hashmap.put(']', '[');
        

        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(!hashmap.containsKey(c)){
                st.push(c);
            }else{
                if(st.isEmpty() || st.pop() != hashmap.get(c)){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
