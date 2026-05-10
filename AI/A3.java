import java.util.*;

public class A3 {
    static class Edge {
        int vertex, weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    void selectionSort() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    void primsAlgorithm() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices and edges:");
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges: vertex1 vertex2 weight");
        for (int i = 0; i < e; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int weight = sc.nextInt();

            adj.get(vertex1).add(new Edge(vertex2, weight));
            adj.get(vertex2).add(new Edge(vertex1, weight));
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

        boolean visited[] = new boolean[v];

        int totalCost = 0;

        pq.add(new Edge(start, 0));

        System.out.print("MST: ");

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;
            totalCost += currentWeight;

            System.out.print(currentVertex + " ");

            for (Edge neighbour : adj.get(currentVertex)) {
                if (!visited[neighbour.vertex]) {
                    pq.add(new Edge(neighbour.vertex, neighbour.weight));
                }
            }
        }

        System.out.println("\nTotal cost: " + totalCost);
    }

    public static void main(String[] args) {
        A3 obj = new A3();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Selection Sort");
            System.out.println("2. Prim's Algorithm");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.selectionSort();
                    break;

                case 2:
                    obj.primsAlgorithm();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 3);
    }
}
