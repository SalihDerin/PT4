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
    
    @Test
    public void test_inputs() {
        // 'a'
        this.execute_motion_asserts('a', 1, 0);
        // 'u'
        this.execute_motion_asserts('u', 1, -1);
        // reset um wieder einen definierten Anfangszustand zu haben
        this.sm = new Sm(new Vehicle());
        // 'r'
        this.execute_motion_asserts('r', -1, 0);
        // 'd'
        this.execute_motion_asserts('d', -1, 1);
        // 'n'
        this.execute_motion_asserts('n', -1, 0);
    }

    /**
     * @param state_machine_execution_input Ein char, der den zulässigen Eingabe-chars der statemach(char input) der Sm-Klasse entspricht
     * @param expected_x_position_behaviour Ein int-Wert, der 3 Fälle angibt: 0: Die x-Position hat sich nicht geändert; >0: Die x-Positionsdifferenz ist positiv; <0: Die x-Positionsdifferenz ist negativ
     * @param expected_y_position_behaviour Ein int-Wert, der 3 Fälle angibt: 0: Die y-Position hat sich nicht geändert; >0: Die y-Positionsdifferenz ist positiv; <0: Die y-Positionsdifferenz ist negativ
     * */
    private void execute_motion_asserts(char state_machine_execution_input, int expected_x_position_behaviour, int expected_y_position_behaviour) {
        String state_prior = this.sm.getStateStr();
        this.sm.statemach(state_machine_execution_input);
        String state_after = this.sm.getStateStr();

        // Zustandsstring muss sich verändert haben
        assertNotEquals(state_prior, state_after);

        // Abgleich des Zustands
        switch (state_machine_execution_input) {
            case 'a':
                assertEquals("acc", this.extract_actual_state(state_after));
                break;
            case 'u':
                assertEquals("neut", this.extract_actual_state(state_after));
                break;
            case 'r':
                assertEquals("dec", this.extract_actual_state(state_after));
                break;
            case 'd':
                assertEquals("neut", this.extract_actual_state(state_after));
                break;
            case 'n':
                assertEquals("neut", this.extract_actual_state(state_after));
                break;
        }

        // Abgleich der x-Position
        if (expected_x_position_behaviour == 0) {
            assertEquals(this.extract_x_position(state_prior), this.extract_x_position(state_after));
        } else if (expected_x_position_behaviour < 0) {
            assertTrue(this.extract_x_position(state_prior) > this.extract_x_position(state_after));
        } else if (expected_x_position_behaviour > 0) {
            assertTrue(this.extract_x_position(state_prior) < this.extract_x_position(state_after));
        }

        // Abgleich der y-Position
        if (expected_y_position_behaviour == 0) {
            assertEquals(this.extract_y_position(state_prior), this.extract_y_position(state_after));
        } else if (expected_y_position_behaviour < 0) {
            assertTrue(this.extract_y_position(state_prior) > this.extract_y_position(state_after));
        } else if (expected_y_position_behaviour > 0) {
            assertTrue(this.extract_y_position(state_prior) < this.extract_y_position(state_after));
        }
    }

    private double extract_x_position(String state_string) {
        return Double.parseDouble(state_string.substring(state_string.indexOf("(") + 1, state_string.indexOf("|") - 1));
    }

    private double extract_y_position(String state_string) {
        return Double.parseDouble(state_string.substring(state_string.indexOf("|") + 1, state_string.indexOf(")") - 1));
    }

    private String extract_actual_state(String state_string) {
        return state_string.substring(state_string.indexOf(":") + 2, state_string.indexOf("\n"));
    }
}
