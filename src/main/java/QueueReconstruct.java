import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class QueueReconstruct {
    public int[][] reconstructQueue(int[][] people) {

        // greedy heap solution!

        Arrays.sort(people, (a,b)->(a[0] != b[0] ? b[0]-a[0] : a[1] - b[1])); // put tallest people first, otherwise sort by their people greater (so that the tallest are in order)

        List<int[]> res = new ArrayList<>();

        // let's now add them in the sorted order, at the specific index
        // add the tallest first, then put the next level in with the appropriate amount of people on and so on -- arraylist let's us put the person in at the proper index
        for (int[] p : people) {
            res.add(p[1], p);
        }

        // convert to an array
        return res.toArray(new int[people.length][2]);
    }

    public static void main(String[] args){
        QueueReconstruct queueReconstruct = new QueueReconstruct();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        int[][] output = queueReconstruct.reconstructQueue(people);
        for(int i=0;i<people.length;i++){
            System.out.println(output[i][0] + " " + output[i][1]);
        }
    }
}
