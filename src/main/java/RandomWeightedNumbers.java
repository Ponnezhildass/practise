import java.util.Random;

public class RandomWeightedNumbers {
    Random rand = new Random();
    int[] W;
    int limit;

    public RandomWeightedNumbers(int[] w) {
        W = new int[w.length];
        W[0] = w[0];
        for(int i=1;i<w.length;i++){
            W[i] += W[i-1] + w[i];
        }
        limit = W[w.length-1];
    }

    public int pickIndex() {
        int n = rand.nextInt(limit);

        return binarySearch(n+1);

    }

    private int binarySearch(int n){
        for(int i=0;i<W.length;i++){
            if(n<=W[i]) return i;
        }

        return W.length-1;
    }

    public static void main(String[] args){
        int[] w = {3,14,1,7};
        RandomWeightedNumbers numbers = new RandomWeightedNumbers(w);
        for(int i =0;i<50;i++)
            System.out.println(numbers.pickIndex());
    }
}

