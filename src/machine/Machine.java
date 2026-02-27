package machine;

public class Machine {
    private State currentState;

    private int cupsMade = 0;

    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public Machine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        disposableCups = 9;
        money = 550;
        currentState = State.CHOOSING_ACTION;
    }

    //Process
    public String processInput(String input) {
        return currentState.handleState(this, input);
    }

    public void setState(State newState) {
        currentState = newState;
    }

    //Clean
    public void cleanMachine() {
        cupsMade = 0;
    }

    //Take
    public void takeMoney() {
        money = 0;
    }

    //Fill
    public void fillItems(int waterToAdd, int milkToAdd, int coffeeBeansToAdd, int disposableCupsToAdd) {
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        disposableCups += disposableCupsToAdd;
    }

    //Buy
    public String makeCoffee(Coffee typeOfCoffee) {
        if ((water >= typeOfCoffee.getWater()) && (milk >= typeOfCoffee.getMilk()) && (coffeeBeans >= typeOfCoffee.getCoffeeBeans()) && (disposableCups >= typeOfCoffee.getDisposableCups())) {
            water -= typeOfCoffee.getWater();
            milk -= typeOfCoffee.getMilk();
            coffeeBeans -= typeOfCoffee.getCoffeeBeans();
            disposableCups -= typeOfCoffee.getDisposableCups();
            money += typeOfCoffee.getMoney();
            cupsMade++;
            return "I have enough resources, making you a coffee!";
        } else if (water < typeOfCoffee.getWater()) {
            return "Sorry, not enough water!";
        } else if (milk < typeOfCoffee.getMilk()) {
            return "Sorry, not enough milk!";
        } else if (coffeeBeans < typeOfCoffee.getCoffeeBeans()) {
            return "Sorry, not enough coffee beans";
        } else {
            return "Sorry, not enough disposable cups!";
        }
    }

    //Get Resources
    public int getWater() {
        return water;
    }
    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public int getCupsMade() {
        return cupsMade;
    }

}