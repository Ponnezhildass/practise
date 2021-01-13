import sun.misc.CharacterEncoder;

public class Lexicograph {

    public long countWithFirstDigits(long max, long prefix) {

        long result = max>=prefix ? 1 : 0;
        long power = 10;
        prefix = power * prefix;
        while(prefix + power <= max){
            prefix *=10;
            result += power;
            power *=10;
        }
        if(prefix <= max && max <= prefix + power) {
            result += (max - prefix +1);
        }
        String s = "";
        for(char c: s.toCharArray()){

        }
        return result;

    }

    public int getKthNumber(long n, long k){
        int prefix = 1;
        int res = 0;
        long power = 1;
        while(k>0) {
            long countPrefix = countWithFirstDigits(n,prefix);
            while (k > countPrefix) {
                k -= countPrefix;
                if(k==0) return prefix;
                prefix++;
                countPrefix = countWithFirstDigits(n, prefix);
            }
            res = prefix;
            k--;
            prefix *= 10;
            power*=10;
        }
        return res;
    }

    public static void main(String []arg){
        Lexicograph lexicograph = new Lexicograph();
        int n = 681692778;
        int k = 351251360;


        //for(int i=1;i<10;i++)
            System.out.println(lexicograph.countWithFirstDigits(n,2));
        System.out.println(lexicograph.getKthNumber(n,k));

    }
}
