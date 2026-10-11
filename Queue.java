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

    public void enqueue() {
        if (count == MAX_SIZE) {
            System.out.println("  [!] Queue is full (maximum " + MAX_SIZE + " items).");
        } else {
            int value = InputValidator.readValue("Enter the number to enqueue: ");
            data[count] = value;
            count++;

            System.out.println("  [OK] " + value + " added to the queue.");
            Main.addAction("Queue: enqueued " + value);
        }
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("  [!] Queue Underflow: cannot dequeue from an empty queue.");
        } else {
            int value = data[0];

            for (int i = 0; i < count - 1; i++) {
                data[i] = data[i + 1];
            }
            count--;

            System.out.println("  [OK] " + value + " removed from the queue.");
            Main.addAction("Queue: dequeued " + value);
        }
    }

}