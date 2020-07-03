package Part3;

import java.util.ArrayList;
import java.util.Comparator;

public class graph {

    private final int M;
    public pair[][] graphMatrix;

    public graph(int size, int M) {
        this.graphMatrix = new pair[size][size];
        this.M = M;
    }

    public ArrayList<Integer> findNeighbors(int Node){
        ArrayList<Integer> neighbors = new ArrayList<>();
        for(int i = 0 ; i < graphMatrix[0].length ; i++){
            if(graphMatrix[Node][i] != null)
                neighbors.add(i);
        }
        return neighbors;
    }

    public void configGraph(int x, int y, int w, int z){
        pair costAndTime = new pair(z + ((w) * M), w);
        setTotalCost(x, y, costAndTime);
    }

    public void setTotalCost(int A, int B, pair costAndTime){
        graphMatrix[A][B] = costAndTime;
    }
}

class pair implements Comparator<pair> {
    int totalCost, time;

    public pair(int totalCost, int time) {
        this.totalCost = totalCost;
        this.time = time;
    }

    @Override
    public int compare(pair pair1, pair pair2) {
        if(pair1.totalCost < pair2.totalCost)
            return -1;
        else if (pair2.totalCost < pair1.totalCost)
            return 1;
        return 0;
    }
}