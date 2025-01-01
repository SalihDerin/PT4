import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ingij.saling.Sm;
import ingij.saling.Vehicle;

public class SmTest {    
    private Sm sm = new Sm(new Vehicle());
    String state_at_start = this.sm.getStateStr();

    @Test
    public void test_state_string() {
        assertEquals("Aktueller Zustand: off\nAktuelle Fahrzeugposition: (0.0|256.0)", state_at_start);
    }    
    
    // @Test
    public void test_inputs() {

        // !!! TODO: Die Methoden ausbauen und die Testfälle refactoren !!!

        // 'a'
        String state_prior = this.sm.getStateStr();
        this.sm.statemach('a');
        String state_after = this.sm.getStateStr();
        assertNotEquals(state_prior, state_after);
        assertEquals("acc", state_after.substring(state_after.indexOf(":") + 2, state_after.indexOf("\n") - 1));
        assertNotEquals(state_prior.substring(state_prior.indexOf("(") + 1, state_prior.indexOf("|") - 1), state_after.substring(state_after.indexOf("(") + 1, state_after.indexOf("|") - 1));
        assertEquals(state_prior.substring(state_prior.indexOf("|") + 1, state_prior.indexOf(")") - 1), state_after.substring(state_after.indexOf("|") + 1, state_after.indexOf(")") - 1));

        // 'r'
        state_prior = state_after;
        this.sm.statemach('r');
        state_after = this.sm.getStateStr();
        assertNotEquals(state_prior, state_after);
        assertEquals("dec", state_after.substring(state_after.indexOf(":") + 2, state_after.indexOf("\n") - 1));
        assertNotEquals(state_prior.substring(state_prior.indexOf("(") + 1, state_prior.indexOf("|") - 1), state_after.substring(state_after.indexOf("(") + 1, state_after.indexOf("|") - 1));
        assertEquals(state_prior.substring(state_prior.indexOf("|") + 1, state_prior.indexOf(")") - 1), state_after.substring(state_after.indexOf("|") + 1, state_after.indexOf(")") - 1));


        // 'u'



        // 'd'



        // 'n'



    }

    private int extract_x_position(String state_string) {
        return 0;
    }

    private int extract_y_position(String state_string) {
        return 0;
    }

    private String extract_actual_state(String state_string) {
        return "";
    }
}
