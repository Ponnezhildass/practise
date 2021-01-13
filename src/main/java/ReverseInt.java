public class ReverseInt {
    public int reverse(int x) {
        int rev = 0 ;
        while(x!=0){
            if((rev*10)/10 != rev) {return 0;}
            rev = rev*10 + x%10;
            x /=10;
        }
        return rev;
    }

    public static void main(String[] args){
        ReverseInt reverseInt = new ReverseInt();
        System.out.println(reverseInt.reverse(1534236469));
    }
}
