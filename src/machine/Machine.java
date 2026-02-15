package machine;

public class Machine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    //Machine Menu
    public static void showMachineState() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", water, milk, coffeeBeans, disposableCups, money);
    }

    //Take
    public static void takeMoney() {
        money -= money;
    }

    public static int showMoneyAmount() {
        return money;
    }

    //Fill
    public static void fillItems(int waterToAdd, int milkToAdd, int coffeeBeansToAdd, int disposableCupsToAdd) {
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        disposableCups += disposableCupsToAdd;
    }

    //Buy
    public static void makeEspresso() {
        water -= 250;
        coffeeBeans -= 16;
        disposableCups -= 1;
        money += 4;
    }

    public static void makeLatte() {
        water -= 350;
        milk -= 75;
        coffeeBeans -= 20;
        disposableCups -= 1;
        money += 7;
    }

    public static void makeCappuccino() {
        water -= 200;
        milk -= 100;
        coffeeBeans -= 12;
        disposableCups -= 1;
        money += 6;
    }

}
