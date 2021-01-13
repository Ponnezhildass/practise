package backtracking.Solver;

public class CenterCapture extends DefeatAvoider {
    public CenterCapture(StatusChecker checker) {
        super(checker);
    }

    @Override
    public int[] nextStep(Move[][] board, int size) {
        int mid = (size-1)/2;
        if(board[mid][mid] == Move.E){
            return new int[]{mid,mid};
        }
        else return super.nextStep(board,size);
    }
}
