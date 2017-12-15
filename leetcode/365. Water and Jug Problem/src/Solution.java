/**
 * Created by Yelinsheng on 17-3-23.
 */
public class Solution {
    public static int gcd(int x, int y){
        if(x==0 && y==0){
            return 0;
        }
        if(x==0){
            return y;
        }
        else if(y==0){
            return x;
        }
        if(x%y==0){
            return y;
        }
        if(y%x==0){
            return x;
        }
        if(x>y){
            x=x%y;
            return gcd(y,x);
        }
        else{
            y=y%x;
            return gcd(x,y);
        }
    }
    public static boolean canMeasureWater(int x, int y, int z) {
        if(z>x+y){
            return false;
        }
        int g=gcd(x,y);
        if(g!=0 && z%g==0){
            return true;
        }
        else if(g==0 && z==0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(canMeasureWater(0,0,0));
    }
}
