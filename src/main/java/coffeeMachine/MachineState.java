package coffeeMachine;

public enum MachineState {
    INPUT ("Write action (buy, fill, take, remaining, exit): "),
    RUN,
    BUY,
    FILL_RESOURCES,
    TAKE_MONEY,
    REMAINING_RESOURCES,
    EXIT;

    private String stateMessage;

    MachineState machineState;
    CoffeeMachine coffeeMachine;

    MachineState() {

    }

    MachineState(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getStateMessage() {
        return stateMessage;
    }


    INPUT {
        @Override
        public void State machineState (CoffeeMachine coffeeMachine) {
            machineState  = State.INPUT;
            System.out.println(machineState.stateMessage);
         }
    },

    BUY{
        @Override
        public static void State machineState (CoffeeMachine coffeeMachine) {
            cofeeMachine.buy();
            machineState = State.INPUT;
        }
    },

    RUN {
        @Override
                public static MachineState machineState (CoffeeMachine coffeeMachine) {

            String action = scanner.nextLine();
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
            };
        }
    }

    public abstract MachineState machineState (CoffeeMachine coffeeMachine);
}




