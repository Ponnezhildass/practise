public class RottenOrange {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return -1;
        int count =0;
        while(!areAllOrangesRot(grid)){
            count++;
            moveTime(grid);
        }
        return count;

    }

    private boolean areAllOrangesRot(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    return false;
            }
        }
        return true;
    }

    private void moveTime(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    if(i>0)  grid[i-1][j] = - grid[i-1][j];
                    if(i<grid.length-1) grid[i+1][j] = - grid[i+1][j];
                    if(j>0) grid[i][j-1] = - grid[i][j-1];
                    if(j<grid[0].length-1) grid[i][j+1] = - grid[i][j+1];

                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j] < 0) grid[i][j] = 2;
            }
        }
    }

    public static void main(String[] a){
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new RottenOrange().orangesRotting(arr));
    }
}
