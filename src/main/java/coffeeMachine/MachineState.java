package coffeeMachine;

public enum MachineState {

    INPUT {
        @Override
        public MachineState machineState(CoffeeMachine coffeeMachine) {
//            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = coffeeMachine.getInput();
            switch (action) {
                case "buy":
                    return BUY;
                case "fill":
                    return FILL_RESOURCES;
                case "take":
                    return TAKE_MONEY;
                case "remaining":
                    return REMAINING_RESOURCES;
                case "exit":
                    return EXIT;
                default:
                    return INPUT;
            }
        }
    },

    BUY {
        @Override
        public MachineState machineState(CoffeeMachine coffeeMachine) {
            coffeeMachine.buy();
            return MachineState.INPUT;
        }
    },

    TAKE_MONEY {
        @Override
        public MachineState machineState(CoffeeMachine coffeeMachine) {
            coffeeMachine.takeMoney();
           return MachineState.INPUT;
        }
    },

    REMAINING_RESOURCES {
        @Override
        public MachineState machineState(CoffeeMachine coffeeMachine) {
            coffeeMachine.remaining();
            return MachineState.INPUT;
        }
    },

    FILL_RESOURCES {
        @Override
        public MachineState machineState(CoffeeMachine coffeeMachine) {
            coffeeMachine.fill();
            return MachineState.INPUT;
        }
    },

    EXIT {
        @Override
        public MachineState machineState(CoffeeMachine coffeeMachine) {
            coffeeMachine.exit();
            return null;
        }
    };

    public abstract MachineState machineState(CoffeeMachine coffeeMachine);
}




