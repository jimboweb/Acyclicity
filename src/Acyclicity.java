import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Acyclicity {
    private static boolean visited[];
    private static boolean onPath[];
    private static int acyclic(ArrayList<Integer>[] adj) {
        int rtrnVal = 0;
        for(int i=0; i<adj.length;i++){
            rtrnVal = findCycle(adj, i);
            if(rtrnVal == 1)
                break;
        }
        return rtrnVal;
    }
    

    private static int findCycle(ArrayList<Integer>[] adj, int n){
        int rtrnval = 0;
        if(onPath[n])
            return 1;
        if(visited[n])
            return 0;
        visited[n] = true;
        onPath[n] = true;
        for(int node:adj[n]){
            rtrnval = findCycle(adj, node);
            if(rtrnval == 1)
                break;
        }
        onPath[n] = false;
        return rtrnval;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        visited = new boolean[adj.length];
        onPath = new boolean[adj.length];
        for(boolean node:visited)
            node = false;
        for(boolean node:onPath)
            node = false;
        System.out.println(acyclic(adj));
    }
}

