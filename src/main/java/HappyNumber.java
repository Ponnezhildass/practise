import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Soluton {
        public boolean isHappy(int n) {
            List<Integer> list = new ArrayList();
            if(n==1) return true;
            int p = nextIteration(n);
            while(!list.contains(p)){
                if(p==1) return true;
                list.add(p);
                p = nextIteration(p);
            }
            return false;
        }

        private int nextIteration(int n){
            int output = 0;
            while(n>0){
                int i = n%10;
                output += i*i;
                i/=10;
            }
            return output;
        }
    }

    public class HappyNumber {
        public static String booleanToString(boolean input) {
            return input ? "True" : "False";
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int n = Integer.parseInt(line);

                boolean ret = new Soluton().isHappy(n);

                String out = booleanToString(ret);

                System.out.print(out);
            }
        }
    }

