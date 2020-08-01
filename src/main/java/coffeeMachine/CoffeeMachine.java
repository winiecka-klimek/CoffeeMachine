package coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    package machine;

import java.util.Scanner;

    public class CoffeeMachine {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int water = 400;
            int milk = 540;
            int beans = 120;
            int cups = 9;
            int money = 550;
            int waterPerCup = 200;
            int milkPerCup = 50;
            int coffeeBeansPerCup = 15;

            do {
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                String action = scanner.nextLine();
                if (action.equals("buy")) {
                    int waterCounting = water / waterPerCup;
                    int milkCounting = milk / milkPerCup;
                    int coffeeBeansCounting = beans / coffeeBeansPerCup;
                    int possibleCups = 0;

                    if (waterCounting <= milkCounting) {
                        if (waterCounting <= coffeeBeansCounting) {
                            possibleCups = waterCounting;
                        } else {
                            possibleCups = coffeeBeansCounting;
                        }
                    } else if (milkCounting <= waterCounting) {
                        if (milkCounting <= coffeeBeansCounting) {
                            possibleCups = milkCounting;
                        } else {
                            possibleCups = coffeeBeansCounting;
                        }
                    }
                    if (possibleCups >= 1) {
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                        String coffeeType = scanner.nextLine();
                        switch (coffeeType) {
                            case "1":
                                water -= 250;
                                beans -= 16;
                                cups -= 1;
                                money += 4;
                                break;
                            case "2":
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups -= 1;
                                money += 7;
                                break;
                            case "3":
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups -= 1;
                                money += 6;
                                break;
                            case "break":
                                break;
                        }
                        System.out.println("I have enough resources, making you a coffee!");
                    } else if (possibleCups < 1) {
                        if (waterCounting < 1) {
                            System.out.println("Sorry, not enough water!");
                        } else if (milkCounting < 1) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (coffeeBeansCounting < 1) {
                            System.out.println("Sorry, not enough coffee beans");
                        } else if (cups < 1) {
                            System.out.println("Sorry, not enough cups!");
                        }
                    } System.out.println("Write action (buy, fill, take, remaining, exit): ");
                } else if (action.equals("fill")) {
                    System.out.println("Write how many ml of water do you want to add: ");
                    int addWater = scanner.nextInt();
                    water += addWater;
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int addMilk = scanner.nextInt();
                    milk += addMilk;
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int addBeans = scanner.nextInt();
                    beans += addBeans;
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int addCups = scanner.nextInt();
                    cups += addCups;
                } else if (action.equals("take")) {
                    System.out.println("I gave you $" + money);
                    money = 0;
                } else if (action.equals("remaining")) {
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " of water");
                    System.out.println(milk + " of milk");
                    System.out.println(beans + " of coffee beans");
                    System.out.println(cups + " of disposable cups");
                    System.out.println(money + " of money");
                } else if (action.equals("exit")) {
                    break;
                }

            } while (scanner.hasNext());

        }
    }

//public class CoffeMaker {
//    int water = 400;
//    int milk = 540;
//    int beans = 120;
//    int cups = 9;
//    int money = 550;
//    int waterPerCup = 200;
//    int milkPerCup = 50;
//    int coffeeBeansPerCup = 15;
//
//    public static void chooseAction() {
//        switch (State) {
//            case BUY:
//
//        }

//        public static void buy () {
//            int waterCounting = water / waterPerCup;
//            int milkCounting = milk / milkPerCup;
//            int coffeeBeansCounting = beans / coffeeBeansPerCup;
//            int possibleCups = 0;
//
//            if (waterCounting <= milkCounting) {
//                if (waterCounting <= coffeeBeansCounting) {
//                    possibleCups = waterCounting;
//                } else {
//                    possibleCups = coffeeBeansCounting;
//                }
//            } else if (milkCounting <= waterCounting) {
//                if (milkCounting <= coffeeBeansCounting) {
//                    possibleCups = milkCounting;
//                } else {
//                    possibleCups = coffeeBeansCounting;
//                }
//            }
//            if (possibleCups >= 1)
//        }
//
//        public static void fill {
//            System.out.println("Write how many ml of water do you want to add: ");
//            int addWater = scanner.nextInt();
//            water += addWater;
//            System.out.println("Write how many ml of milk do you want to add: ");
//            int addMilk = scanner.nextInt();
//            milk += addMilk;
//            System.out.println("Write how many grams of coffee beans do you want to add: ");
//            int addBeans = scanner.nextInt();
//            beans += addBeans;
//            System.out.println("Write how many disposable cups of coffee do you want to add: ");
//            int addCups = scanner.nextInt();
//            cups += addCups;
//
//        }
//
//    }
//}
//

}
