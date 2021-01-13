public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] bullArray = new int[secret.length()];
        return  findBull(secret,guess,bullArray) + "A" + findCows(secret,guess,bullArray) + "B";
    }

    public int findBull(String secret, String guess, int[] bullArray){
        int bulls =0 ;
        for(int i =0 ;i <secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                bullArray[i]++;
             }
        }

        return bulls;
    }

    public int findCows(String secret, String guess, int[] bullArray){
        int cows = 0;
        int[] digitsInGuess = new int[10];
        int[] countInSecret = new int[10];

        for(int i=0;i<guess.length();i++){
            int v = Integer.parseInt(String.valueOf(guess.charAt(i)));
            digitsInGuess[v]++;
        }

        for(int i=0;i<secret.length();i++){
            if(bullArray[i] == 0){
                int v = Integer.parseInt(String.valueOf(secret.charAt(i)));
                countInSecret[v]++;
            }
        }

        for(int i=0;i<10;i++){
            cows += Math.min(digitsInGuess[i],countInSecret[i]);
        }

        return cows;
    }

    public static void main(String[] a){
        String string1 = "1807";
        String string2 = "7810";
        System.out.println(new BullsAndCows().getHint(string1,string2));
    }
}
