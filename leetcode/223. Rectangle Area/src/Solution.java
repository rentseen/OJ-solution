/**
 * Created by Yelinsheng on 17-3-22.
 */
public class Solution {
    static int computeIntersect(int A, int B, int C, int D, int E, int F, int G, int H){
        if(Math.max(A,E)>Math.min(C,G)){
            return 0;
        }
        if(Math.max(F,B)>Math.min(D,H)){
            return 0;
        }
        int x1=Math.max(A,E);
        int y1=Math.max(B,F);
        int x2=Math.min(C,G);
        int y2=Math.min(D,H);

        return (x2-x1)*(y2-y1);
    }
    static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       return (C-A)*(D-B)+(G-E)*(H-F)-computeIntersect(A,B,C,D,E,F,G,H);
    }
    public static void main(String[] args){
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
    }
}
