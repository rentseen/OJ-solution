import java.util.ArrayList;
import java.util.List;

/**
 * Created by rentseen on 17-3-27.
 */
//深度优先搜索
public class Solution {
    public static void search(int leftNum,int rightNum,String s,List<String> result,int n){
        if(leftNum==n && rightNum==n){
            result.add(s);
            return;
        }
        if(leftNum==rightNum){
            search(leftNum+1,rightNum,s+"(",result,n);
        }
        else if(leftNum>rightNum){
            search(leftNum,rightNum+1,s+")",result,n);
            if(leftNum<n){
                search(leftNum+1,rightNum,s+"(",result,n);
            }
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        search(1,0,"(",result,n);
        return result;
    }
    public static void main(String[] args){
        List<String> result=generateParenthesis(3);
        for(String s:result){
            System.out.println(s);
        }
    }
}
