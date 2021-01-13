package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Lexicograph {

    public static int N;
    public static void main(String[] args){
        int[] nos = {1,2,3};
        N = nos.length;
        Lexicograph lexicograph = new Lexicograph();
        lexicograph.printInLexicographOrder(nos);
    }

    public void printInLexicographOrder(int[] nos){
        List<List<Integer>> outputList = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        for(int i : nos){
            temp.add(i);
        }
        outputList.add(temp);
        findNext(temp,outputList);

        for(List<Integer> list : outputList){
            for(Integer i : list)
                System.out.println(i);
        }
    }


    public void findNext(List<Integer> current, List<List<Integer>> list){
        List<Integer> temp = new ArrayList<Integer>();
        int i =0;
        for(;i<N-1;i++){

        }

    }
}
