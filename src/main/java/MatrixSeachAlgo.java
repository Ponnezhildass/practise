import java.util.PriorityQueue;

public class MatrixSeachAlgo {

    class Coordinate {
        int x, y;

        public Coordinate(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        boolean visited[][] = new boolean[n][n];
        PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>((a,b)->(matrix[a.x][a.y] - matrix[b.x][b.y]));
        priorityQueue.add(new Coordinate(0,0));
        visited[0][0] = true;
        int count = 1;
        while(!priorityQueue.isEmpty() && count <k){
            Coordinate a = priorityQueue.poll();
            count++;
            if(a.x<n-1 && !visited[a.x + 1][a.y]){
                priorityQueue.add(new Coordinate(a.x+1,a.y));
                visited[a.x+1][a.y]=true;
            }
            if(a.y<n-1 && !visited[a.x][a.y + 1]){
                priorityQueue.add(new Coordinate(a.x,a.y+1));
                visited[a.x][a.y+1]=true;
            }
        }

        while(k > count ){
            priorityQueue.poll();
            count++;
        }
        Coordinate a = priorityQueue.poll();
        return matrix[a.x][a.y];
    }

    public static void main(String[] args){
        int[][] mat = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };

        MatrixSeachAlgo matrixSeachAlgo = new MatrixSeachAlgo();
        for(int i =1;i<10;i++) {
            System.out.println(i + ": " + matrixSeachAlgo.kthSmallest(mat,i));
        }
    }
}
