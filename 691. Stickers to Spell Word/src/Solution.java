import java.util.HashMap;

public class Solution {
    public static int search(HashMap<String, Integer> mp, int[][]alphabet, String target){
        if(mp.containsKey(target))
            return mp.get(target);

        int min = Integer.MAX_VALUE;
        int goal[] = new int[26];
        for(int i=0; i<target.length(); i++){
            goal[target.charAt(i)-'a']++;
        }

        for(int i=0; i<alphabet.length; i++){
            if(alphabet[i][target.charAt(0)-'a']==0)
                continue;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<goal.length; j++){
                goal[j] -= alphabet[i][j];
                for(int m=0; m<goal[j]; m++)
                    sb.append((char)('a'+j));
            }
            int num;
            if(sb.length()==0)
                num = 0;
            else
                num = search(mp, alphabet, sb.toString());
            if(num>=0 && min>num)
                min = num;
            for(int k=0; k<goal.length; k++){
                goal[k] += alphabet[i][k];
            }
        }
        if(min == Integer.MAX_VALUE) {
            mp.put(target, -1);
            return -1;
        }
        else {
            mp.put(target, min+1);
            return min + 1;
        }

    }
    public static int minStickers(String[] stickers, String target) {
        int[][] alphabet = new int[stickers.length][26];
        for(int i=0; i<stickers.length; i++){
            String s = stickers[i];
            for(int j=0; j<s.length();j++){
                alphabet[i][s.charAt(j)-'a']++;
            }
        }
        HashMap<String, Integer> mp = new HashMap<>();
        return search(mp, alphabet, target);
    }
    public static void main(String[] args){

        String[] stickers = {"control","heart","interest","stream","sentence","soil","wonder","them","month","slip","table","miss","boat","speak","figure","no","perhaps","twenty","throw","rich","capital","save","method","store","meant","life","oil","string","song","food","am","who","fat","if","put","path","come","grow","box","great","word","object","stead","common","fresh","the","operate","where","road","mean"};
        String target = "stoodcrease";
        System.out.println(minStickers(stickers, target));
    }
}
