public class DominoRotate {

    public int minDominoRotations(int[] A, int[] B) {
        int [] candidates = {A[0], B[0]};
        for(int i=1;i<A.length;i++){
            if(candidates[0] != A[i] && candidates[0] != B[i])
            {candidates[0]= -1;}
            if(candidates[1] != A[i] && candidates[1] != B[i])
            {candidates[1]= -1;}
        }
        if(candidates[0] == -1 && candidates[1] ==-1){
            return -1;
        }

        int c0 = candidates[0] != -1 ? minDominoRotations(A,B,candidates[0]): Integer.MAX_VALUE ;
        int c1 = candidates[1] != -1 ? minDominoRotations(A,B,candidates[1]): Integer.MAX_VALUE ;

        return Math.min(c0,c1);
    }

    public int minDominoRotations(int[] A, int[] B, int c){
        int countA = 0, countB=0, l = A.length;
        for(int i=0;i<l;i++){
            if(A[i] != c ) countA++;
        }
        for(int i=0;i<l;i++){
            if(B[i] != c ) countB++;
        }
        return Math.min(countA, countB);
    }

    public static void main(String[] a){
        int []A = {1,2,1,1,1,2,2,2};
        int []B =  {2,1,2,2,2,2,2,2};


        System.out.println(new DominoRotate().minDominoRotations(A,B));
    }
}
