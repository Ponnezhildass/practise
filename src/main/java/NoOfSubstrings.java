public class NoOfSubstrings {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int size = s.length();

        int[] a = new int[size];
        int[] b = new int[size];
        int[] c = new int[size];
        if(s.charAt(size-1)=='a')
            a[size-1] = size-1;
        if(s.charAt(size-1)=='b')
            b[size-1] = size-1;
        if(s.charAt(size-1)=='c')
            c[size-1] = size-1;

        for(int i=size-2;i>=0;i--){
            if(s.charAt(i)=='a'){a[i] = i; b[i]=b[i+1];c[i] = c[i+1];}
            else if(s.charAt(i)=='b'){a[i] = a[i+1]; b[i]=i;c[i] = c[i+1];}
            else if(s.charAt(i)=='c'){a[i] = a[i+1]; b[i]=b[i+1];c[i] = i;}
        }

        for(int i=1;i<size-2;i++){
            if(a[i]*b[i]*c[i]!=0) {
                int x = Math.max(a[i], Math.max(b[i], c[i]));
                count += (size - x);
            }
        }
        if(count>0){
            int x = Math.max(a[0], Math.max(b[0], c[0]));
            count += (size - x);
        }
        return count;
    }

    public static void main(String[] args){
        NoOfSubstrings noOfSubstrings = new NoOfSubstrings();
        System.out.println(noOfSubstrings.numberOfSubstrings("abcabc"));
    }
}
