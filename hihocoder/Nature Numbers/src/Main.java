import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        long N = in.nextLong();

        if(N<=9){
            System.out.println(N);
            return;
        }
        long base = 100;
        int length = 2;
        long count = 9;
        long step;

        while(true){
            step = (base-base/10)*length;
            if(N>count+step){
                base *= 10;
                length++;
                count += step;
            }
            else if(N==count+step){
                System.out.println(9);
                break;
            }
            else {
                long number = base/10 + (N-count-1)/length;
                long digit = (N-count-1)%length+1;
                for(long i=0; i<length-digit; i++){
                   number /= 10;
                }
                System.out.println(number%10);
                break;
            }
        }
    }
}
