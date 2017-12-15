import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0; i<list1.length; i++){
            for(int j=0; j<list2.length; j++){
                if(list1[i].equals(list2[j]) && i+j<min){
                    min = i+j;
                }
            }
        }
        for(int i=0; i<list1.length; i++){
            for(int j=0; j<list2.length; j++){
                if(list1[i].equals(list2[j]) && i+j==min){
                    result.add(list1[i]);
                }
            }
        }
        String [] tmp=new String[result.size()];
        return result.toArray(tmp);
    }
}
