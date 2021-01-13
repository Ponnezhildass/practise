public class LastWord {

    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if(strings.length == 0) return 0;
        return strings[strings.length-1].length();

    }

    public static void main(String[] args){
        String sentence = "this is a sentence";
        System.out.println(new LastWord().lengthOfLastWord(sentence));
    }
}
