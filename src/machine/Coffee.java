package machine;

public enum Coffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int disposableCups;
    private final int money;

    Coffee(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public int getWaterNeeded() {
        return water;
    }

    public int getMilkNeeded() {
        return milk;
    }

    public int getCoffeeBeansNeeded() {
        return coffeeBeans;
    }

    public int getDisposableCupsNeeded() {
        return disposableCups;
    }

    public int getMoneyNeeded() {
        return money;
    }
}