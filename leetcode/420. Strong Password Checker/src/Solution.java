import java.util.ArrayList;
import java.util.List;

public class Solution {
    //先调整小于6和大于20的，删除不需要的，或者增加需要的
    static class node{
        node(int b, int l){
            base = b;
            length = l;
        }
        int base;
        int length;
    }
    public static int strongPasswordChecker(String s) {
        StringBuilder sb = new StringBuilder(s);
        int lower_count = 0;
        int digit_count = 0;
        int upper_count = 0;
        List<node> repeat = new ArrayList<>();
        int base = 0;
        int count=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                lower_count++;
            }
            else if(c>='A' && c<='Z'){
                upper_count++;
            }
            else if(c>='0' && c<='9'){
                digit_count++;
            }
            if(i>0 && c!=s.charAt(i-1)){
                if(i-base>=3){
                    repeat.add(new node(base,i-base));
                }
                base = i;
            }
        }
        if(s.length()-base>=3){
            repeat.add(new node(base,s.length()-base));
        }
        if(sb.length()<6){
            int repeat_count = 0;
            for(int i=0; i<repeat.size(); i++){
                repeat_count += (repeat.get(i).length+1)/3;
            }
            int one_count=0;
            if(lower_count==0){
                one_count++;
            }
            if(upper_count==0){
                one_count++;
            }
            if(digit_count==0){
                one_count++;
            }
            count = repeat_count>one_count?repeat_count:one_count;
            count = count>(6-sb.length())?count:(6-sb.length());
            return count;
        }
        else if(sb.length()>20){
            //先减重复的
            //再随便减，但不能把大小写减完
            int dis_count=sb.length()-20;
            while(dis_count!=0){
                boolean flag= false;
                for(int i=0; i<repeat.size(); i++){
                    node n = repeat.get(i);
                    if(n.length%3==0){
                        count++;
                        n.length--;
                        if(n.length==2){
                            repeat.remove(i);
                            i--;
                        }
                        flag = true;
                        dis_count--;
                        break;
                    }
                }
                if(flag){
                    continue;
                }
                for(int i=0; i<repeat.size(); i++){
                    node n = repeat.get(i);
                    if(n.length%3==1){
                        count++;
                        n.length--;
                        if(n.length==2){
                            repeat.remove(i);
                            i--;
                        }
                        flag = true;
                        dis_count--;
                        break;
                    }
                }
                if(flag){
                    continue;
                }
                for(int i=0; i<repeat.size(); i++){
                    node n = repeat.get(i);
                    count++;
                    n.length--;
                    if(n.length==2){
                        repeat.remove(i);
                        i--;
                    }
                    flag = true;
                    dis_count--;
                    break;
                }
                if(flag){
                    continue;
                }
                dis_count--;
                count++;

            }
        }
        int repeat_count = 0;
        for(int i=0; i<repeat.size(); i++){
            repeat_count += repeat.get(i).length/3;
        }
        int one_count=0;
        if(lower_count==0){
            one_count++;
        }
        if(upper_count==0){
            one_count++;
        }
        if(digit_count==0){
            one_count++;
        }
        count += repeat_count>one_count?repeat_count:one_count;
        return count;
    }

    public static void main(String[] args){
        String s = "aaaaabbbb1234567890ABA";
        System.out.println(strongPasswordChecker(s));
    }
}
