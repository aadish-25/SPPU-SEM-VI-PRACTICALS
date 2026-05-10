import java.util.*;

public class GraphColoring {

    int v;
    int[][] graph;
    int[] colors;

    GraphColoring(int v) {
        this.v = v;
        graph = new int[v][v];
        colors = new int[v];
    }

    boolean isSafe(int vertex, int color) {
        for (int i = 0; i < v; i++) {
            if (graph[vertex][i] == 1 && colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    boolean solveColoring(int vertex, int m) {
        if (vertex == v) {
            return true;
        }

        for (int color = 1; color <= m; color++) {
            if (isSafe(vertex, color)) {
                colors[vertex] = color;
                if (solveColoring(vertex + 1, m)) {
                    return true;
                }
                colors[vertex] = 0;
            }
        }
        return false;
    }

    void graphColoring(int m) {
        if (solveColoring(0, m)) {
            System.out.println("\nSolution Exists!");
            System.out.println("Assigned Colors:");

            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + " --> Color " + colors[i]);
            }

        } else {
            System.out.println("Solution does not exist.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        GraphColoring gc = new GraphColoring(v);

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter connected vertices:");
        for (int i = 0; i < edges; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            gc.graph[a][b] = 1;
            gc.graph[b][a] = 1;
        }

        System.out.print("Enter number of colors: ");
        int m = sc.nextInt();

        gc.graphColoring(m);
        sc.close();
    }
}
