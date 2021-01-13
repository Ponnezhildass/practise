package backtracking;

public class SudokuSolver {

    int N = 3;

    public static void main(String[] args){
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solve(board);
    }


    public void solve(int[][] board){
        if(solveUtil(board,0,0)){
            for(int i = 0;i<N*N;i++){
                for(int j= 0; j<N*N;j++){
                    System.out.print(" " + board[i][j]);
                }
                System.out.println("");
            }
        }
    }

    public boolean solveUtil(int[][] board, int x, int y){
        if(x == 8 && y == 8) return true;

        for(int k=1;k<10;k++){
            if(board[x][y] != 0) {
                if(x!=8){
                    return solveUtil(board,x+1,y);
                } else {
                    return solveUtil(board,0,y+1);
                }
            }
            else if(isValid(board,x,y,k)){
                board[x][y] = k;
                boolean result = false;
                if(x!=8){
                    result = solveUtil(board,x+1,y);
                } else {
                    result = solveUtil(board,0,y+1);
                }
                if(result){
                    return true;
                } else {
                    board[x][y] = 0;
                }
            }
        }
        return false;
    }

    public boolean isValid(int[][] board, int x, int y, int v){

        if(board[x][y]!=0) return false;
        for(int i=0; i<9;i++){
            if(board[x][i] == v) return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][y] == v) return false;
        }

        int a = x/3, b = y/3;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[a*3+i][b*3+j] == v) return false;
            }
        }
        return true;
    }

}
