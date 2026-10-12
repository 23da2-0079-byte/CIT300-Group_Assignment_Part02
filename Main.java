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


}