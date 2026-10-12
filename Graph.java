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

    public void addVertex() {
        if (vertexCount == MAX_VERTICES) {
            System.out.println("  [!] Graph is full (maximum " + MAX_VERTICES + " vertices).");
        } else {
            vertexCount++;
            System.out.println("  [OK] Vertex " + vertexCount + " added. It has no roads yet - use Add Edge.");
            Main.addAction("Graph: added vertex " + vertexCount);
        }
    }
    public void addEdge() {
        int a = InputValidator.readInt("Enter first vertex (1 to " + vertexCount + "): ", 1, vertexCount);
        int b = InputValidator.readInt("Enter second vertex (1 to " + vertexCount + "): ", 1, vertexCount);

        if (a == b) {
            System.out.println("  [!] A road cannot connect a vertex to itself.");
        } else if (matrix[a][b] == 1) {
            System.out.println("  [!] There is already a road between " + a + " and " + b + ".");
        } else {
            connect(a, b);
            System.out.println("  [OK] Road added between " + a + " and " + b + ".");
            Main.addAction("Graph: added edge " + a + " - " + b);
        }
    }
	
	 public void showRough2DMap() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("            Colombo 1-15 City Map - ROUGH 2D MAP            ");
        System.out.println("============================================================");
        System.out.println("                             [15]");
        System.out.println("                            / | \\");
        System.out.println("                          /   |   \\");
        System.out.println("                        /     |     \\");
        System.out.println("                     [11]----[13]----[14]");
        System.out.println("                     / \\\\     |     //");
        System.out.println("                    /   \\ \\   |   / /");
        System.out.println("                   /     \\  \\ | /  /");
        System.out.println("                  /       \\  [12] /");
        System.out.println("                 /         \\  |  /");
        System.out.println("                /           \\ | /");
        System.out.println("               /             \\|/");
        System.out.println("             [01]------------[10]----[09]");
        System.out.println("               \\\\           / | \\     |");
        System.out.println("                \\ \\       /   |   \\   |");
        System.out.println("                 \\  \\   /     |     \\ |");
        System.out.println("                  \\  [02]----[07]----[08]");
        System.out.println("                   \\  |     / | \\     |");
        System.out.println("                    \\ |   /   |   \\   |");
        System.out.println("                     \\| /     |     \\ |");
        System.out.println("                     [03]----[04]----[05]");
        System.out.println("                      |       |     / |");
        System.out.println("                      |       |   /   |");
        System.out.println("                      |       | /     |");
        System.out.println("                      |      [06]     |");
        System.out.println("                      |               |");
        System.out.println("                      +---------------+");
        System.out.println("============================================================");
        System.out.println(" Note: this drawing is fixed. Vertices/roads you add");
        System.out.println(" yourself are shown in the Adjacency Matrix.");

        Main.addAction("Graph: viewed Rough 2D Map");
    }

    public void showAdjacencyMatrix() {
        int width = 8 + 3 * vertexCount;
        if (width < 60) {
            width = 60;
        }

        System.out.println();
        printBar(width);
        System.out.println("   Colombo 1-" + vertexCount + " City Map - ADJACENCY MATRIX");
        printBar(width);

        System.out.print("        ");
        for (int col = 1; col <= vertexCount; col++) {
            System.out.printf("%02d ", col);
        }
        System.out.println();

        for (int row = 1; row <= vertexCount; row++) {
            System.out.printf("   %02d   ", row);

            for (int col = 1; col <= vertexCount; col++) {
                if (matrix[row][col] == 1) {
                    System.out.print("1  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }

        printBar(width);
        System.out.println("   1 = road     . = no road");
        System.out.println("   Vertices: " + vertexCount + "     Roads (edges): " + edgeCount);

        Main.addAction("Graph: viewed Adjacency Matrix");
    }

    private void printBar(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
	
	   public void bfs() {
        int start = InputValidator.readInt("Enter the start vertex (1 to " + vertexCount + "): ", 1, vertexCount);

        boolean[] visited = new boolean[MAX_VERTICES + 1];
        int[] queue = new int[MAX_VERTICES + 1];
        int front = 0;
        int rear = 0;
        int visitedCount = 0;
        String order = "";

        visited[start] = true;
        queue[rear] = start;
        rear++;

        while (front < rear) {
            int current = queue[front];
            front++;

            if (visitedCount > 0) {
                order = order + " -> ";
            }
            order = order + current;
            visitedCount++;

            for (int next = 1; next <= vertexCount; next++) {
                if (matrix[current][next] == 1 && visited[next] == false) {
                    visited[next] = true;
                    queue[rear] = next;
                    rear++;
                }
            }
        }

        System.out.println();
        System.out.println(" BFS from vertex " + start + ":");
        System.out.println(" " + order);
        System.out.println(" Vertices reached: " + visitedCount + " of " + vertexCount);

        lastBfsResult = "Start " + start + ": " + order;
        Main.addAction("Graph: BFS from vertex " + start);
    }

   public void dfs() {
        int start = InputValidator.readInt("Enter the start vertex (1 to " + vertexCount + "): ", 1, vertexCount);

        dfsVisited = new boolean[MAX_VERTICES + 1];
        dfsOrder = "";
        dfsVisitedCount = 0;

        dfsVisit(start);

        System.out.println();
        System.out.println(" DFS from vertex " + start + ":");
        System.out.println(" " + dfsOrder);
        System.out.println(" Vertices reached: " + dfsVisitedCount + " of " + vertexCount);

        lastDfsResult = "Start " + start + ": " + dfsOrder;
        Main.addAction("Graph: DFS from vertex " + start);
    }

    private void dfsVisit(int current) {
        dfsVisited[current] = true;

        if (dfsVisitedCount > 0) {
            dfsOrder = dfsOrder + " -> ";
        }
        dfsOrder = dfsOrder + current;
        dfsVisitedCount++;

        for (int next = 1; next <= vertexCount; next++) {
            if (matrix[current][next] == 1 && dfsVisited[next] == false) {
                dfsVisit(next);
            }
        }
    }
}



