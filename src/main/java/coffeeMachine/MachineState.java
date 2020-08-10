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
        public void MachineState machineState (CoffeeMachine coffeeMachine) {
//            machineState  = State.INPUT;
            System.out.println(machineState.stateMessage);
         }
    },

    BUY{
        @Override
        public static void MachineState machineState (CoffeeMachine coffeeMachine) {
            coffeeMachine.buy();
            machineState = MachineState.INPUT;
        }
    },


    TAKE_MONEY {
        @Override
        public static void MachineState machineState (CoffeeMachine coffeeMachine) {
            coffeeMachine.takeMoney();
            machineState = MachineState.INPUT;
        }
    },

    REMAINING_RESOURCES {
        @Override
        public static void MachineState machineState (CoffeeMachine coffeeMachine) {
            coffeeMachine.remaining();
            machineState = MachineState.INPUT;
        }
    },

    EXIT {
        @Override
        public static void MachineState machineState (CoffeeMachine coffeeMachine) {
            coffeeMachine.exit();
        }
    },

    RUN {
        @Override
                public static void MachineState machineState (CoffeeMachine coffeeMachine) {
            machineState = MachineState.INPUT;

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




