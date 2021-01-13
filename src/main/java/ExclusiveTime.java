import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int lastSeen = 0;
        Stack<Integer> prevIndex = new Stack();
        String prevOp = "";
        int[] timeSpent = new int[n];
        for(String string : logs){
            String[] s = string.split(":", 3);
            int index = Integer.valueOf(s[0]);
            switch(s[1]){
                case "start": int t = Integer.valueOf(s[2])-lastSeen  ;
                    lastSeen =Integer.valueOf(s[2]);
                    if(!prevIndex.isEmpty())
                        timeSpent[prevIndex.peek()] += t;
                    prevIndex.push(index);break;
                case "end":
                    int t1 = Integer.valueOf(s[2])-lastSeen ;
                    if(prevOp.equalsIgnoreCase("start")) t1++;
                    lastSeen =Integer.valueOf(s[2]); timeSpent[index] += t1;
                    prevIndex.pop();
                    break;
            }
            prevOp = s[1];
        }
        return timeSpent;

    }

    public static void main (String[] args){
        ExclusiveTime exclusiveTime = new ExclusiveTime();
        int n = 1;
        String[] list =  {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        for(int i : exclusiveTime.exclusiveTime(n, Arrays.asList(list))){
            System.out.println(i);
        }
    }
}
