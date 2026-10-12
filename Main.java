public class Main {

    public static Array myArray = new Array(); // Work in progress – not final
    public static Stack myStack = new Stack();
    public static Queue myQueue = new Queue();
    public static LinkedList myList = new LinkedList();
    public static Graph myGraph = new Graph();

    private static String[] recentActions = new String[5];
    private static int actionCount = 0;

       public static void main(String[] args) {

        addAction("Colombo 1-15 map loaded into the Graph");

        boolean running = true;

        while (running == true) {
            showDashboard();
            showMainMenu();
            int choice = InputValidator.readInt("Enter your choice: ", 1, 9);

            if (choice == 1) {
                myArray.showMenu();
            } else if (choice == 2) {
                myStack.showMenu();
            } else if (choice == 3) {
                myQueue.showMenu();
            } else if (choice == 4) {
                myList.showMenu();
            } else if (choice == 5) {
                myArray.showSearchMenu();
            } else if (choice == 6) {
                myGraph.showMenu();
            } else if (choice == 7) {
                showPerformanceComparison();
            } else if (choice == 8) {
                showAllResults();
            } else {
                running = false;
            }
        }

        System.out.println();
        System.out.println("Thank you for using the Data Structure & Graph Analyzer. Goodbye!");
    }

     public static void showDashboard() {
        System.out.println();
        System.out.println("+==========================================================+");
        System.out.println("|             DATA STRUCTURE & GRAPH ANALYZER              |");
        System.out.println("|                       Group No: 21                       |");
        System.out.println("+==========================================================+");

        System.out.println();
        System.out.println(" LIVE DATA STRUCTURE STATUS");
        System.out.println("+----------------------+--------------+--------------------+");
        System.out.println("| Structure            | Count        | Status             |");
        System.out.println("+----------------------+--------------+--------------------+");
        showStatusRow("Array", myArray.getCount());
        showStatusRow("Stack", myStack.getCount());
        showStatusRow("Queue", myQueue.getCount());
        showStatusRow("Linked List", myList.getCount());
        showStatusRow("Graph (Vertices)", myGraph.getVertexCount());
        System.out.println("+----------------------+--------------+--------------------+");

        System.out.println();
        System.out.println(" RECENT ACTIONS");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < actionCount; i++) {
            System.out.println(" " + (i + 1) + ". " + recentActions[i]);
        }
        System.out.println("------------------------------------------------------------");
    }

    private static void showStatusRow(String name, int count) {
        String status = "Empty";
        if (count > 0) {
            status = "Has Data";
        }

        System.out.printf("| %-20s | %-12d | %-18s |%n", name, count, status);
    }

       public static void showMainMenu() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println(" MAIN MENU");
        System.out.println("=============================================");
        System.out.println(" 1. Array Operations");
        System.out.println(" 2. Stack Operations");
        System.out.println(" 3. Queue Operations");
        System.out.println(" 4. Linked List Operations");
        System.out.println(" 5. Searching Operations");
        System.out.println(" 6. Graph Operations");
        System.out.println(" 7. Performance Comparison");
        System.out.println(" 8. Display All Results");
        System.out.println(" 9. Exit");
    }


    public static void showPerformanceComparison() {
        System.out.println();
        System.out.println("=============================================================");
        System.out.println("                   PERFORMANCE COMPARISON                    ");
        System.out.println("=============================================================");
        System.out.printf(" %-22s%-22s%s%n", "Operation", "Algorithm / Structure", "Time Complexity");
        System.out.println("-------------------------------------------------------------");
        System.out.printf(" %-22s%-22s%s%n", "Search", "Linear Search", "O(n)");
        System.out.printf(" %-22s%-22s%s%n", "Search", "Binary Search", "O(log n)");
        System.out.printf(" %-22s%-22s%s%n", "Graph Traversal", "BFS (matrix)", "O(V^2)");
        System.out.printf(" %-22s%-22s%s%n", "Graph Traversal", "DFS (matrix)", "O(V^2)");
        System.out.printf(" %-22s%-22s%s%n", "Insert / Delete", "Array", "O(n)");
        System.out.printf(" %-22s%-22s%s%n", "Push / Pop", "Stack", "O(1)");
        System.out.printf(" %-22s%-22s%s%n", "Enqueue", "Queue (array)", "O(1)");
        System.out.printf(" %-22s%-22s%s%n", "Dequeue", "Queue (array)", "O(n)");
        System.out.printf(" %-22s%-22s%s%n", "Insert/Delete/Search", "Linked List", "O(n)");
        System.out.println("-------------------------------------------------------------");
        System.out.println(" n = number of items      V = number of vertices");

        System.out.println();
        System.out.println(" LATEST RESULTS");
        System.out.println(" Linear Search : " + myArray.getLastLinearResult());
        System.out.println(" Binary Search : " + myArray.getLastBinaryResult());
        System.out.println(" BFS           : " + myGraph.getLastBfsResult());
        System.out.println(" DFS           : " + myGraph.getLastDfsResult());

        System.out.println();
        System.out.println(" WHY THE RESULTS DIFFER");
        System.out.println(" - Linear Search checks items one by one: O(n).");
        System.out.println(" - Binary Search cuts the search area in half each time: O(log n),");
        System.out.println("   but the array must be sorted first.");
        System.out.println(" - BFS (queue) visits level by level; DFS (recursion) goes deep first.");
        System.out.println("   So the visiting ORDER is different, but both reach every vertex.");
        System.out.println(" - With an adjacency matrix each vertex scans a full row: O(V^2).");
        System.out.println("   With an adjacency list it would be O(V + E).");
        System.out.println(" - Stack push/pop and queue enqueue work at one end only: O(1).");
        System.out.println(" - Our array queue moves every item left on dequeue: O(n).");

        addAction("Viewed Performance Comparison");
    }
   public static void showAllResults() {
        System.out.println();
        System.out.println("=============================================================");
        System.out.println("                     DISPLAY ALL RESULTS                     ");
        System.out.println("=============================================================");
        System.out.println(" DATA STRUCTURES");
        System.out.println(" Array         : " + myArray.toText());
        System.out.println(" Stack         : " + myStack.toText());
        System.out.println(" Queue         : " + myQueue.toText());
        System.out.println(" Linked List   : " + myList.toText());
        System.out.println(" Graph         : " + myGraph.getVertexCount() + " vertices, "
                + myGraph.getEdgeCount() + " roads");

        System.out.println();
        System.out.println(" SEARCH AND TRAVERSAL RESULTS");
        System.out.println(" Linear Search : " + myArray.getLastLinearResult());
        System.out.println(" Binary Search : " + myArray.getLastBinaryResult());
        System.out.println(" BFS           : " + myGraph.getLastBfsResult());
        System.out.println(" DFS           : " + myGraph.getLastDfsResult());
        System.out.println("=============================================================");

        addAction("Viewed All Results");
    }

     public static void addAction(String text) {
        for (int i = recentActions.length - 1; i > 0; i--) {
            recentActions[i] = recentActions[i - 1];
        }

        recentActions[0] = text;

        if (actionCount < recentActions.length) {
            actionCount++;
        }
    }
}