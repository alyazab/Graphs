package Part2;
import java.util.Scanner;
import java.util.Stack;

public class Maze_Solve {
	
    //This function is the main function of this part.
    public void Maze_Generator() {
        System.out.println("Please enter N (size of the matrix): ");
        
        Scanner Scan = new Scanner(System.in);
        Scanner Scan1 = new Scanner(System.in);
        
        int N = Scan.nextInt(); //size of the matrix.
        int Counter = 0;              //line counter.
        
        System.out.println("Please enter values for the maze: ");
        int[][] Arr =new int[N][N];
        
        while (Counter<N) {
            String Mat = Scan1.nextLine();
            String[] Numbers = Mat.split(" ");
            for (int Counter2 = 0; Counter2 < N ;Counter2++) {
                Arr[Counter][Counter2] = Integer.parseInt(Numbers[Counter2]);
            }
            Counter++;
        }
        
        int[][] Visited =  new int[N][N];
        Visited[N-1][N-1] = 0; 
        Stack<Coordinates> Stack = new Stack<>(); // the stack used in the DFS.
        Coordinates P = new Coordinates(0,0); // the initial coordinates of the maze:
        
        Visited[0][0] = 1;
        Stack.push(new Coordinates(P.x,P.y));
        while(Visited[N-1][N-1] == 0) {
            P = P.Maze_Checker(Arr,N,P,Visited);
            if(P == null) {
                Stack.pop();
                if(Stack.isEmpty()) {
                    System.out.println("No Path Found");
                    break;
                }
                Coordinates Q = Stack.peek();
                P = new Coordinates(Q.x,Q.y);
            }
            else {
            	Visited[P.x][P.y] = 1;
                Stack.push(new Coordinates(P.x,P.y));
            }
        }
        // we used another stack to save the right path of the maze in the right order.
        Stack<Coordinates> New_Stack = new Stack<>();
        while(!Stack.isEmpty()) {
        	New_Stack.push(Stack.pop());
        }
        while(!New_Stack.isEmpty()) {
            P = New_Stack.pop();
            System.out.print("("+ P.x + "," + P.y + ")");
        }
        System.out.println();
    }
}
