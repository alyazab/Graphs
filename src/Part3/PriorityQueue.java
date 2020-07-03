package Part3;

import java.util.ArrayList;

public class PriorityQueue {
    public ArrayList<pQueuePair> list;

    public PriorityQueue() {
        list = new ArrayList<>();
    }

    public int exist(int x){
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i).node == x)
                return i;
        }
        return -1;
    }

    public int getMin(){
        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i).totalCost < min) {
                min = list.get(i).totalCost;
                index = i;
            }
        }
        return index;
    }
}

class pQueuePair implements Comparable<pQueuePair> {
    int totalCost, node;

    public pQueuePair(int totalCost, int node) {
        this.totalCost = totalCost;
        this.node = node;
    }

    @Override
    public int compareTo(pQueuePair p) {
        if(totalCost < p.totalCost)
            return -1;
        else if (p.totalCost < totalCost)
            return 1;
        return 0;
    }
}
