import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{') {
                stack.addLast(c);
            }
            else if(c==')') {
                if(stack.size()==0) {
                    return false;
                }
                char tmp = stack.pollLast();
                if(tmp!='(') {
                    return false;
                }
            }
            else if(c==']') {
                if(stack.size()==0) {
                    return false;
                }
                char tmp = stack.pollLast();
                if(tmp!='[') {
                    return false;
                }
            }
            else if(c=='}') {
                if(stack.size()==0) {
                    return false;
                }
                char tmp = stack.pollLast();
                if(tmp!='{') {
                    return false;
                }
            }
        }
        if(stack.size()==0)
            return true;
        else
            return false;
    }
}
