package coffeeMachine;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        MachineState machineState;
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        do {
            coffeeMachine.run();
        } while (coffeeMachine.on());
    }
}

