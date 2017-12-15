import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result;
        out:
        while(true){
            for(int i=0; i<asteroids.length; i++){
                if(i>0 && asteroids[i]<0 && asteroids[i-1]>0)
                    stack.push(i);
                else if(i<asteroids.length-1 && asteroids[i]>0 && asteroids[i+1]<0)
                    stack.push(i);
            }
            while(stack.size()>0){
                int x = stack.poll();
                if(asteroids[x]==0)
                    continue;
                if(asteroids[x]>0){
                    int y = x+1;
                    while(y<asteroids.length && asteroids[y]==0)
                        y++;
                    if(y==asteroids.length || asteroids[y]>0)
                        continue;
                    if(asteroids[x]>-asteroids[y]){
                        asteroids[y]=0;
                        stack.push(x);
                    }
                    else if(asteroids[x]<-asteroids[y]) {
                        asteroids[x] = 0;
                        stack.push(y);
                    }
                    else{
                        asteroids[x]=0;
                        asteroids[y]=0;
                    }
                }
                else{
                    int y = x-1;
                    while(y>=0 && asteroids[y]==0)
                        y--;
                    if(y==-1 || asteroids[y]<0)
                        continue;
                    if(-asteroids[x]>asteroids[y]){
                        asteroids[y]=0;
                        stack.push(x);
                    }
                    else if(-asteroids[x]<asteroids[y]) {
                        asteroids[x] = 0;
                        stack.push(y);
                    }
                    else{
                        asteroids[x]=0;
                        asteroids[y]=0;
                    }
                }
            }
            int count = 0;
            for(int i=0; i<asteroids.length; i++){
                if(asteroids[i]!=0)
                    count++;
            }
            result = new int[count];
            count=0;
            for(int i=0; i<asteroids.length; i++){
                if(asteroids[i]!=0)
                    result[count++]=asteroids[i];
            }
            asteroids = result;
            for(int i=0; i<asteroids.length; i++){
                if(i>0 && asteroids[i]<0 && asteroids[i-1]>0)
                   continue out;
                else if(i<asteroids.length-1 && asteroids[i]>0 && asteroids[i+1]<0)
                    continue out;
            }
            break;
        }

        return result;
    }
}
