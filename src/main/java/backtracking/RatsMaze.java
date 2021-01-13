package backtracking;

public class RatsMaze {

    int N = 4;
    int maze[][] = { { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } };
    public static void main(String[] args){
        RatsMaze ratsMaze = new RatsMaze();
        ratsMaze.solve();
    }

    public void solve(){
        int [][] sol = new int[4][4];
        sol[0][0] = 1;
        if(solveUtil(sol,0,0)){
            for(int i = 0; i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }

    public boolean solveUtil(int[][] sol, int x, int y){

        if(x == N-1 && y == N-1) return true;

        if(isValid(x+1,y)){
            sol[x][y] = 1;
            return solveUtil(sol,x+1,y);
        }else if(isValid(x,y+1)){
            sol[x][y] = 1;
            return solveUtil(sol,x,y+1);
        }else{
            sol[x][y]=0;
            return false;
        }
    }

    public boolean isValid(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N && maze[x][y]==1){
            return true;
        } else return false;
    }

}
