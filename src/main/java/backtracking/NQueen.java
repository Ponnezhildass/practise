package backtracking;

public class NQueen {

    int N = 8;
    public static void main(String[] args){
        NQueen nQueen = new NQueen();
        nQueen.solve();
    }

    public void solve(){
        int [][] board = new int[N][N];
        if(solveUtil(board,0)){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }

    public boolean solveUtil(int[][] board, int r){
        if(r==N) return true;
        for(int j=0; j<N; j++){
            if(isValid(board,r,j)){
                board[r][j] = 1;
                if(solveUtil(board,r+1)) return true;
                board[r][j] = 0;
            }
        }
        return false;
    }

    public boolean isValid(int [][] board, int x, int y){
        if(x>=0 && x < N && y>=0 && y < N){
            for(int i = 0;i<N;i++){
                if(board[x][i] == 1){
                    return false;
                }
            }
            for(int i = 0;i<N;i++){
                if(board[i][y] == 1){
                    return false;
                }
            }
            for(int i = x, j = y;i<N && j<N ;i++,j++){
                if(board[i][j] == 1){
                    return false;
                }
            }
            for(int i = x, j = y;i>=0 && j>=0 ;i--,j--){
                if(board[i][j] == 1){
                    return false;
                }
            }
            for(int i = x, j = y;i<N && j>=0 ;i++,j--){
                if(board[i][j] == 1){
                    return false;
                }
            }
            for(int i = x, j = y;i>=0 && j<N ;i--,j++){
                if(board[i][j] == 1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
