public class Array {

    private final int MAX_SIZE = 20;            // the array size
    private int[] data = new int[MAX_SIZE];    
    private int count = 0;                     

    
    private String lastLinearResult = "No Linear Search done yet";
    private String lastBinaryResult = "No Binary Search done yet";

    public int getCount() {
        return count;
    }

    public String getLastLinearResult() {
        return lastLinearResult;
    }

    public String getLastBinaryResult() {
        return lastBinaryResult;
    }

    // ARRAY SUBMENU
    public void showMenu() {
        boolean back = false;

        while (back == false) {
            System.out.println();
            System.out.println("--------------- ARRAY OPERATIONS ------------");
            System.out.println(" 1. Insert");
            System.out.println(" 2. Delete");
            System.out.println(" 3. Search");
            System.out.println(" 4. Display");
            System.out.println(" 5. Return to Main Menu");
            int choice = InputValidator.readInt("Enter your choice: ", 1, 5);

            if (choice == 1) {
                insert();
            } else if (choice == 2) {
                delete();
            } else if (choice == 3) {
                linearSearch();
            } else if (choice == 4) {
                display();
            } else {
                back = true;
            }
        }
    }

    // SEARCHING SUBMENU (Linear Search and Binary Search)
    public void showSearchMenu() {
        boolean back = false;

        while (back == false) {
            System.out.println();
            System.out.println("--------------- SEARCHING OPERATIONS ------------");
            System.out.println(" Current array: " + toText());
            System.out.println(" 1. Linear Search");
            System.out.println(" 2. Binary Search");
            System.out.println(" 3. Return to Main Menu");
            int choice = InputValidator.readInt("Enter your choice: ", 1, 3);

            if (choice == 1) {
                linearSearch();
            } else if (choice == 2) {
                binarySearch();
            } else {
                back = true;
            }
        }
    }

    