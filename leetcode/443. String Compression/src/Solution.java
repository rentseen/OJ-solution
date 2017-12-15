import java.util.ArrayList;

public class Solution {
    public static int getLength(int x){
        if(x==1)
            return 0;
        int l = 0;
        while(x!=0){
            l++;
            x /= 10;
        }
        return l;
    }
    public static int compress(char[] chars) {
        if(chars.length==0){
            return 0;
        }
        if(chars.length==1){
            return 1;
        }
        int base=0;
        int sum=0;
        int front=0;
        for(int i=0; i<chars.length; i++){
            if(chars[i]!=chars[base]){
                int length = getLength(i-base);
                chars[front]=chars[base];
                if(length!=0){
                    String s = ""+(i-base);
                    for(int j=0; j<s.length(); j++){
                        chars[front+1+j] = s.charAt(j);
                    }
                }

                front +=1+length;
                sum += 1 + length;
                base = i;
            }
            if(i==chars.length-1){
                int length = getLength(i-base+1);
                chars[front]=chars[base];
                if(length!=0) {
                    String s = "" + (i-base+1);
                    for (int j = 0; j < s.length(); j++) {
                        chars[front + 1 + j] = s.charAt(j);
                    }
                }

                sum += 1 + length;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        char[] chars = {'a','b','c'};
        System.out.println(compress(chars));
    }
}
