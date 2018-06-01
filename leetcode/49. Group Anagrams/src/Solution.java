import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char[] can = strs[i].toCharArray();
            Arrays.sort(can);
            String key = new String(can);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {

    }
}
