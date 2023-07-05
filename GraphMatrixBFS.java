import java.util.*;

// ADJACENCY MATRIX

// Add/Remove/Query Edge -> O(1) Time Complexity
// Find Neighbors -> O(V) Time Complexity
// Add/Remove Node O(V^2) Time Complexity
// Space Complexity -> O(V^2)

public class GraphMatrixBFS {

    private int[][] matrix;
    private int vertex;

    public GraphMatrixBFS(int v) {
        vertex = v;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int v, int w) {
        matrix[v][w] = 1;
    }

    // BFS algorithm
    public void BFS(int source) {
        // create an array for the nodes visited
        boolean[] visited = new boolean[vertex];
        // create a queue backed by a linked-list
        LinkedList<Integer> queue = new LinkedList<>();
        // add source to the array as having been visited
        visited[source] = true;
        // add the source to the queue
        queue.add(source);
        // as long as we have items (nodes) in the queue
        while (queue.size() != 0) {
            source = queue.poll(); // dequeue
            System.out.print(source + " "); // print
            // visit the current node's unvisited neighbors
            for (int index = 0; index < vertex; ++index) {
                // if an adjacent neighbor (index) hasn't been visited then add it to the queue
                if (matrix[source][index] == 1 && !visited[index]) {
                    visited[index] = true; // neighbor has now been visited
                    queue.add(index); // queue
                }
            }
        }
    }


    // Test
    public static void main(String[] args) {
        // create a new graph
        GraphMatrixBFS graph = new GraphMatrixBFS(4);
        // add edges/vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        // do a BFS traversal
        System.out.println("BFS traversal starting from vertex 2:");
        graph.BFS(2);
    }

}
