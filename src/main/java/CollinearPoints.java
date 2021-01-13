public class CollinearPoints {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n<2) return n;
        int max = 2;
        for(int i=0;i<n-2;i++){
            for(int j= 0;j!=i && j<n;j++){
                if(points[i][0]==points[j][0] && points[i][1]==points[j][1]) continue;
                int s = 2;
                for(int k=0;k<n && k!=i && k!=j;k++){
                    if(isInLine(points[i],points[j],points[k])){
                        s++;
                        if(s>max) max =s ;
                    }
                }
            }
        }
        int duplicates = 1;
        for(int i=0;i<n-1;i++){
            int s = 1;
            for(int j=i+1;j<n;j++){
                if(points[i][0]==points[j][0] && points[i][1]==points[j][1]){
                    s++;
                    if(s>duplicates) duplicates =s;
                }
            }
        }
        return Math.max(max,duplicates);
    }


    public boolean isInLine(int[] a, int [] b, int[] c ){

        long x = (((long)(a[0]-b[0])*(long)(b[1]-c[1])) - (long)(a[1]-b[1])*(long)(b[0]-c[0]));

        return x ==0 ;
    }

    public static void main(String [] args){
        CollinearPoints collinearPoints = new CollinearPoints();
        int[][] arr = {{1,1},{2,2},{3,3}};
        System.out.println(collinearPoints.maxPoints(arr));
    }
}
