package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();

        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

        while (true) {
            String input = scanner.next();

            if (input.equals("exit")) {
                return;
            } else {
                System.out.println(machine.processInput(input));
            }
        }

    }
}