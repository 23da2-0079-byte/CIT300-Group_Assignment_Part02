public class Stack {

    private final int MAX_SIZE = 10;
    private int[] data = new int[MAX_SIZE];
    private int top = -1;

    // How many items are in the stack
    public int getCount() {
        return top + 1;
    }


    public void showMenu() {
        boolean back = false;

        while (back == false) {
            System.out.println();
            System.out.println("--------------- STACK OPERATIONS ------------");
            System.out.println(" 1. Push");
            System.out.println(" 2. Pop");
            System.out.println(" 3. Peek");
            System.out.println(" 4. Display");
            System.out.println(" 5. Return to Main Menu");
            int choice = InputValidator.readInt("Enter your choice: ", 1, 5);

            if (choice == 1) {
                push();
            } else if (choice == 2) {
                pop();
            } else if (choice == 3) {
                peek();
            } else if (choice == 4) {
                display();
            } else {
                back = true;
            }
        }
    }

    public void push() {
        if (top == MAX_SIZE - 1) {
            System.out.println("  [!] Stack Overflow: the stack is full (maximum " + MAX_SIZE + " items).");
        } else {
            int value = InputValidator.readValue("Enter the number to push: ");
            top++;
            data[top] = value;

            System.out.println("  [OK] " + value + " pushed onto the stack.");
            Main.addAction("Stack: pushed " + value);
        }
    }


}
