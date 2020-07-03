package Part2;

public class Coordinates {
	
        int x;
        int y;
        
        Coordinates(int x,int y) {
            this.x = x;
            this.y = y;
        }
        // This function for knowing the path of the maze we are going to choose depending on where the blocks are.
        
        public Coordinates Maze_Checker(int[][] Arr,int N,Coordinates G,int[][] Visisted) {
            //The left path in the maze:
            if(G.y != 0 && Arr[G.x][G.y-1] == 0 && Visisted[G.x][G.y-1] == 0){
            G.y--;
            }
            //The right path in the maze:
            else if(G.y != N-1 && Arr[G.x][G.y+1] == 0 && Visisted[G.x][G.y+1] == 0){
                G.y++;
            }
            //The up path in the maze:
            else if(G.x!= 0 && Arr[G.x-1][G.y] == 0 && Visisted[G.x-1][G.y] == 0){
                G.x--;
            }
            //The down path in the maze:
            else if(G.x != N-1 && Arr[G.x+1][G.y] == 0 && Visisted[G.x+1][G.y] == 0){
                G.x++;
            }
            // there is no path in the maze
            else{
                return null;
                }
        return G;
        }
}