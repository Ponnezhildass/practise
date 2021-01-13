package backtracking;

public class GraphColoring {

    int V = 4;
    public static void main(String[] args){
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };

        GraphColoring graphColoring = new GraphColoring();
        graphColoring.colorGraph(graph);
    }

    public void colorGraph(int[][] graph){
        int[] color = new int[V];

        if(colorGraphUtil(graph,color,0)){
            for (int i=0;i<V;i++){
                System.out.println(i + ": " + color[i]);
            }
        }
    }

    public boolean colorGraphUtil(int[][] graph, int[] color, int v){
        if(v == V) return true;
        for(int i=0;i<V;i++){
            color[v]=i+1;
            for(int j = 0;j<v;j++){
                if(graph[i][v] == 1 && color[i] == color[v]){
                    color[v] = 0;
                }
            }
            if(color[v]!=0) {
                return colorGraphUtil(graph,color,v+1);
            }
        }

        return false;
    }
}
