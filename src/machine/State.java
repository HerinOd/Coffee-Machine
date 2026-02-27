package machine;

public enum State {
    CHOOSING_ACTION {
        @Override
        public String handleState(Machine machine, String input) {
            if (input.equals("buy")) {
                if ((machine.getCupsMade() % 10 == 0) &&(machine.getCupsMade() != 0)) {
                    machine.setState(CHOOSING_ACTION);
                    return "I need cleaning!" + "\n\nWrite action (buy, fill, take, clean, remaining, exit):";
                } else {
                    machine.setState(BUYING_COFFEE);
                    return "\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";
                }
            } else if (input.equals("fill")) {
                machine.setState(FILLING_WATER);
                return "\nWrite how many ml of water you want to add:";
            } else if (input.equals("take")) {
                int currentMoney = machine.getMoney();
                machine.takeMoney();
                return "I gave you $" + currentMoney + "\n\nWrite action (buy, fill, take, clean, remaining, exit):";
            } else if (input.equals("clean")) {
                machine.cleanMachine();
                return "I have been cleaned!" + "\n\nWrite action (buy, fill, take, clean, remaining, exit):";
            } else if (input.equals("remaining")) {
                machine.setState(SHOW_REMAINING);
                return SHOW_REMAINING.handleState(machine, input);
            } else {
                machine.setState(CHOOSING_ACTION);
                return "Invalid Option";
            }
        }
    },

    SHOW_REMAINING {
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
            machine.setState(CHOOSING_ACTION);
            switch (input) {
                case "1":
                    return machine.makeCoffee(Coffee.ESPRESSO) + "\n\nWrite action (buy, fill, take, clean, remaining, exit):";
                case "2":
                    return machine.makeCoffee(Coffee.LATTE) + "\n\nWrite action (buy, fill, take, clean, remaining, exit):";
                case "3":
                    return machine.makeCoffee(Coffee.CAPPUCCINO) + "\n\nWrite action (buy, fill, take, clean, remaining, exit):";
                case "back":
                    machine.setState(CHOOSING_ACTION);
                    return "\nWrite action (buy, fill, take, clean, remaining, exit):";
                default:
                    return "Invalid Option" + "\n\nWrite action (buy, fill, take, clean, remaining, exit):";
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
