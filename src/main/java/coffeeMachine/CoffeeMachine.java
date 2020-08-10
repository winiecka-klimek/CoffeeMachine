package coffeeMachine;


public class CoffeeMachine {

//    private CoffeeType coffeeType;
//    private MachineState machineState;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    String input;
    CoffeeType coffeeType;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money =  money;
//        this.machineState = MachineState.RUN;
    }

    private String getInput() {
        return input;
    }

    private boolean isEnoughWater() {
        if (water < coffeeType.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else {
            return true;
        }
    }

    private boolean isEnoughMilk() {
        if (milk < coffeeType.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else {
            return true;
        }
    }

    private boolean isEnoughCoffeeBeans() {
        if (beans < coffeeType.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else {
            return true;
        }
    }

    private boolean isEnoughCups() {
        if (cups ==  0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            return true;
        }
    }

    private boolean isEnoughResources() {
        if(isEnoughWater() && isEnoughMilk() && isEnoughCoffeeBeans() && isEnoughCups()) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else {
            return isEnoughWater() && isEnoughMilk() && isEnoughCoffeeBeans() && isEnoughCups();
        }
    }

    void buy() {
        isEnoughResources();
        makeCoffee();
        charge();
    }

    protected void chooseCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String chosenCoffee = input;
        switch (chosenCoffee) {
            case "1":
                coffeeType = CoffeeType.ESPRESSO;
                break;
            case "2":
                coffeeType = CoffeeType.LATTE;
                break;
            case "3":
                coffeeType = CoffeeType.CAPPUCCINO;
                break;
            case "break":
                break;
        }
    }

    void makeCoffee() {
        water -= coffeeType.getWater();
        milk -= coffeeType.getMilk();
        beans -= coffeeType.getCoffeeBeans();
        cups --;
        money += coffeeType.getCost();

    }

    void charge() {
    money -= coffeeType.getCost();
    }

    void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    void fill() {
        fillWater();
        fillMilk();
        fillBeans();
        fillCups();
    }

    void fillWater() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += Integer.parseInt(input);
    }

    void fillMilk() {
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += Integer.parseInt(input);
    }

    void fillBeans() {
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += Integer.parseInt(input);
    }

    void fillCups() {
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += Integer.parseInt(input);
    }

    void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    void exit() {
    System.exit(0);
    }
}
