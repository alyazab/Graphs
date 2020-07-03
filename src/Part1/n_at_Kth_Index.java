package Part1;
import java.util.*;

public class n_at_Kth_Index {
    ArrayList<ArrayList<Integer>> bfsModified(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited){
        int visiting, i;

        ArrayList<ArrayList<Integer>> spanning = new ArrayList<>();
        //create empty spanning tree
        for(i = 0 ; i < graph.size() ; i++)
            spanning.add(i, new ArrayList<>());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            visiting = queue.remove();
            for(i = 0 ; i < graph.get(visiting).size() ; i++){
                if(!visited[graph.get(visiting).get(i)]){
                    visited[graph.get(visiting).get(i)]=true;
                    queue.add(graph.get(visiting).get(i));
                    //adding to spanning tree
                    spanning.get(visiting).add(graph.get(visiting).get(i));
                }
            }
        }
        return spanning;
    }

    int dfsModified(int src, ArrayList<ArrayList<Integer>> spanning, boolean[] visited, int k) {
        int visiting,i,length=0,count=0;

        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        boolean isAdjacent;
        while(!stack.isEmpty()){
            visiting = stack.peek();
            isAdjacent = false;

            for( i = spanning.get(visiting).size()-1 ; i >= 0 ; i--){
                if(!visited[spanning.get(visiting).get(i)]){
                    stack.push(spanning.get(visiting).get(i));
                    visited[spanning.get(visiting).get(i)]=true;
                    isAdjacent = true;
                    length++;
                    if(length==k){
                        count++;
                    }
                    break;
                }
            }
            if(!isAdjacent){
                stack.pop();
                length--;
            }
        }
        return count;
    }

    public void activate(){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("please enter number of vertices");
        int vertices = sc.nextInt();
        sc.nextLine();
        System.out.println("please enter number of edges");
        int edges = sc.nextInt();
        sc.nextLine();

        //create graph
        int i,u,v;

        System.out.println("please enter edges in the form (u v)");
        for(i=0;i<vertices+1;i++)
            graph.add(i,new ArrayList<>());
        for(i=0;i<edges;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        sc.nextLine();

        System.out.println("please enter starting vertex");
        int start = sc.nextInt();
        sc.nextLine();

        boolean[] visited = new boolean[vertices+1];

        System.out.println("Please enter value k");
        int k = sc.nextInt();
        sc.nextLine();

        for(i = 0 ; i < visited.length ; i++)
            visited[i] = false;

        int result;
        ArrayList<ArrayList<Integer>> spanning;
        spanning = bfsModified(graph, start, visited);

        for(i = 0 ; i < visited.length ; i++)
            visited[i] = false;

        result = dfsModified(start, spanning, visited, k);
        System.out.println("There are " + result +" people with "+ k +" connections away starting from "+ start);
    }
}