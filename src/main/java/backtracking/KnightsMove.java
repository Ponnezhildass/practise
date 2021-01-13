package backtracking;

public class KnightsMove {

    int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2}; ;
    int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    int N = 8;
    public static void main(String[] args){
        KnightsMove knightsMove = new KnightsMove();
        knightsMove.solve();
    }

    public void solve(){
        int [][] chess = new int[N][N];
        for (int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                chess[i][j] = -1;
            }
        }
        chess[0][0] = 0;
        if(solveUtil(chess,1,0,0)){
            for(int i=0; i<N;i++){
                for(int j=0; j<N; j++){
                    System.out.print(chess[i][j] + "  ");
                }
                System.out.println("");
            }
        }

    }

    public boolean solveUtil(int [][] chess, int moveId, int x, int y){

        if(moveId==N*N) return true;
        for(int i=0;i<N;i++){
            if(isValid(chess,x,y,xMove[i],yMove[i])){
                chess[x+xMove[i]][y+yMove[i]] = moveId;
                if(solveUtil(chess,moveId+1,x+xMove[i],y+yMove[i])){
                    return true;
                } else {
                    chess[x+xMove[i]][y+yMove[i]] = -1;
                }
            }
        }
        return false;
    }

    public boolean isValid(int [][] chess, int x, int y, int moveX, int moveY){
        if(x+moveX >= 0 && x+moveX < N && y+moveY >=0 && y+moveY < N && chess[x+moveX][y+moveY] == -1)
            return true;
        else return false;
    }
}
