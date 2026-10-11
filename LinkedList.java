class Node {
    int data;     
    Node next;    

    Node(int value) {
        data = value;
        next = null;
    }
}

public class LinkedList {

    private Node head = null;    
    private int count = 0;

    public int getCount() {
        return count;
    }

    // -------------------------------------submenu--------------------------

    public void showMenu() {
        boolean back = false;

        while (back == false) {
            System.out.println();
            System.out.println("--------------- LINKED LIST OPERATIONS ------------");
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
                search();
            } else if (choice == 4) {
                display();
            } else {
                back = true;
            }
        }
    }
}