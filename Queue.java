public class Queue {

    private final int MAX_SIZE = 10;
    private int[] data = new int[MAX_SIZE];
    private int count = 0;     // how many items are in the queue

    public int getCount() {
        return count;
    }

    //   Submenu

    public void showMenu() {
        boolean back = false;

        while (back == false) {
            System.out.println();
            System.out.println("--------------- QUEUE OPERATIONS ------------");
            System.out.println(" 1. Enqueue");
            System.out.println(" 2. Dequeue");
            System.out.println(" 3. Peek / Front");
            System.out.println(" 4. Display");
            System.out.println(" 5. Return to Main Menu");
            int choice = InputValidator.readInt("Enter your choice: ", 1, 5);

            if (choice == 1) {
                enqueue();
            } else if (choice == 2) {
                dequeue();
            } else if (choice == 3) {
                peek();
            } else if (choice == 4) {
                display();
            } else {
                back = true;
            }
        }
    }

}