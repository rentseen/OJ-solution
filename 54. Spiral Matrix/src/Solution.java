import java.util.ArrayList;
import java.util.List;

/**
 * Created by rentseen on 17-4-16.
 */

public class Solution {
    public static List<Integer> getCircle(int[][] matrix,int left,int right,int top,int bottom){
        List<Integer> result=new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            result.add(matrix[top][i]);
        }
        if(top==bottom){
            return result;
        }
        for(int i=top+1;i<=bottom;i++){
            result.add(matrix[i][right]);
        }
        if(left==right){
            return result;
        }
        for(int i=right-1;i>=left;i--){
            result.add(matrix[bottom][i]);
        }
        for(int i=bottom-1;i>=top+1;i--){
            result.add(matrix[i][left]);
        }
        return result;
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new ArrayList<Integer>();
        }
        int left=0;
        int right=matrix.length==-1?0:matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        List<Integer> result=new ArrayList<Integer>();
        while (left<=right && top<=bottom){
            result.addAll(getCircle(matrix,left,right,top,bottom));
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
    public static void main(String []args){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result=spiralOrder(matrix);
        System.out.println(result);
    }
}
