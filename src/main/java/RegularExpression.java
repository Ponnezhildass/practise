public class RegularExpression {

    public static void main(String [] args){
        String s = "aab",p="c*a*b";
        RegularExpression regularExpression = new RegularExpression();
        System.out.println(regularExpression.isMatch(s,p));
    }

    public boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) return true;
        else if(p.isEmpty() || s.isEmpty() ) return false;

        if(s.charAt(0)==p.charAt(0)){
            return isMatch(s.substring(1),p.substring(1));
        } else if (p.charAt(0)=='.'){
            return isMatch(s.substring(1),p.substring(1));
        } else if (p.charAt(0)=='*'){
            for(int i=0;i<=s.length();i++){
                if(isMatch(s.substring(i),p.substring(1)))
                    return true;
            }
            return false;
        } else return false;

    }
}
