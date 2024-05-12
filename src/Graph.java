public class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

        public static void main(String[] args) {
            Graph graph = new Graph(5);
            graph.addEdge(0, 1);
            //0 * * * * * *
            // 1 * * * * * *
            // 2 * * * * * *
            // 3 * * * * * *
            graph.addEdge(0, 4);                      // 4 * * * * * *
            graph.addEdge(1, 2);                      // 5 * * * * * *
            graph.addEdge(1, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);

            graph.printGraph();
        }
    }

