package codeagon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class SplitTeam{



}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(" ");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String no = in.readLine();
        line = in.readLine();
        int[] input = stringToIntegerArray(line);
        String out = String.valueOf(new MainClass().findNoTeam(input));
        System.out.print(out);

    }

    public int findNoTeam(int [] input){
        int result =0;
        int noOfOnes = 0;
        int noOftwos = 0;
        for(int i=0;i<input.length;i++){
            if(input[i]==1){
                if(noOftwos>0){
                    result++;
                    noOftwos--;
                }else{
                    noOfOnes++;
                }
            } else {
                if(noOfOnes>0) {
                    result++;
                    noOfOnes--;
                } else {
                    noOftwos++;
                }
            }
        }
        while(noOftwos>0){
            if(noOfOnes>0){
                noOfOnes--;
                result++;
            }else {break;}
        }
        result+=(noOfOnes/3);
        return result;
    }
}
