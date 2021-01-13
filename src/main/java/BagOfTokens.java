import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        if(tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int pointerMin = 0, pointerMax = tokens.length-1;
        int score = 0;
        int maxScore = 0;
        while(pointerMin <= pointerMax){
            while(P>=tokens[pointerMin]){
                score+=1;
                maxScore = Math.max(maxScore,score);
                P-=tokens[pointerMin];
                pointerMin++;
                if(pointerMin > pointerMax) break;
            }
            if(score>0){
                score--;
                P+=tokens[pointerMax];
                pointerMax--;
            } else if(P<tokens[pointerMin]){
                break;
            }
        }

        return maxScore;

    }

    public static void main(String[] args){
        BagOfTokens bagOfTokens = new BagOfTokens();
        int[] tokens = {100,200,300,400};
        System.out.println(bagOfTokens.bagOfTokensScore(tokens,200));
    }
}

