package backtracking.Solver;


public class SimpleSolver implements Solver {

    @Override
    public int[] nextStep(Move[][] board, int size) {
        int[] x = {0,0};
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]== Move.E){
                    x[0]=i;
                    x[1]=j;
                    return x;
                }
            }
        }
        return x;
    }
}
