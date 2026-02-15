package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Machine.showMachineState();
        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.next();
        switch (action) {
            case "buy":
                buyMenu(scanner);
                break;
            case "fill":
                fillMenu(scanner);
                break;
            case "take":
                takeMenu();
                break;
            default:
                System.out.println("Invalid option.");
        }
        System.out.println();
        Machine.showMachineState();
    }

    //Action Menu
    public static void buyMenu(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffeeChoice = scanner.nextInt();
        switch (coffeeChoice) {
            case 1:
                Machine.makeEspresso();
                break;
            case 2:
                Machine.makeLatte();
                break;
            case 3:
                Machine.makeCappuccino();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void fillMenu(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int waterToAdd = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milkToAdd = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeansToAdd = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int disposableCupsToAdd = scanner.nextInt();
        Machine.fillItems(waterToAdd, milkToAdd, coffeeBeansToAdd, disposableCupsToAdd);
    }

    public static void takeMenu() {
        System.out.println("I gave you $" + Machine.showMoneyAmount());
        Machine.takeMoney();
    }
}