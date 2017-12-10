public class Solution {
    public static int networkDelayTime(int[][] times, int N, int K) {
        int count=1;
        boolean[] flag = new boolean[N+1];
        flag[K]=true;
        int[] path = new int[N+1];
        while(true){
            int min = Integer.MAX_VALUE;
            int pos = -1;
            for(int i=0; i<times.length; i++){
                if(flag[times[i][0]] && !flag[times[i][1]] && path[times[i][0]]+times[i][2]<min){
                    min = path[times[i][0]]+times[i][2];
                    pos = i;
                }
            }
            if(pos==-1)
                break;
            else{
                flag[times[pos][1]]=true;
                count++;
                path[times[pos][1]] = path[times[pos][0]]+times[pos][2];
            }
        }
        if(count<N)
            return -1;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<N+1; i++){
            if(max<path[i]){
                max=path[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[][] times ={{1,2,1},{2,3,2},{1,3,2}};
        networkDelayTime(times, 3, 1);
    }
}
