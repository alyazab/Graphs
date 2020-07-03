package Part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class dijkstraAlg {

    private final Map<Integer, Integer> hashmap;
    private final PriorityQueue Queue;
    private final ArrayList<Integer> visited;

    private boolean found;

    public dijkstraAlg(){
        hashmap = new HashMap<>();
        Queue = new PriorityQueue();
        visited = new ArrayList<>();

        found = false;
    }

    private boolean isVisited(int in){
        for (Integer integer : visited) {
            if (in == integer)
                return true;
        }
        return false;
    }

    public void dijkstra(graph cities, int source, int destination, int M){
        int factor;
        int temp, indexOfCurrent;
        Queue.list.add(new pQueuePair(0, source));
        do{
            indexOfCurrent = Queue.getMin();
            pQueuePair current = Queue.list.get(indexOfCurrent);
            visited.add(current.node);
            ArrayList<Integer> neighbors = cities.findNeighbors(current.node);
            Queue.list.remove(indexOfCurrent);
            for (Integer neighbor : neighbors) {
                if (isVisited(neighbor))
                    continue;
                temp = Queue.exist(neighbor);
                if (neighbor == destination)
                    factor = 0;
                else
                    factor = 1;
                if (temp != -1) {
                    if (current.totalCost + cities.graphMatrix[current.node][neighbor].totalCost + (M * factor) < Queue.list.get(temp).totalCost) {
                        Queue.list.get(temp).totalCost = current.totalCost + cities.graphMatrix[current.node][neighbor].totalCost + (M * factor);
                        hashmap.put(neighbor, current.node);
                    }
                } else {
                    Queue.list.add(new pQueuePair(current.totalCost + cities.graphMatrix[current.node][neighbor].totalCost + (M * factor), neighbor));
                    hashmap.put(neighbor, current.node);
                }
            }
            if (Queue.list.get(Queue.getMin()).node == destination)
                found = true;
        }while(!Queue.list.isEmpty() && !found);
    }

    public ArrayList<Integer> getPath(int source, int destination) {
        if(!found)
            return null;

        ArrayList<Integer> reversedPath, path;
        reversedPath = new ArrayList<>();

        reversedPath.add(destination);
        int temp = destination;
        while(temp != source){
            temp = hashmap.get(temp);
            reversedPath.add(temp);
        }

        path = new ArrayList<>();
        for(int i = 0 ; i < reversedPath.size(); i++){
            path.add(reversedPath.get(reversedPath.size() - 1 - i));
        }
        return path;
    }
}