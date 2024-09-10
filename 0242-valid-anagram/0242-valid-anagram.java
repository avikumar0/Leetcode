class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> sMap=new HashMap<>();
        HashMap<Character,Integer> tMap=new HashMap<>();

        for(char ch: s.toCharArray()){
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
        }
        for(char ch: t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }

        return sMap.equals(tMap);
    }
}