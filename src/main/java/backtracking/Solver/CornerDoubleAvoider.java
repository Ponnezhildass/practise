package backtracking.Solver;

public class CornerDoubleAvoider extends CenterDoubleAvoider{

    public CornerDoubleAvoider(StatusChecker checker) {
        super(checker);
    }

    @Override
    public int[] nextStep(Move[][] board, int size) {
        int mid = (size-1)/2;
        if(board[0][size-1] == Move.X && board[size-1][0] == Move.X && board[mid][mid] == Move.O && board[0][1] == Move.E){
            return new int[] {0,1};
        } else return super.nextStep(board,size);

    }
}
