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
        //      -> up und down sind wahrscheinlich neutral state am besten

        // 'a'
        String state_prior = this.sm.getStateStr();
        this.sm.statemach('a');
        String state_after = this.sm.getStateStr();
        // Zustandsstring muss sich verändert haben
        assertNotEquals(state_prior, state_after);
        // Zustand muss passen
        assertEquals("acc", this.extract_actual_state(state_after));
        // x-Position muss sich geändert haben
        assertNotEquals(this.extract_x_position(state_prior), this.extract_x_position(state_after));
        // x-Position muss größer als die vorherige sein
        assertTrue(this.extract_x_position(state_prior) < this.extract_x_position(state_after));
        // y-Position darf sich nicht verändert haben
        assertEquals(this.extract_y_position(state_prior), this.extract_y_position(state_after));

        // 'u'
        state_prior = state_after;
        this.sm.statemach('n');
        state_after = this.sm.getStateStr();
        // Zustandsstring muss sich verändert haben
        assertNotEquals(state_prior, state_after);
        // Zustand muss passen
        assertEquals("neut", this.extract_actual_state(state_after));
        // x-Position muss sich geändert haben
        assertNotEquals(this.extract_x_position(state_prior), this.extract_x_position(state_after));
        // x-Position muss größer als die vorherige sein
        assertTrue(this.extract_x_position(state_prior) < this.extract_x_position(state_after));
        // y-Position muss sich geändert haben
        assertNotEquals(this.extract_y_position(state_prior), this.extract_y_position(state_after));
        // y-Position muss kleiner als vorher sein
        assertTrue(this.extract_y_position(state_prior) > this.extract_y_position(state_after));

        // 'r'
        state_prior = state_after;
        this.sm.statemach('r');
        state_after = this.sm.getStateStr();
        // Zustandsstring muss sich verändert haben
        assertNotEquals(state_prior, state_after);
        // Zustand muss passen
        assertEquals("dec", this.extract_actual_state(state_after));
        // x-Position muss sich geändert haben
        assertNotEquals(this.extract_x_position(state_prior), this.extract_x_position(state_after));
        // x-Position muss kleiner als die vorherige sein
        // y-Position darf sich nicht verändert haben
        assertEquals(this.extract_y_position(state_prior), this.extract_y_position(state_after));

        // 'd'
        state_prior = state_after;
        this.sm.statemach('n');
        state_after = this.sm.getStateStr();
        // Zustandsstring muss sich verändert haben
        assertNotEquals(state_prior, state_after);
        // Zustand muss passen
        assertEquals("neut", this.extract_actual_state(state_after));
        // x-Position muss sich geändert haben
        assertNotEquals(this.extract_x_position(state_prior), this.extract_x_position(state_after));
        // x-Position muss ein positive Differenz zur vorherigen Position haben
        assertTrue(this.extract_x_position(state_prior) < this.extract_x_position(state_after));
        // y-Position muss sich geändert haben
        assertNotEquals(this.extract_y_position(state_prior), this.extract_y_position(state_after));
        // y-Position muss kleiner als vorher sein
        assertTrue(this.extract_y_position(state_prior) < this.extract_y_position(state_after));


        // 'n'
        state_prior = state_after;
        this.sm.statemach('n');
        state_after = this.sm.getStateStr();
        // Zustandsstring muss sich verändert haben
        assertNotEquals(state_prior, state_after);
        // Zustand muss passen
        assertEquals("neut", this.extract_actual_state(state_after));
        // x-Position muss sich geändert haben
        assertNotEquals(this.extract_x_position(state_prior), this.extract_x_position(state_after));
        // y-Position darf sich nicht verändert haben
        assertEquals(this.extract_y_position(state_prior), this.extract_y_position(state_after));
    }

    private int extract_x_position(String state_string) {
        return Integer.parseInt(state_string.substring(state_string.indexOf("(") + 1, state_string.indexOf("|") - 1));
    }

    private int extract_y_position(String state_string) {
        return Integer.parseInt(state_string.substring(state_string.indexOf("|") + 1, state_string.indexOf(")") - 1));
    }

    private String extract_actual_state(String state_string) {
        return state_string.substring(state_string.indexOf(":") + 2, state_string.indexOf("\n") - 1);
    }
}
