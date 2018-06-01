import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        int i=0;
        for(; i<intervals.size(); i++) {
            if(intervals.get(i).start>newInterval.start) {
                intervals.add(i, newInterval);
                if(i!=0)
                    i--;
                break;
            }
        }
        if(i==intervals.size()) {
            intervals.add(newInterval);
            i--;
        }
        for(; i<intervals.size()-1; i++) {
            if(intervals.get(i).end>=intervals.get(i+1).start) {
                if(intervals.get(i).end<intervals.get(i+1).end) {
                    intervals.get(i).end = intervals.get(i+1).end;
                }
                intervals.remove(i+1);
                i--;
            }
        }
        return intervals;
    }
    public static void main(String[] args) {

    }
}
