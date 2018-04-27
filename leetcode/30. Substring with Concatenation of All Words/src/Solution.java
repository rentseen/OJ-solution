import java.util.*;

public class Solution {
    public void clearMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            entry.setValue(0);
        }
    }
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> baseMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if(s.length()==0 || words.length==0)
            return result;
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            countMap.put(word, 0);
            if(baseMap.containsKey(word)){
                int x = baseMap.get(word);
                baseMap.put(word, x+1);
            }
            else {
                baseMap.put(word, 1);
            }
        }

        int count=0;
        int len=words[0].length();
        for(int i=0; i<=s.length()-words.length*len; i++){
            clearMap(countMap);
            count=0;
            for(int j=i; j<s.length(); j=j+len) {
                String sub = s.substring(j, j+len);
                if(countMap.containsKey(sub)) {
                    int x = countMap.get(sub);
                    int y = baseMap.get(sub);
                    if(x<y) {
                        countMap.put(sub, x+1);
                        count++;
                        if(count==words.length) {
                            result.add(j-(words.length-1)*len);
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }
        return result;
    }
}
