import java.util.*;

class Edge {
    int vertex;
    int weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
};

public class prims {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v, e;

        System.out.println("Enter the no of vertices and edges: ");
        v = sc.nextInt();
        e = sc.nextInt();

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the vertex between whose their is an edge (edge starting from 0) and its weight");
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            adj.get(a).add(new Edge(b, c));
            adj.get(b).add(new Edge(a, c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        boolean visited[] = new boolean[v];

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        pq.add(new Edge(start, 0));

        int totalCost = 0;
        System.out.print("MST: ");

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (visited[currentVertex])
                continue;

            System.out.print(currentVertex + " ");

            visited[currentVertex] = true;
            totalCost = totalCost + currentWeight;

            for (Edge neighbour : adj.get(currentVertex)) {
                if (!visited[neighbour.vertex]) {
                    pq.add(new Edge(neighbour.vertex, neighbour.weight));
                }
            }
        }
        System.out.println("\nTotal cost: " + totalCost);

        sc.close();
    }
}
