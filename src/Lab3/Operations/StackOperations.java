package Lab3.Operations;

import Lab3.Models.Stack;

import java.util.Scanner;

public class StackOperations {
    private Stack stack;

    public StackOperations(Stack stack) {
        this.stack = stack;
    }

    public void performStackOperations(Scanner scanner) {
        while (true) {
            System.out.println("\nChoose a stack operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("0. Back to Main Menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push to stack: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    System.out.println("Popped element from stack: " + stack.pop());
                    break;
                case 3:
                    System.out.println("Peeked element from stack: " + stack.peek());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
