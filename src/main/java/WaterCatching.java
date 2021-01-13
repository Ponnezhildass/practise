import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solion {

    public int trap(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int water = 0;
        int max = height[0];
        left[0] = 0;
        for(int i=1;i<height.length;i++){
            if(height[i]>max){
                left[i]=0;
                max=height[i];
            } else {
                left[i]=max;
            }
        }
        max = height[height.length-1];
        right[height.length-1]=0;
        for(int i=height.length-2;i>=0;i--){
            if(height[i]>max){
                right[i]=0;
                max=height[i];
            } else {
                right[i]=max;
            }
        }

        for(int i=0;i<height.length;i++){
            int min = left[i]<right[i] ? left[i]: right[i];
            water += (min-height[i]);
        }
        return water;
    }
}

public class WaterCatching {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
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
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);

            int ret = new Solion().trap(height);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}