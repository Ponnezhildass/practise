package backtracking.Solver;

public class Winner extends CornerDoubleAvoider {
    public Winner(StatusChecker checker) {
        super(checker);
    }

    @Override
    public int[] nextStep(Move[][] board, int size) {
        int[] x = new int[2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == Move.E) {
                    board[i][j] = Move.O;
                    if (checker.checkGame(board) == GameStatus.Second) {
                        x[0] = i;
                        x[1] = j;
                        return x;
                    }
                    board[i][j] = Move.E;
                }
            }
        }

        return super.nextStep(board,size);
    }
}
