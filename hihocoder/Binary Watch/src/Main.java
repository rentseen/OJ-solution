import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String getTime(int[] nums){
        int hour=0;
        int minute=0;
        int base=1;
        for(int i=4; i>=0; i--){
            hour += base*nums[i];
            base *= 2;
        }
        base=1;
        for(int i=10; i>=5; i--){
            minute += base*nums[i];
            base *= 2;
        }
        StringBuilder sb = new StringBuilder();
        if(hour<10){
            sb.append(0);
        }
        sb.append(hour);
        sb.append(':');
        if(minute<10){
            sb.append(0);
        }
        sb.append(minute);
        return sb.toString();
    }
    public static int getHour(int[] nums){
        int hour=0;
        int base=1;
        for(int i=4; i>=0; i--){
            hour += base*nums[i];
            base *= 2;
        }
        return hour;
    }
    public static int getMinute(int[] nums){
        int minute=0;
        int base=1;
        for(int i=10; i>=5; i--){
            minute += base*nums[i];
            base *= 2;
        }
        return minute;
    }
    public static void dfs(int x, int count, int n, int[] nums, List<String> result){
        if(count==x){
            if(getHour(nums)<24 && getMinute(nums)<60){
                result.add(getTime(nums));
            }
        }
        else if(n<0)
            return;
        else{
            nums[n]=1;
            dfs(x, count+1, n-1, nums, result);
            nums[n]=0;
            dfs(x, count, n-1, nums, result);
        }
    }
    public static void main(String[] args){
        List<String> result = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int[] nums = new int[11];
        dfs(x, 0, 10, nums, result);
        String[] can=new String[result.size()];
        can = (String[])result.toArray(can);
        Arrays.sort(can);
        for(int i=0; i<can.length; i++){
            System.out.println(can[i]);
        }
    }
}
