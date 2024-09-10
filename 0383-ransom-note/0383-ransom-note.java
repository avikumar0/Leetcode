class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hashmap = new HashMap<>();

        for(char ch: magazine.toCharArray()){
            hashmap.put(ch, hashmap.getOrDefault(ch,0)+1);
        }

        for(char ch: ransomNote.toCharArray()){
            if(hashmap.getOrDefault(ch,0)>0){
                hashmap.put(ch,hashmap.getOrDefault(ch,0)-1);
            }else{
                return false;
            }
        }

        return true;
    }
}