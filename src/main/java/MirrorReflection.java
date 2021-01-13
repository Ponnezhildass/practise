public class MirrorReflection {
    int P ;
    public int mirrorReflection(int p, int q) {
        P = p;
        double slope = (double)q/p;
        return findNext(p,q,slope);
    }


    public double nextX(double x, double y, double s, double y1){
        if(y==y1) return x;

        return x + (y-y1)/s;
    }

    public double nextY(double x, double y, double s, double x1){
        if(x==x1) return y;

        return s*x  + (y-s*x1) ;
    }

    public int findNext(double x, double y, double s){
        double nx1= nextX(x,y,s,0);
        double nx2= nextX(x,y,s,P);
        double ny1= nextY(x,y,s,0);
        double ny2= nextY(x,y,s,P);

        if(nx1 == P) return 0;
        if(nx2 == P) return 1;
        if(nx2 == 0) return 2;

        if(condition(x,nx1)){
            return findNext(nx1,0,-s);
        }
        else if(condition(x,nx2)){
            return findNext(nx2,P,-s);
        }
        else if(condition(y,ny1)){
            return findNext(0,ny1,-s);
        }
        else {
            return findNext(P,ny2,-s);
        }
    }

    public boolean condition(double old, double newV) {
        return newV >= 0 && newV<=P && newV!= old;
    }

    public static void main(String[] args){
        System.out.println(new MirrorReflection().mirrorReflection(6,5));
    }
}
