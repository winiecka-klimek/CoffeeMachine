package coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public MachineState getMachineState() {
        return machineState;
    }

    public void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }

    CoffeeType coffeeType;
    MachineState machineState;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money =  money;

        setMainState();
    }

    public void setMainState() {
        machineState = MachineState.MAIN;
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        chooseAction();
    }

    public void chooseAction() {

        String action = getInput();
        switch (action) {
            case "buy":
                buy();
                machineState = MachineState.BUY;
                setMainState();
                break;
            case "fill":
                fill();
                machineState = MachineState.FILL_RESOURCES;
                setMainState();
                break;
            case "take":
                takeMoney();
                machineState = MachineState.TAKE_MONEY;
                setMainState();
                break;
            case "remaining":
                remaining();
                machineState = MachineState.REMAINING_RESOURCES;
                setMainState();
                break;
            case "exit":
                machineState = MachineState.EXIT;
                exit();
                break;
            default:
                System.out.println("Unrecognized action");
                setMainState();
        }
    }

    public boolean isEnoughWater() {
        if (water < coffeeType.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else {
            return true;
        }
    }

    public boolean isEnoughMilk() {
        if (milk < coffeeType.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else {
            return true;
        }
    }

    public boolean isEnoughCoffeeBeans() {
        if (beans < coffeeType.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else {
            return true;
        }
    }

    public boolean isEnoughCups() {
        if (cups ==  0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            return true;
        }
    }

    public boolean isEnoughResources() {
        return isEnoughWater() && isEnoughMilk() && isEnoughCoffeeBeans() && isEnoughCups();
    }

    public void buy() {
        chooseCoffee();
        if(isEnoughResources()) {
            makeCoffee();
            charge();
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void chooseCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String chosenCoffee = getInput();
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
            case "back":
                setMainState();
                chooseAction();
                break;
        }
    }

    public void makeCoffee() {
        water -= coffeeType.getWater();
        milk -= coffeeType.getMilk();
        beans -= coffeeType.getCoffeeBeans();
        cups --;
    }

    public void charge() {
    money += coffeeType.getCost();
    }

    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void fill() {
        fillWater();
        fillMilk();
        fillBeans();
        fillCups();
    }

    public void fillWater() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += Integer.parseInt(getInput());
    }

    public void fillMilk() {
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += Integer.parseInt(getInput());
    }

    public void fillBeans() {
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += Integer.parseInt(getInput());
    }

    public void fillCups() {
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += Integer.parseInt(getInput());
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + "$ of money");
    }

    public boolean on() {
        return machineState != MachineState.EXIT;
    }

    public void exit() {
    System.exit(0);
    }
}
