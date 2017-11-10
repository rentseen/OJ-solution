import java.util.*;

public class Solution {
    public static int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int width=0;
        for(int i=0; i<height; i++){
            int sum = 0;
            List<Integer> line = wall.get(i);
            for(int j=0; j<line.size(); j++){
                sum += line.get(j);
                if(!hm.containsKey(sum)){
                    hm.put(sum, 1);
                }
                else{
                    hm.put(sum, hm.get(sum)+1);
                }
            }
            width = sum;
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            int v = entry.getValue();
            if(width!=entry.getKey() && max<v)
                max = v;
        }
        return height-max;
    }
    public static void main(String[] args){
        Integer[] l1 = {1};
        Integer[] l2 = {1};
        Integer[] l3 = {1};
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(l1));
        wall.add(Arrays.asList(l2));
        wall.add(Arrays.asList(l3));
        System.out.println(leastBricks(wall));
    }
}
