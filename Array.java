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

    // INSERT
    public void insert() {
        if (count == MAX_SIZE) {
            System.out.println("  [!] Array is full (maximum " + MAX_SIZE + " items).");
        } else {
            int value = InputValidator.readValue("Enter the number to insert: ");
            int position = InputValidator.readInt("Enter position (1 to " + (count + 1) + "): ", 1, count + 1);

        
            for (int i = count; i >= position; i--) {
                data[i] = data[i - 1];
            }

            data[position - 1] = value;
            count++;

            System.out.println("  [OK] " + value + " inserted at position " + position + ".");
            Main.addAction("Array: inserted " + value + " at position " + position);
        }
    }

    // DELETE
    public void delete() {
        if (count == 0) {
            System.out.println("  [!] Array is empty. Nothing to delete.");
        } else {
            int position = InputValidator.readInt("Enter position to delete (1 to " + count + "): ", 1, count);
            int removed = data[position - 1];

            for (int i = position - 1; i < count - 1; i++) {
                data[i] = data[i + 1];
            }
            count--;

            System.out.println("  [OK] " + removed + " deleted from position " + position + ".");
            Main.addAction("Array: deleted " + removed + " from position " + position);
        }
    }

    // DISPLAY
    public void display() {
        if (count == 0) {
            System.out.println("  [!] Array is empty.");
        } else {
            System.out.println();
            System.out.println(" Array (" + count + " of " + MAX_SIZE + " used)");

            System.out.print(" Position : ");
            for (int i = 0; i < count; i++) {
                System.out.printf("%-7d", i + 1);
            }
            System.out.println();

            System.out.print(" Value    : ");
            for (int i = 0; i < count; i++) {
                System.out.printf("%-7d", data[i]);
            }
            System.out.println();
        }
    }


    // LINEAR SEARCH
    public void linearSearch() {
        if (count == 0) {
            System.out.println("  [!] Array is empty. Insert numbers first.");
        } else {
            int target = InputValidator.readValue("Enter the number to search: ");
            int foundPosition = -1;
            int i = 0;

            while (i < count && foundPosition == -1) {
                if (data[i] == target) {
                    foundPosition = i + 1;
                }
                i++;
            }

            if (foundPosition == -1) {
                System.out.println("  [!] Linear Search: " + target + " was not found.");
                lastLinearResult = target + " not found";
            } else {
                System.out.println("  [OK] Linear Search: " + target + " found at position " + foundPosition + ".");
                lastLinearResult = target + " found at position " + foundPosition;
            }
            Main.addAction("Linear Search for " + target);
        }
    }

    // BINARY SEARCH
    public void binarySearch() {
        if (count == 0) {
            System.out.println("  [!] Array is empty. Insert numbers first.");
        } else {
            if (isSorted() == false) {
                System.out.println("  Binary Search needs a sorted array. Sorting the array first...");
                sortArray();
                System.out.println("  Sorted array: " + toText());
                Main.addAction("Array sorted for Binary Search");
            }

            int target = InputValidator.readValue("Enter the number to search: ");
            int low = 0;
            int high = count - 1;
            int foundPosition = -1;

            while (low <= high && foundPosition == -1) {
                int middle = (low + high) / 2;

                if (data[middle] == target) {
                    foundPosition = middle + 1;
                } else if (data[middle] < target) {
                    low = middle + 1;      // look the right half
                } else {
                    high = middle - 1;     // look the left half
                }
            }

            if (foundPosition == -1) {
                System.out.println("  [!] Binary Search: " + target + " was not found.");
                lastBinaryResult = target + " not found";
            } else {
                System.out.println("  [OK] Binary Search: " + target + " found at position " + foundPosition + ".");
                lastBinaryResult = target + " found at position " + foundPosition;
            }
            Main.addAction("Binary Search for " + target);
        }
    }


    private boolean isSorted() {
        boolean sorted = true;

        for (int i = 0; i < count - 1; i++) {
            if (data[i] > data[i + 1]) {
                sorted = false;
            }
        }

        return sorted;
    }

    // Bubble Sort
    private void sortArray() {
        for (int round = 0; round < count - 1; round++) {
            for (int i = 0; i < count - 1 - round; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
    }

    public String toText() {
        String text = "(empty)";

        if (count > 0) {
            text = "[";
            for (int i = 0; i < count; i++) {
                text = text + data[i];
                if (i < count - 1) {
                    text = text + ", ";
                }
            }
            text = text + "]";
        }

        return text;
    }
}
