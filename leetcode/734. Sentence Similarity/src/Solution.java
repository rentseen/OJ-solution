public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length!=words2.length)
            return false;
        out:
        for(int i=0; i<words1.length; i++){
            if(words1[i].equals(words2[i]))
                continue;
            for(int j=0; j<pairs.length; j++){
                if(words1[i].equals(pairs[j][0]) && words2[i].equals(pairs[j][1]))
                    continue out;
                if(words1[i].equals(pairs[j][1]) && words2[i].equals(pairs[j][0]))
                    continue out;
            }
            return false;
        }
        return true;
    }
}
