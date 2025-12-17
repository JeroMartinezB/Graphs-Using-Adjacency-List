import java.util.*;

public class Graph {

    protected int vertices;
    protected ArrayList<Integer>[]adjList; // Adjacency list using ArrayList

    // Constructor
    public Graph(int numOfVertices){
        this.vertices = numOfVertices;
        // Create empty graph 
        adjList = (ArrayList<Integer>[]) new ArrayList[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adjList[i] = new ArrayList<Integer>(); // ArrayList at each index
        }
    }

    // Add Edges
    public void addEdge(int from, int to){
        // Add to ArrayList
        adjList[from].add(to);
    }

    // Get number of vertices
    public int getVertices(){
        return vertices;
    }

    // Get adjacent vertices
    public List<Integer> getAdjacentVertices(int vertex){
        return adjList[vertex];
    }

    // Search for a vertex (BFS)
    public boolean findVertex(int start, int target){
        // Input validation
        if (target < 0 || target >= vertices) {
            return false;
        }

        // Keep track of visited vertices
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        // Starts search at the current vertex
        queue.add(start);
        visited[start] = true;

        // Search
        while (!queue.isEmpty()) {
            int current = queue.poll(); // Pointer

            if (current == target   ) {
                return true; // Found
            }

            // Visit concurrent vertices
            for (int neighbor : adjList[current]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return false; // Not found


    }

    // Print Graph
    public void printGraph() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " -> ");
            // Iterate over the ArrayList
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
