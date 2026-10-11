public class Graph {

    private final int MAX_VERTICES = 20;  
    private int[][] matrix = new int[MAX_VERTICES + 1][MAX_VERTICES + 1];
    private int vertexCount = 0;
    private int edgeCount = 0;

    private String lastBfsResult = "No BFS done yet";
    private String lastDfsResult = "No DFS done yet";

    private boolean[] dfsVisited;
    private String dfsOrder;
    private int dfsVisitedCount;


    public Graph() {
        vertexCount = 15;

        connect(1, 2);
        connect(1, 3);
        connect(1, 10);
        connect(1, 11);

        connect(2, 3);
        connect(2, 7);
        connect(2, 10);

        connect(3, 4);
        connect(3, 5);
        connect(3, 7);

        connect(4, 5);
        connect(4, 6);
        connect(4, 7);

        connect(5, 6);
        connect(5, 7);
        connect(5, 8);

        connect(7, 8);
        connect(7, 10);

        connect(8, 9);
        connect(8, 10);

        connect(9, 10);

        connect(10, 11);
        connect(10, 12);
        connect(10, 14);

        connect(11, 12);
        connect(11, 13);
        connect(11, 15);

        connect(12, 13);
        connect(12, 14);

        connect(13, 14);
        connect(13, 15);

        connect(14, 15);
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public String getLastBfsResult() {
        return lastBfsResult;
    }

    public String getLastDfsResult() {
        return lastDfsResult;
    }


    private void connect(int a, int b) {
        matrix[a][b] = 1;
        matrix[b][a] = 1;
        edgeCount++;
    }

    public void showMenu() {
        boolean back = false;

        while (back == false) {
            System.out.println();
            System.out.println("--------------- GRAPH OPERATIONS ------------");
            System.out.println(" 1. Add Vertex");
            System.out.println(" 2. Add Edge");
            System.out.println(" 3. Rough 2D Map");
            System.out.println(" 4. Adjacency Matrix");
            System.out.println(" 5. BFS Traversal");
            System.out.println(" 6. DFS Traversal");
            System.out.println(" 7. Return to Main Menu");
            int choice = InputValidator.readInt("Enter your choice: ", 1, 7);

            if (choice == 1) {
                addVertex();
            } else if (choice == 2) {
                addEdge();
            } else if (choice == 3) {
                showRough2DMap();
            } else if (choice == 4) {
                showAdjacencyMatrix();
            } else if (choice == 5) {
                bfs();
            } else if (choice == 6) {
                dfs();
            } else {
                back = true;
            }
        }
    }
