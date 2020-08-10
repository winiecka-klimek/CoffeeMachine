package coffeeMachine;

public enum CoffeeType {
    ESPRESSO(16, 250, 0, 4),
    LATTE(20, 350, 75, 7),
    CAPPUCCINO(12, 200, 100, 6);

    int coffeeBeans;
    int water;
    int milk;
    int cost;

    CoffeeType(int coffeeBeans, int water, int milk, int cost) {
        this.coffeeBeans = coffeeBeans;
        this.water = water;
        this.milk = milk;
        this.cost = cost;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCost() {
        return cost;
    }
}
