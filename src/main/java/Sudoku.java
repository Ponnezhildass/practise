import java.util.ArrayList;
import java.util.List;

class sol {
    char [][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return validateRow() && validateColumn() && validateSquare();
    }

    public boolean validateRow(){
        for(int i=0; i<9; i++){
            List<Character> list = new ArrayList();
            for(int j=0; j<9 ; j++){
                if(board[i][j] != '.'){
                    if(list.contains(board[i][j]))
                        return false;
                    else list.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public boolean validateColumn(){
        for(int j=0; j<9; j++){
            List<Character> list = new ArrayList();
            for(int i=0; i<9 ; i++){
                if(board[i][j] != '.'){
                    if(list.contains(board[i][j]))
                        return false;
                    else list.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public boolean validateSquare(){
        for(int I=0;I<3;I++){
            for(int J=0; J<3; J++){
                List<Character> list = new ArrayList();
                for(int i = I*3 ; i<I*3+3;i++){
                    for(int j = J*3; j<J*3+3; j++){
                        if(list.contains(board[i][j]))
                            return false;
                        else list.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}


