public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        while(n!=0){
            result = result*2 +  n % 2;
            n = n/2;
        }

        return result;
    }

    public static void main(String[] args){
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(  1073741824 ));
    }
}
