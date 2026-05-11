import java.util.*;

public class graph_coloring {

    static boolean isSafe(int vertex, int color, int[] colors, int[][] graph, int V) {
        for (int i = 0; i < V; i++) {
            if (graph[vertex][i] == 1 && colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    static boolean solveColoring(int vertex, int m, int[] colors, int[][] graph, int V) {
        if (vertex == V) {
            return true;
        }

        for (int color = 0; color < m; color++) {
            if (isSafe(vertex, color, colors, graph, V)) {
                colors[vertex] = color;
                if (solveColoring(vertex + 1, m, colors, graph, V)) {
                    return true;
                }
                colors[vertex] = 0; // backtrack
            }
        }
        return false;
    }

    static void graphColoring(int m, int[] colors, int[][] graph, int V, String[] colorNames) {
        if (solveColoring(0, m, colors, graph, V)) {
            System.out.println("\nSolution Exists!");
            System.out.println("Assigned Colors:");
            for (int i = 0; i < V; i++) {
                int colorIndex = colors[i];
                System.out.println("Vertex " + i + " --> Color " + colorNames[colorIndex]);
            }
        } else {
            System.out.println("Solution does not exist.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];
        int[] colors = new int[V]; // stores color assigned to each edge
        Arrays.fill(colors, 0);// Initialize with no color assigned

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter vertices between whom there is an edge (edges start from 0):");
        for (int i = 0; i < edges; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        System.out.print("Enter number of colors: ");
        int m = sc.nextInt();
        sc.nextLine();

        String[] colorNames = new String[m];
        System.out.println("Enter " + m + " color names: ");
        for (int i = 0; i < m; i++) {
            colorNames[i] = sc.nextLine();
        }

        graphColoring(m, colors, graph, V, colorNames);

        sc.close();
    }
}
