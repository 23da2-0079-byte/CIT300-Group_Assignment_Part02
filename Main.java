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

}