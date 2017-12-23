import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        while(N>0){
            N--;
            String pattern = in.nextLine();
            String text = in.nextLine();
            int[][] dfa = new int[26][pattern.length()];
            dfa[pattern.charAt(0)-'A'][0]=1;
            int lastState = 0;
            for(int X=0, i=1; i<pattern.length(); i++){
                int index = pattern.charAt(i)-'A';
                for(int j=0; j<26; j++)
                    dfa[j][i]=dfa[j][X];
                dfa[index][i]=i+1;
                X=dfa[index][X];
                lastState = X;
            }
            int count = 0;
            int state = 0;
            for(int i=0; i<text.length(); i++){
                state = dfa[text.charAt(i)-'A'][state];
                if(state==pattern.length()){
                    count++;
                    state = lastState;
                }
            }
            System.out.println(count);
        }
    }
}
