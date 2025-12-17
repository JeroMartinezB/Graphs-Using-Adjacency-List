import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphDriver {
    public static void main(String[]args){

        Scanner stdIn = new Scanner(System.in);
        Graph graph = null; // Create empty graph
        String fileName;
        int userInput;


        try {
            // User Input
           System.out.println("Enter the name of the file: ");
           fileName = stdIn.nextLine();
           System.out.println("Loading graph from " + fileName);
           Scanner fileScanner = new Scanner(new File(fileName));

           // Read the first line
           int numOfVertices = fileScanner.nextInt();

           // Initialize the graph
           graph = new Graph(numOfVertices);

           // Read the edges
           while (fileScanner.hasNextInt()) {
                int from = fileScanner.nextInt();
                int to = fileScanner.nextInt();
                graph.addEdge(from, to);
                graph.addEdge(to, from);
            
           }
 
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        // Pick a starting vertex to interact with the graph
        while (true) {
            System.out.println("Please enter the vertex to start at: ");
            userInput = stdIn.nextInt();
            stdIn.nextLine();
            // Input validation
            if (userInput>=0 && userInput < graph.getVertices()) {
                break;
            } else{
                System.out.println("The graph only has " + graph.getVertices() + " vertices. Try again!");
            }
        }

        // Interact with the graph
        while (true) {
            // Display adjacent vertices
            List<Integer> neighbors = graph.getAdjacentVertices(userInput); // List with adjacent vertices
            System.out.println("Currently at vertex: " + userInput +
            " \nAdjacent vertices: " + neighbors);
            
            System.out.println("What would you like to do? (M)ove, (P)rint Graph, (S)earch, (Q)uit?: ");
            String userChoice = stdIn.nextLine();

            // Quit
            if (userChoice.equalsIgnoreCase("q")) {
                System.out.println("Bye!");
                break;

            // Move    
            } else if (userChoice.equalsIgnoreCase("m")) {
                System.out.println("Please enter the vertex: ");
                int moveTo = stdIn.nextInt();
                stdIn.nextLine();
                // Check if it is adjacent
                if (neighbors.contains(moveTo)) {
                    userInput = moveTo; // Move
                } else {
                    System.out.println("Vertex is not connected");
                }

            // Print Graph    
            } else if (userChoice.equalsIgnoreCase("p")) {
                graph.printGraph();

            // Search (BFS)    
            } else if (userChoice.equalsIgnoreCase("s")) {
                System.out.println("Please enter the value to search for: ");
                int searchFor = stdIn.nextInt();
                stdIn.nextLine();
                // Check if found
                boolean found = graph.findVertex(userInput, searchFor); 
                if (found) {
                    System.out.println("Vertex " + searchFor + " was found in this graph");
                } else {
                    System.out.println("Not Found!");
                }
            // Input Validation    
            } else {
                System.out.println("Wrong Input, try again!");
            }

        }

    }
}

