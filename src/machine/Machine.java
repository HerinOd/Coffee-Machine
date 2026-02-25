package machine;

public class Machine {

    private static int water = 400; // id: -1
    private static int milk = 540; // id: -2
    private static int coffeeBeans = 120; // id: -3
    private static int disposableCups = 9; // id: -4
    private static int money = 550;

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
    public static int makeEspresso() {
        if ((water >= 250) && (coffeeBeans >= 16) && (disposableCups >= 1)) {
            water -= 250;
            coffeeBeans -= 16;
            disposableCups -= 1;
            money += 4;
            return 1;
        } else if (water < 250) {
            return -1;
        } else if (coffeeBeans < 16) {
            return -3;
        } else {
            return -4;
        }
    }

    public static int makeLatte() {
        if ((water >= 350) && (milk >= 75) && (coffeeBeans >= 20) && (disposableCups >= 1)) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            disposableCups -= 1;
            money += 7;
            return 1;
        } else if (water < 350) {
            return -1;
        } else if (milk < 75) {
            return -2;
        } else if (coffeeBeans < 20) {
            return -3;
        } else {
            return -4;
        }
    }

    public static int makeCappuccino() {
        if ((water >= 200) && (milk >= 100) && (coffeeBeans >= 12) && (disposableCups >= 1)) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            disposableCups -= 1;
            money += 6;
            return 1;
        } else if (water < 200) {
            return -1;
        } else if (milk < 100) {
            return -2;
        } else if (coffeeBeans < 12) {
            return -3;
        } else {
            return -4;
        }
    }

    //Get Resources
    public static int getWater() {
        return water;
    }

    public static int getMilk() {
        return milk;
    }

    public static int getCoffeeBeans() {
        return coffeeBeans;
    }

    public static int getDisposableCups() {
        return disposableCups;
    }

    public static int getMoney() {
        return money;
    }

}
