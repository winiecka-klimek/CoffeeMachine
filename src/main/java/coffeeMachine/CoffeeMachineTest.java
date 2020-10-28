package coffeeMachine;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

class CoffeeMachineTest {

    @Test
    void shouldFillWater() {
        //given
        CoffeeMachine coffeeMachine = new CoffeeMachine(5,5,5,5,5);
        String input = "4";
        //when
        coffeeMachine.fillWater();
        //than
        assertThat(coffeeMachine.getWater(), is(9));
    }



//    shouldNotFillWater() {
//
//    }


}