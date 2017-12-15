import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> get3(String[] singleNums, String[] doubleNums, int num) {
        List<String> result = new ArrayList<>();
        int n = num / 100;
        if(n!=0){
            result.add(singleNums[n]);
            result.add("Hundred");
        }
        n = num % 100;
        if(n!=0) {
            if (n < 20)
                result.add(singleNums[n]);
            else {
                int low = n % 10;
                int high = n / 10;
                result.add(doubleNums[high]);
                if (low != 0)
                    result.add(singleNums[low]);
            }
        }
        return result;
    }
    public static String getResult(List<String> ls){
        StringBuilder sb = new StringBuilder();
        for(String s: ls)
            sb.append(s).append(' ');
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static String numberToWords(int num) {
        if(num==0)
            return "Zero";
        String[] unit = {"Million", "Thousand"};
        String[] singleNums = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
        "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] doubleNums = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        List<String> result;
        List<String> ls;
        int n = num%1000;
        result = get3(singleNums, doubleNums, n);
        n = num/1000;
        if(n==0)
            return getResult(result);
        num = num/1000;
        n = num%1000;
        if(n!=0){
            result.add(0, "Thousand");
            ls = get3(singleNums, doubleNums, n);
            for(int i=ls.size()-1; i>=0; i--)
                result.add(0, ls.get(i));
            n = num/1000;
            if(n==0)
                return getResult(result);
        }
        num = num/1000;
        n = num%1000;
        if(n!=0){
            result.add(0, "Million");
            ls = get3(singleNums, doubleNums, n);
            for(int i=ls.size()-1; i>=0; i--)
                result.add(0, ls.get(i));
            n = num/1000;
            if(n==0)
                return getResult(result);
        }
        num = num/1000;
        n = num%1000;
        result.add(0, "Billion");
        result.add(0, singleNums[n]);

        return getResult(result);
    }
    public static void main(String[] args){

        System.out.println(numberToWords(1000000000));
    }
}
