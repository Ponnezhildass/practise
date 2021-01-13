package backtracking.Solver;

public class CenterDoubleAvoider extends CenterCapture{

    public CenterDoubleAvoider(StatusChecker checker) {
        super(checker);
    }

    @Override
    public int[] nextStep(Move[][] board, int size) {
        int mid = (size-1)/2;

        if(board[mid][mid] == Move.X && board[size-1][size-1] == Move.X && board[0][size-1] == Move.E){
            return new int[]{0,size-1};
        } else return super.nextStep(board,size);
    }
}
