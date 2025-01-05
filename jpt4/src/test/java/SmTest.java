import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ingij.saling.Sm;
import ingij.saling.Vehicle;

public class SmTest {    
    private Sm sm = new Sm(new Vehicle());
    String state_at_start = this.sm.getStateStr();

    @Test
    public void test_state_string() {
        assertEquals("Aktueller Zustand: off\n", state_at_start);
    }    
    
    @Test
    public void test_inputs() {
        // 'n'
        this.execute_motion_asserts('n');
        // 'a'
        this.execute_motion_asserts('a');
        // 'u'
        this.execute_motion_asserts('u');
        // 'r'
        this.execute_motion_asserts('r');
        // 'd'
        this.execute_motion_asserts('d');
    }

    /**
     * @param state_machine_execution_input Ein char, der den zulässigen Eingabe-chars der statemach(char input) der Sm-Klasse entspricht
     * */
    private void execute_motion_asserts(char state_machine_execution_input) {
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
    }

    private String extract_actual_state(String state_string) {
        return state_string.substring(state_string.indexOf(":") + 2, state_string.indexOf("\n"));
    }
}
