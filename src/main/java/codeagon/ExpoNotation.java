package codeagon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ExpoNotation {
    public static int[] stringToIntegerArray(String input) {
        if (input.length() == 0) {
            return new int[0];
        }
        input = input.replace(".",",");
        String[] parts = input.split(",");
        int[] output = new int[2];
        if(parts.length==0){
            output[0] = Integer.parseInt(input);
            output[1] = 0;
        } else {
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                if(part.equals("")) {
                    output[index] = 0;
                }
                else {
                    output[index] = Integer.parseInt(part);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        String out = new ExpoNotation().findExpo(line);
        System.out.print(out);

    }

    public String findExpo(String z){
        String[] strings = z.split("\\.");
        String result = "";
        if(strings.length==2){}
        else {
            if(strings[0].equals("")){

            }
            else{

            }

        }
            //result +=  "E" + Integer.toString(b);


        return result;
    }
}
