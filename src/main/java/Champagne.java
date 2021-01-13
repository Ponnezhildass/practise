public class Champagne {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int total = (query_row+1) * (query_row) / 2;
        if(poured<total || poured == 0) return 0;
        poured-=total;
        double d = (double)poured/query_row;
        if(query_glass == 0 || query_glass == query_row){
            d/=2;
        }

        return d > 1 ? 1 : d;
    }

    public static void main(String[] args){
        System.out.println(new Champagne().champagneTower(25,6,1));
    }
}
