import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> stack;
    int top=-1;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayList<>();
        for(int i=nestedList.size()-1; i>=0; i--){
            NestedInteger ni = nestedList.get(i);
            if(!ni.isInteger() && ni.getList().size()==0){
                continue;
            }
            stack.add(nestedList.get(i));
            top++;
        }
    }

    @Override
    public Integer next() {
        NestedInteger ni = stack.get(top);

        while(!ni.isInteger()){
            stack.remove(top);
            top--;
            List<NestedInteger> tmp = ni.getList();
            for(int i=tmp.size()-1; i>=0; i--){
                if(!tmp.get(i).isInteger() && tmp.get(i).getList().size()==0){
                    continue;
                }
                stack.add(tmp.get(i));
                top++;
            }
            ni = stack.get(top);
        }
        stack.remove(top);
        top--;
        return ni.getInteger();
    }

    @Override
    public boolean hasNext() {
        if(stack.size()==0){
            return false;
        }
        NestedInteger ni = stack.get(top);

        while(!ni.isInteger()){
            stack.remove(top);
            top--;
            List<NestedInteger> tmp = ni.getList();
            for(int i=tmp.size()-1; i>=0; i--){
                if(!tmp.get(i).isInteger() && tmp.get(i).getList().size()==0){
                    continue;
                }
                stack.add(tmp.get(i));
                top++;
            }
            if(stack.size()>0){
                ni = stack.get(top);
            }
            else{
                break;
            }
        }
        return stack.size()>0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */