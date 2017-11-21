import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int getState(List<Integer> needs){
        int state = 0;
        int base = 1;
        for(int i=0; i<needs.size(); i++){
            state += needs.get(i)*base;
            base*=7;
        }
        return state;
    }
    public static int search(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int[] record){
        boolean flag = true;
        for(int i=0; i<needs.size(); i++){
            if(needs.get(i)!=0)
                flag = false;
        }
        if(flag)
            return 0;

        int state = getState(needs);
        if(record[state]!=-1)
            return record[state];

        int min = Integer.MAX_VALUE;
        out:
        for(int i=0; i<special.size(); i++){
            for(int j=0; j<needs.size(); j++){
                int v = needs.get(j)-special.get(i).get(j);
                if(v<0){
                    for(j=j-1; j>=0; j--){
                        needs.set(j, needs.get(j)+special.get(i).get(j));
                    }
                    continue out;
                }
                needs.set(j, v);
            }
            int p = search(price, special, needs, record);
            for(int j=0; j<needs.size(); j++){
                needs.set(j, needs.get(j)+special.get(i).get(j));
            }
            if(p<0)
                continue;
            p += special.get(i).get(needs.size());
            min = Math.min(p, min);
        }
        for(int i=0; i<price.size(); i++){
            int v = needs.get(i)-1;
            if(v<0)
                continue;
            needs.set(i, v);
            int p = search(price, special, needs, record);
            needs.set(i, v+1);
            if(p<0)
                continue;
            p += price.get(i);
            min = Math.min(p, min);
        }

        if(min==Integer.MAX_VALUE)
            record[state]=-2;
        else
            record[state]=min;
        return record[state];
    }
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int num = 1;
        for(int i=0; i<needs.size(); i++)
            num *=7;
        int[] record = new int[num];
        for(int i=0; i<num; i++)
            record[i] = -1;
        return  search(price, special, needs, record);
    }
    public static void main(String[] args){
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> s1 = new ArrayList<>();
        s1.add(1);
        s1.add(1);
        s1.add(0);
        s1.add(4);
        List<Integer> s2 = new ArrayList<>();
        s2.add(2);
        s2.add(2);
        s2.add(1);
        s2.add(9);
        special.add(s1);
        special.add(s2);
        List<Integer> needs = new ArrayList<>();
        needs.add(1);
        needs.add(2);
        needs.add(1);
        System.out.println(shoppingOffers(price, special, needs));
    }
}
