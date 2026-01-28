package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        //==========================================================
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
        //==========================================================
        Scanner scanner = new Scanner(System.in);

        //Ask the user to input how many cups of coffee they need:
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();

        //The ingredients needed for each cup:
        int waterEachCup = 200; //ml
        int milkEachCup = 50; //ml
        int coffeeBeansEachCup = 15; //g

        //Output the required ingredient amounts back to the user:
        System.out.println("For " + cupsOfCoffee + " cups of coffee you will need:\n" +
                (waterEachCup * cupsOfCoffee) + " ml of water\n" +
                (milkEachCup * cupsOfCoffee) + " ml of milk\n" +
                (coffeeBeansEachCup * cupsOfCoffee) + " g of coffee beans");
    }
}
