import java.util.*;

public class A1 {
    void dfs(int current, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int neighbour : adj.get(current)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }

    void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int neighbour : adj.get(curr)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    public static void main(String args[]){
        A1 obj = new A1();
        Scanner sc = new Scanner(System.in);
        int v, e;

        System.out.println("Enter number of vertices and edges : ");
        v = sc.nextInt();
        e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }        

        System.out.println("Enter vertex between whose there is an edge : ");
        for(int i=0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        System.out.println("Graph : ");
        for(int i=0; i<v; i++){
            System.out.print(i + " -> " );
            for(int j: adj.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // DFS
        System.out.println("Depth First Search : ");
        boolean visitedDFS[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visitedDFS[i]) obj.dfs(i, adj, visitedDFS);
        }

        // BFS
        System.out.println("\n\nBreadth First Search : ");
        boolean visitedBFS[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visitedBFS[i]) obj.bfs(i, adj, visitedBFS);
        }

    }
}
