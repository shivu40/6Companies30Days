class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0;
        while(end < n){
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            while(map.size() == 3){
                count += n - end;
                
                char startChar = s.charAt(start);
                int freq = map.get(startChar);
                if(freq > 1){
                    map.put(startChar, freq - 1);
                }else if (freq == 1){
                    map.remove(startChar);
                }
                start++;
            }   

            end++;
        }

        return count;
    }
}