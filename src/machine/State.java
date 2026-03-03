package machine;

public enum State {
    CHOOSING_ACTION {
        @Override
        public String handleState(Machine machine, String input) {
            switch (input) {
                case "buy" -> {
                    machine.setState(BUYING_COFFEE);
                    return "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";
                }
                case "fill" -> {
                    machine.setState(FILLING_WATER);
                    return "\nWrite how many ml of water you want to add:";
                }
                case "take" -> {
                    int currentMoney = machine.getMoney();
                    machine.takeMoney();
                    return "I gave you $" + currentMoney + "\nWrite action (buy, fill, take, clean, remaining, exit):";
                }
                case "remaining" -> {
                    machine.setState(SHOWS_REMAINING);
                    return SHOWS_REMAINING.handleState(machine, input);
                }
                default -> {
                    machine.setState(CHOOSING_ACTION);
                    return "Invalid Option";
                }
            }
        }
    },

    REQUIRES_CLEANING {
        @Override
        public String handleState(Machine machine, String input) {
            if (input.equals("clean")) {
                machine.cleanMachine();
                machine.setState(CHOOSING_ACTION);
                return "I have been cleaned!" + "\nWrite action (buy, fill, take, clean, remaining, exit):";
            } else {
                return "I need cleaning!" + "\nWrite action (buy, fill, take, clean, remaining, exit):";
            }
        }
    },

    SHOWS_REMAINING {
        @Override
        public String handleState(Machine machine, String input){
            machine.setState(CHOOSING_ACTION);
            return String.format("\nThe coffee machine has:\n" +
                            "%d ml of water\n" +
                            "%d ml of milk\n" +
                            "%d g of coffee beans\n" +
                            "%d disposable cups\n" +
                            "$%d of money\n" + "\nWrite action (buy, fill, take, clean, remaining, exit):"
                    , machine.getWater(), machine.getMilk(), machine.getCoffeeBeans(), machine.getDisposableCups(), machine.getMoney());
        }
    },

    BUYING_COFFEE {
        @Override
        public String handleState(Machine machine, String input) {
            if (machine.getCupsMade() == 10) {
                machine.setState(REQUIRES_CLEANING);
                return REQUIRES_CLEANING.handleState(machine, input);
            }
            machine.setState(CHOOSING_ACTION);
            switch (input) {
                case "1":
                    return machine.makeCoffee(Coffee.ESPRESSO) + "\nWrite action (buy, fill, take, clean, remaining, exit):";
                case "2":
                    return machine.makeCoffee(Coffee.LATTE) + "\nWrite action (buy, fill, take, clean, remaining, exit):";
                case "3":
                    return machine.makeCoffee(Coffee.CAPPUCCINO) + "\nWrite action (buy, fill, take, clean, remaining, exit):";
                case "back":
                    machine.setState(CHOOSING_ACTION);
                    return "\nWrite action (buy, fill, take, clean, remaining, exit):";
                default:
                    return "Invalid Option" + "\nWrite action (buy, fill, take, clean, remaining, exit):";
            }
        }
    },

    //FILLING_RESOURCES
    FILLING_WATER {
        @Override
        public String handleState(Machine machine, String input) {
            machine.fillItems(Integer.parseInt(input), 0, 0, 0);
            machine.setState(FILLING_MILK);
            return "Write how many ml of milk you want to add:";
        }
    },
    FILLING_MILK {
        @Override
        public String handleState(Machine machine, String input) {
            machine.fillItems(0, Integer.parseInt(input), 0, 0);
            machine.setState(FILLING_COFFEE_BEANS);
            return "Write how many grams of coffee beans you want to add:";
        }
    },
    FILLING_COFFEE_BEANS {
        @Override
        public String handleState(Machine machine, String input) {
            machine.fillItems(0, 0, Integer.parseInt(input), 0);
            machine.setState(FILLING_DISPOSABLE_CUPS);
            return "Write how many disposable cups you want to add:";
        }
    },
    FILLING_DISPOSABLE_CUPS {
        @Override
        public String handleState(Machine machine, String input) {
            machine.fillItems(0, 0, 0, Integer.parseInt(input));
            machine.setState(CHOOSING_ACTION);
            return "Write action (buy, fill, take, clean, remaining, exit):";
        }
    };

    public abstract String handleState(Machine machine, String input);
}