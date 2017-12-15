import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rentseen on 17-5-3.
 */
public class Solution {
    public static int find(List<String> items,String s){
        for(int i=0;i<items.size();i++){
            if(items.get(i).equals(s)){
                return i;
            }
        }
        return -1;
    }
    public static int calcOnce(String[][] equations, double[] values, String[][] queries,List<String> items,List<Double> v,List<Integer> mark,int m){
        int count=0;
        int index=0;
        int recordCount=0;
        while(count<equations.length){
            String top=equations[index][0];
            String bottom=equations[index][1];
            int posTop=find(items,top);
            int posBottom=find(items,bottom);
            if(posTop==-1 && posBottom==-1 && count==0){
                items.add(bottom);
                mark.add(m);
                v.add(1.0);
                items.add(top);
                mark.add(m);
                v.add(values[index]);
                count++;
            }
            else if(posTop!=-1 && posBottom==-1){
                items.add(bottom);
                mark.add(m);
                v.add(v.get(posTop)/values[index]);
                count++;
            }
            else if(posBottom!=-1 && posTop==-1){
                items.add(top);
                mark.add(m);
                v.add(v.get(posBottom)*values[index]);
                count++;
            }
            else if(posTop!=-1 && posBottom!=-1 && count==0){

            }
            index=(index+1);
            if(index==equations.length){
                if(count==recordCount){
                    break;
                }
                else{
                    recordCount=count;
                }
            }
            index=index%equations.length;

        }
        return count;
    }
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        List<String> items=new ArrayList<>();
        List<Double> v=new ArrayList<>();
        List<Integer> mark=new ArrayList<>();
        int count=0;
        int m=0;
        while(count<equations.length){
            count+=calcOnce(equations,values,queries,items,v,mark,m++);
        }
        List<Double> result=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int posTop=find(items,queries[i][0]);
            int posBottom=find(items,queries[i][1]);
            if(posBottom!=-1&& posTop!=-1 && mark.get(posBottom)==mark.get(posTop)){
                result.add(v.get(posTop)/v.get(posBottom));
            }
            else{
                result.add(-1.0);
            }

        }
        double[] tmp=new double[result.size()];
        for(int i=0;i<tmp.length;i++){
            tmp[i]=result.get(i);
        }
        return tmp;
    }
    public static void main(String[] args){
        String[][] equations = {{"a","b"},{"c","d"}};
        double[] values = {1.0,1.0};
        String[][] queries = {{"a", "c"}, {"b","d"}, {"b","a"}, {"d","c"}};
        System.out.println(Arrays.toString(calcEquation(equations,values,queries)));
    }
}
