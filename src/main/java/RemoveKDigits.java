public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        String s = num;
        for(int i=0;i<k;i++)
            s = removeOneDigit(s);
        StringBuilder str = new StringBuilder(s);
        while(str.length()>0 && str.charAt(0)=='0') str.deleteCharAt(0);
        return str.toString();
    }

    public String removeOneDigit(String num){
        StringBuilder str = new StringBuilder(num);
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) > str.charAt(i+1)){
                str.deleteCharAt(i);
                return str.toString();
            }
        }
        return str.deleteCharAt(str.length()-1).toString();
    }

    public static void main(String[] args){
        String input = "1432219";
        System.out.println(new RemoveKDigits().removeKdigits(input,3));
    }
}
