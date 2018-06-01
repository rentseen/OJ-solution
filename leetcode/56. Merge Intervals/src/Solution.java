import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    public void sort(List<Interval> intervals, int low, int high) {
        if(low>=high)
            return;
        Interval k = intervals.get(low);
        int l = low;
        int h = high;
        while(l<h) {
            while(l<h && intervals.get(h).start>=k.start) {
                h--;
            }
            if(l<h) {
                intervals.set(l++, intervals.get(h));
            }
            while(l<h && intervals.get(l).start<k.start) {
                l++;
            }
            if(l<h) {
                intervals.set(h--, intervals.get(l));
            }
        }
        intervals.set(l, k);
        sort(intervals, low, l-1);
        sort(intervals, l+1, high);
    }
    public List<Interval> merge(List<Interval> intervals) {
        sort(intervals, 0, intervals.size()-1);
        for(int i=0; i<intervals.size()-1; i++) {
            if(intervals.get(i).end>=intervals.get(i+1).start) {
                if(intervals.get(i).end<intervals.get(i+1).end)
                    intervals.get(i).end = intervals.get(i+1).end;
                intervals.remove(i+1);
                i--;
            }
        }
        return intervals;
    }
}
