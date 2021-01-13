package backtracking;

import java.util.Vector;

public class HamiltonianCycle {

    int V = 5;
    public static void main(String[] args){
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle();
        hamiltonianCycle.findHamiltonian(graph1);
    }

    public void findHamiltonian(int[][] graph){
        int [] visited = new int[V];
        Vector<Integer> vector = new Vector<Integer>();
        visited[0] = 1;
        vector.add(0);
        if(findHamiltonianUtil(graph,visited,0,vector)){
            vector.add(0);
            for(int i: vector){
                System.out.print(" " + i);
            }
        }
    }

    public boolean findHamiltonianUtil(int[][] graph, int[] visited, int v, Vector<Integer> vector){

        if(vector.size()==V){
            if(graph[vector.elementAt(V-1)][0]==1)
                return true;
            else return false;
        }
        for(int i = 0; i<V;i++){
            if(isSafe(graph,visited,v,i)){
                vector.add(i);
                visited[i] = 1;
                if(findHamiltonianUtil(graph,visited,i,vector)){
                    return true;
                } else {
                    vector.remove(new Integer(i));
                    visited[i] = 0;
                }
            }
        }
        return false;
    }

    public boolean isSafe(int[][] graph, int[] visited, int i, int j){
        if(visited[j]!=1 && graph[i][j] == 1){
            return true;
        }
        else return false;
    }
}
