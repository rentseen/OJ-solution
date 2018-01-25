public class Solution {
    public static boolean validUtf8(int[] data) {
        int len = data.length;
        boolean[][] binary = new boolean[len][8];
        for(int i = 0; i<len; i++){
            int num = data[i];
            for(int j = 7; j>=0; j--){
                binary[i][j] = num%2 > 0;
                num = num/2;
            }
        }
        int state = 0;
        //0 初始
        //非0 计数
        for(int i=0; i<len; i++){
            if(state == 0){
                if(!binary[i][0])
                    continue;
                for(int j=0; j<8; j++){
                    if(binary[i][j])
                        state++;
                    else{
                        state--;
                        break;
                    }
                }
                if(state==8 || state==0)
                    return false;
                if(state>3)
                    return false;
            }
            else {
                if(binary[i][0] && !binary[i][1]){
                    state--;
                }
                else
                    return false;
            }
        }
        if(state==0)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        System.out.println(validUtf8(new int[]{250,145,145,145,145}));
    }
}
