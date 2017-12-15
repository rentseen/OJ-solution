public class Solution {
    public static String minWindow(String S, String T) {
        int base=0;
        int front=0;
        int index=0;
        String result="";
        for(;front<S.length();front++){
            if(S.charAt(front)==T.charAt(index))
                index++;
            if(index==T.length()){
                //back
                index--;
                for(base=front;base>=0; base--){
                    if(S.charAt(base)==T.charAt(index))
                        index--;
                    if(index<0){
                        if(result.length()==0 && front-base+1>0)
                            result = S.substring(base, front+1);
                        else if(result.length()>front-base+1)
                            result = S.substring(base, front+1);
                        break;
                    }
                }
                index=0;
                front=base+1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        String S = "ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl";
        String T = "ntimcimzah";
        //String S = "awbcaacbc";
        //String T = "abc";
        System.out.println(minWindow(S, T));
    }
}
