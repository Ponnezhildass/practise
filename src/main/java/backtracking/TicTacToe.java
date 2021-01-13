package backtracking;

import backtracking.Solver.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    private Move [][] ticTacToeboard;
    private int size = 3;
    private StatusChecker checker ;

    private Solver solver;

    public void nextStep(){
       int[] m = solver.nextStep(ticTacToeboard,size);
       ticTacToeboard[m[0]][m[1]] = Move.O;
    }

    public static void main(String[] args) throws IOException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.checker = new StatusChecker(ticTacToe.size);
        ticTacToe.ticTacToeboard = new Move[][]{{Move.E,Move.E,Move.E},{Move.E,Move.E,Move.E},
                {Move.E,Move.E,Move.E}};


        ticTacToe.solver = new Winner(ticTacToe.checker);


        while(ticTacToe.checker.checkGame(ticTacToe.ticTacToeboard)==GameStatus.GoingOn) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String []a = in.readLine().split(",");
            if(a.length!=2) {
                System.err.println("Not a valid input!!");
                continue;
            }
            int i = Integer.parseInt(a[0]) - 1;
            int j = Integer.parseInt(a[1]) - 1;
            if(ticTacToe.ticTacToeboard[i][j] != Move.E) {
                System.err.println("Spot not empty !! try another spot");
                continue;
            } else {
                ticTacToe.ticTacToeboard[i][j] = Move.X;
                if(ticTacToe.checker.checkGame(ticTacToe.ticTacToeboard)==GameStatus.GoingOn){
                    ticTacToe.nextStep();
                } else {
                    break;
                }
            }
            ticTacToe.printGame();
        }
        GameStatus g = ticTacToe.checker.checkGame(ticTacToe.ticTacToeboard);
        if(g != GameStatus.Second)
            ticTacToe.printGame();
        if(g == GameStatus.Draw){
            System.out.println("Game is a draw !!!");
        } else {
            System.out.println(g +" player is the winner !!!");
        }
    }

    public void printGame(){
        for(int i =0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(ticTacToeboard[i][j] + " ");
            }
            System.out.println("");
        }
    }

}


