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
        // 'a'
        this.sm.statemach('a');
        

        // 'r'



        // 'u'



        // 'd'



        // 'n'



    }
}
