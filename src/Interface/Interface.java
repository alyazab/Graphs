package Interface;

import Part1.n_at_Kth_Index;
import Part2.Maze_Solve;
import Part3.Console;

import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        int Options = 0;

		while (Options != 4) {
        	clearScreen();
            
        	System.out.println("***********************************************************************************\n\n");
    		System.out.println("\t(1) Part One: Find number of people connected at kth vertices away from each other");
    		System.out.println("\t(2) Part Two: Find the right path of the runner to escape out of the maze");
    		System.out.println("\t(3) Part Three: Find the path with minimum cost for an employee to travel from city X to city Y\n");
    		System.out.println("\t(4) EXIT\n");
    		System.out.println("\tChoose a number and press ENTER:");
    		System.out.print("\t");
    		
    		Options = Scan.nextInt();
            switch (Options) {
                case 1:
                	clearScreen();
                	n_at_Kth_Index partOne = new n_at_Kth_Index();
                	partOne.activate();
					Scan.nextLine();
                	break;
                case 2:
                	clearScreen();
                	Maze_Solve Maze = new Maze_Solve();
        	        Maze.Maze_Generator();
					Scan.nextLine();
        	        break;
                case 3:
                	clearScreen();
                	Console mainConsole = new Console();
        	        mainConsole.startConsole();
					Scan.nextLine();
        	        break;
                case 4:
                	clearScreen();
                	System.out.println("\n\n\tThanks for using our program...");
                	System.out.println("\n\n\tAly Azab\t\t\t5291 \n\tAhmed Ashraf\t\t5645 \n\tMostafa Hakam\t\t5525 \n\tIslam Kadous\t\t5319 \n\tNourine Ahmed\t\t5308");
					Scan.nextLine();
                    break;
                default:
                	clearScreen();
                	System.out.println("\n\n\tINVALID OPTION");
					Scan.nextLine();
            }
        }
    }
	
	public static void clearScreen() {  
	    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	   }
}
