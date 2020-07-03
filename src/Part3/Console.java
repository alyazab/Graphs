package Part3;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    private graph mainGraph;

    public void fillRoutes(int n) {
        System.out.println("Please enter source, destination, time, and cost for each route:");

        int i, x, y, w, z;
        Scanner myObj = new Scanner(System.in);

        for(i = 0; i < n; i++) {

            x = myObj.nextInt();
            y = myObj.nextInt();
            w = myObj.nextInt();
            z = myObj.nextInt();

            mainGraph.configGraph(x-1 , y-1, w, z);
        }
    }

    public void startConsole() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Please enter amount M:");
        int m = myObj.nextInt();

        System.out.println("Please enter number of cities:");
        int nbCities = myObj.nextInt();

        System.out.println("Please enter number of routes:");
        int nbRoutes = myObj.nextInt();

        mainGraph = new graph(nbCities, m);
        fillRoutes(nbRoutes);

        System.out.println("Please enter source city:");
        int source = myObj.nextInt() - 1;

        System.out.println("Please enter destination city:");
        int destination = myObj.nextInt() - 1;

        dijkstraAlg DA = new dijkstraAlg();
        DA.dijkstra(mainGraph, source, destination, m);

        ArrayList<Integer> path = DA.getPath(source, destination);
        System.out.println("Path is: ");
        for (Integer i : path) {
            System.out.print(" " + (i + 1));
        }

        int printCost, printTime;
        printCost = printTime = 0;

        for(int i = 0; i < path.size() - 1 ; i++){
            printCost += mainGraph.graphMatrix[path.get(i)][path.get(i+1)].totalCost;
            printTime += mainGraph.graphMatrix[path.get(i)][path.get(i+1)].time;
            if(i > 0){
                printCost += m;
                printTime += 1;
            }
        }
        System.out.println("\nTotal time " + printTime + " hours");
        System.out.println("Total cost = " + printCost + " $\n");
    }
}