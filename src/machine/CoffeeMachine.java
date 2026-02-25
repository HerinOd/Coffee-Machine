package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            action = scanner.next();
            System.out.println();
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
                case "remaining":
                    remainingMenu();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }

    }

    //Action Menu
    public static void buyMenu(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeChoice = scanner.next();
        int resourceStatus;
        switch (coffeeChoice) {
            case "1":
                resourceStatus = Machine.makeEspresso();
                displayIngredientCheckResult(resourceStatus);
                break;
            case "2":
                resourceStatus = Machine.makeLatte();
                displayIngredientCheckResult(resourceStatus);
                break;
            case "3":
                resourceStatus = Machine.makeCappuccino();
                displayIngredientCheckResult(resourceStatus);
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void displayIngredientCheckResult(int resourceStatus) {
        if (resourceStatus > 0) {
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            switch (resourceStatus) {
                case -1:
                    System.out.println("Sorry, not enough water!");
                    break;
                case -2:
                    System.out.println("Sorry, not enough milk!");
                    break;
                case -3:
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                case -4:
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
            }
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

    public static void remainingMenu() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", Machine.getWater(), Machine.getMilk(), Machine.getCoffeeBeans(), Machine.getDisposableCups(), Machine.getMoney());
    }
}