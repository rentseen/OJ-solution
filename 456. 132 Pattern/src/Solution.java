import java.util.Stack;

class Pair{
    int min,max;
    Pair(int mn, int mx){
        min = mn;
        max = mx;
    }
}
public class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Pair> s = new Stack<>();
        for(int n: nums){
            if(s.empty() || n<s.peek().min)
                s.push(new Pair(n, n));
            else if(n>s.peek().min && n<s.peek().max)
                return true;
            else if(n>s.peek().max){
                Pair p = s.pop();
                p.max = n;
                while(!s.isEmpty() && s.peek().max<=n)
                    s.pop();
                if(!s.isEmpty() && s.peek().min<n)
                    return true;
                s.push(p);
            }
        }
        return false;
    }
    public static void main(String[] args){

    }
}
