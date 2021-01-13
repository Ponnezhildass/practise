import java.util.LinkedList;

public class ZigZagPoster {
    public String convert(String s, int numRows) {
        LinkedList<Integer> queue = new LinkedList();
        String output = "";
        if(numRows==1) return s;
        int interleave = ((numRows-1) * 2) ;
        int fit = 0;
        while(s.length()%interleave != 0){
            s = s+ "#";
            fit++;
        }
        for(int i =0 ;i<s.length(); i+=interleave){
            if(s.charAt(i)!='#')
                output += s.charAt(i);
            if(i!=0){
                if(queue.peekLast()!=i-1)
                    queue.add(-i+1);
            }
            if(i<s.length()-1)
                queue.add(i+1);
        }
        if(s.length()%interleave == 0 && interleave!=2) queue.add(-s.length()+1);
        while(output.length() + fit != s.length()){
            int a = queue.poll();
            if(a<0){
                a = -a;
                if(s.charAt(a)!='#')
                    output += s.charAt(a);
                if(queue.peekLast()!=a-1)
                    queue.add(-a+1);
            } else {
                if(s.charAt(a)!='#')
                    output += s.charAt(a);
                if(a<s.length()-1)
                    queue.add(a+1);
            }
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println(new ZigZagPoster().convert("PAYPALISHIRING",3));
        int mod = 10^9 + 7 ;
        System.out.println(mod);
    }
}
