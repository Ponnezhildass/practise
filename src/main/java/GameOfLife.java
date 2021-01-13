public class GameOfLife {
    public void gameOfLifeUtil(int[][] board) {
        int m = board.length ;
        if(m<1) return;
        int n = board[0].length;
        for(int i =0; i<m;i++){
            for(int j=0;j<n;j++){
                int count = noOfAlive(board,i,j,m,n);
                if( count== 3 && board[i][j] == 0)
                    board[i][j] = 2;
                if(count < 2 || count > 3){
                    if(board[i][j] ==1) board[i][j] = -1;
                    else board[i][j] = -2;
                }
            }
        }

        for(int i =0; i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]>0) board[i][j]=1;
                if(board[i][j]<0) board[i][j]=0;

            }
        }
    }

    public int noOfAlive(int[][] board, int i, int j, int m, int n){
        int count = 0;
        if(i>0){
            if(board[i-1][j]==1 || board[i-1][j]==-1)
                count++;
            if(j>0){
                if(board[i-1][j-1]==1 || board[i-1][j-1]==-1)
                    count++;
            }
            if(j<n-1){
                if(board[i-1][j+1]==1 || board[i-1][j+1]==-1)
                    count++;
            }
        }
        if(j>0){
            if(board[i][j-1]==1 || board[i][j-1]==-1)
                count++;
            if(i<m-1)
                if(board[i+1][j-1]==1 || board[i+1][j-1]==-1)
                    count++;
        }
        if(j<n-1){
            if(board[i][j+1]==1 || board[i][j+1]==-1)
                count++;
            if(i<m-1){
                if(board[i+1][j+1]==1 || board[i+1][j+1]==-1)
                    count++;
            }
        }
        if(i<m-1){
            if(board[i+1][j]==1 || board[i+1][j]==-1)
                count++;
        }
        return count;
    }

    public static void main(String [] args){
        GameOfLife gameOfLife = new GameOfLife();
        int[][] arr = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife.gameOfLifeUtil(arr);
        for(int[] a : arr){
            for(int b : a)
                System.out.print(b+" ");
            System.out.println("");
        }
    }
}
