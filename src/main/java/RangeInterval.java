import java.util.ArrayList;
import java.util.List;

public class RangeInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) {
            int[][] output = new int[1][2];
            output[0][0]= newInterval[0];
            output[0][1]= newInterval[1];

            return output;
        }
        int insert = search(intervals, newInterval[0]);
        List<Integer[]> list = new ArrayList<Integer[]>();

        for(int i=0;i<insert-1;i++){
            Integer[] integers = {intervals[i][0],intervals[i][1]};
            list.add(integers);
        }
        int p = Math.max(insert-1,0);
        int low = Math.min(intervals[p][0],newInterval[0]);
        int high = Math.max(intervals[p][1],newInterval[1]);
        if(intervals[p][1] < newInterval[0]){
            Integer[] integers = {intervals[p][0],intervals[p][1]};
            list.add(integers);
            low = newInterval[0];
            p++;
            if(p<intervals.length) {
                while(newInterval[1] >= intervals[p][0]){
                    high = intervals[p][1];
                    p++;
                    if(p>=intervals.length) break;
                }
                Integer[] ints = {low,high};
                list.add(ints);
            } else {
                Integer[] ints = {newInterval[0],newInterval[1]};
                list.add(ints);
            }
        } else if(intervals[p][1] >= newInterval[1]) {
            Integer[] integers = {low,intervals[p][1]};
            list.add(integers);
            p++;
        } else {
            p++;
            if(p<intervals.length){
                while(newInterval[1] >= intervals[p][0]){
                    high = intervals[p][1];
                    p++;
                    if(p>=intervals.length) break;
                }
                Integer[] integers = {low,high};
                list.add(integers);
            } else {
                Integer[] integers = {low,high};
                list.add(integers);
            }
        }


        for(int i = p; i<intervals.length;i++){
            Integer[] integers = {intervals[i][0],intervals[i][1]};
            list.add(integers);
        }

        int[][] output = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            output[i][0]= list.get(i)[0];
            output[i][1]= list.get(i)[1];
        }
        return output;
    }

    public int search(int[][] intervals, int insert){

        for(int i=0 ;i<intervals.length;i++){
            if(intervals[i][0] >= insert){
                return i;
            }
        }

        return intervals.length-1;
    }

    public static void main(String[] args){
        int[][] input = {{1,5}};
        int[] insert = {0,0};
        int[][] output = new RangeInterval().insert(input,insert);
        for(int[] ele: output) {
            System.out.println( ele[0] + " " + ele[1]);
        }
    }
}
