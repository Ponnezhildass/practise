public class NoOfIslands {
    int[] x = {-1,0,0,1};
    int[] y = {0,-1,1,0};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m==0) return 0;
        n = grid[0].length;
        int count = 0;
        int [][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int[][] visited, int i, int j){
        visited[i][j] = 1;
        for(int k=0;k<4;k++){
            if(isSafe(grid,visited,i,j,k))
                dfs(grid,visited,i+x[k],j+y[k]);
        }
    }

    public boolean isSafe(char[][] grid, int[][] visited, int i, int j, int index){
        int a = i+x[index];
        int b = j+y[index];
        if(a>=0 && b >=0 && a<m &&b<n)
            return visited[a][b] != 1 && grid[a][b] == '1';
        else return false;
    }

    public static void main(String[] args){
        NoOfIslands noOfIslands = new NoOfIslands();
        char [][] land = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(noOfIslands.numIslands(land));
    }
}
