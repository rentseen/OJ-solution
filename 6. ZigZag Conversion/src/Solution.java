/**
 * Created by rentseen on 17-4-27.
 */
public class Solution {
    public static String convert(String s, int numRows) {
        StringBuilder result=new StringBuilder();
        for(int i=0;i<numRows;i++){
            if(i==0 || i==numRows-1){
                int j=i;
                while(j<s.length()){
                    result.append(s.charAt(j));
                    if(numRows==1){
                        j=j+1;
                    }
                    else{
                        j=j+2*numRows-2;
                    }
                }
            }
            else{
                int j=i;
                while(j<s.length()){
                    result.append(s.charAt(j));
                    j=j+2*(numRows-(i+1));
                    if(j<s.length()){
                        result.append(s.charAt(j));
                        j=j+2*i;
                    }
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        String s="A";
        int numRows=1;
        System.out.println(convert(s,numRows));
    }
}
