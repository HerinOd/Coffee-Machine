package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static final int WATER_EACH_CUP = 200; //ml
    static final int MILK_EACH_CUP = 50; //ml
    static final int COFFEE_BEANS_EACH_CUP = 15; //g

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int wantedCoffeeCups = scanner.nextInt();

        // Check how many cups the machine can make:
        int possibleCups = getPossibleCoffeeCups(availableWater, availableMilk, availableCoffeeBeans);
        if (possibleCups == wantedCoffeeCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCups > wantedCoffeeCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (possibleCups - wantedCoffeeCups) +" more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCups + " cup(s) of coffee");
        }
    }

    public static int getPossibleCoffeeCups(int availableWater, int availableMilk, int availableCoffeeBeans) {
        int possibleCupsByBeans = availableCoffeeBeans / COFFEE_BEANS_EACH_CUP;
        int possibleCupsByMilk = availableMilk / MILK_EACH_CUP;
        int possibleCupsByWater = availableWater / WATER_EACH_CUP;

        return Math.min(possibleCupsByBeans,
                Math.min(possibleCupsByMilk, possibleCupsByWater));
    }

}