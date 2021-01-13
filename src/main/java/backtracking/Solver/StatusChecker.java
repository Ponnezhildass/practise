package backtracking.Solver;

public class StatusChecker {

    int size;

    public StatusChecker(int size) {
        this.size = size;
    }

    public boolean isRowComplete(Move[][] board, int row){
        Move x = board[row][0];
        if(x==Move.E) return false;
        for(int i = 1;i<size;i++){
            if(board[row][i]!= x) return false;
        }
        return true;
    }

    public boolean isColumnComplete(Move[][] board, int column){
        Move x = board[0][column];
        if(x==Move.E) return false;
        for(int i = 1;i<size;i++){
            if(board[i][column]!= x) return false;
        }
        return true;
    }

    public boolean isDiagonalComplete(Move[][] board){
        Move x = board[0][0];
        if(x==Move.E) return false;
        for(int i = 1;i<size;i++){
            if(board[i][i]!= x) return false;
        }
        return true;

    }

    public boolean isOppDiagonalComplete(Move[][] board){
        Move x = board[0][size-1];
        if(x==Move.E) return false;
        for(int i=1;i<size;i++) {
            if (board[i][size-i-1] != x) return false;
        }
        return true;
    }

    public boolean isFull(Move[][] board){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == Move.E)
                    return false;
            }
        }
        return true;
    }

    public GameStatus checkGame(Move[][] board){
        for(int i = 0;i<size;i++){
            if(isRowComplete(board,i)){
                return board[i][0] == Move.X ? GameStatus.First : GameStatus.Second;
            }
            if(isColumnComplete(board,i)){
                return board[0][i] == Move.X ? GameStatus.First : GameStatus.Second;
            }
        }
        if(isDiagonalComplete(board)){
            return board[0][0] == Move.X ? GameStatus.First : GameStatus.Second;
        }
        else if(isOppDiagonalComplete(board)){
            return board[0][size-1] == Move.X ? GameStatus.First : GameStatus.Second;
        } else if(isFull(board)){
            return GameStatus.Draw;
        } else
            return GameStatus.GoingOn;
    }

}
