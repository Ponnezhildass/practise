public class Profiler {
/*
    Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.



            Hi .. i’ve joined the call


    Given output from a cpu profiler in the format

    time1 method1 ENTER
    time2 method2 ENTER
    time3 method2 EXIT
etc.
        (for example:
            10 foo ENTER
20 bar ENTER
30 baz ENTER
40 baz EXIT
50 abc ENTER
60 abc EXIT
70 bar EXIT
80 foo EXIT
    etc.)
    generate output like

    method1 elapsedTime1
    method2 elapsedTime2
    method3 elapsedTime3
    etc.

===
    interface Record {
        long getTime();
        String getName();
        Event getEvent();
    }

    enum Event { ENTER, EXIT }



}


class CpuProfiler{

    public static void main(String[] args)
    {10 foo ENTER  0
        20 bar ENTER  1
        30 baz ENTER  2
        40 baz EXIT
        50 abc ENTER
        60 abc EXIT
        70 baz ENTER
        80 baz EXIT
        90 bar EXIT
        100 foo EXIT;}

    foo
            bar
    baz
            abc
    baz


    public void profileMethods(List<Record> records){


        List<String> methodList = new ArrayList();
        Map<Integer, Record> mapMethod = new HashMap();
        Stack<Record> inputStack = new Stack();

        for(Record record: records){
            if(record.getEvent() == Event.ENTER){
                inputStack.push(record);
                methodList.add(record.getName());
                mapMethod.put(record.gethash(), method);

                // foo 10, bar 20, baz 30
            } else {
                Record temp = inputStack.pop(); //	mapMethod.get(temp.has).setTime(record.getTime()- temp.getTime()); // 10
                // baz 10 printQueue.enqueue(method);
            }
        }

        for(String key: methodList ){
            System.out.println(mapMethod.get(key).getname() + “ ” +mapMethod.get(i).gettime()));
        }

    }
}


*/
}
