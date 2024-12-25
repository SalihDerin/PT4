import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ingij.saling.Complex;
import ingij.saling.Vehicle;;

public class VehicleTest {
    private Vehicle auto = new Vehicle();
    private Complex start_position = this.get_current_position();

    @Test
    public void test_car_movement() {
        
        // Für accel() prüfen
        this.auto.accel();
        this.auto.simu();
        double current_x_position = this.get_current_position().re();
        assertNotEquals(this.start_position.re(), current_x_position);
        assertEquals(this.start_position.im(), get_current_position().im());
        this.auto.roll();
        this.auto.simu();
        assertNotEquals(current_x_position, this.get_current_position().re());
        assertEquals(this.start_position.im(), get_current_position().im());
        this.auto.up();
        this.auto.simu();
        double current_y_position = this.get_current_position().im();
        assertNotEquals(this.start_position.im(), current_y_position);
        this.auto.roll();
        assertNotEquals(current_y_position, this.get_current_position());
        
        // Alles resetten; this.auto.urzustand() wäre logischer, aber urzustand() ist an diesem Punkt noch nicht getestet
        this.auto = new Vehicle();

        // Für decel() prüfen
        this.auto.decel();
        this.auto.simu();
        current_x_position = this.get_current_position().re();
        assertNotEquals(this.start_position.re(), current_x_position);
        assertTrue(0 > current_x_position);
        assertEquals(this.start_position.im(), get_current_position().im());
        this.auto.roll();
        this.auto.simu();
        assertNotEquals(current_x_position, this.get_current_position().re());
        assertTrue(0 > current_x_position);
        assertEquals(this.start_position.im(), get_current_position().im());
        this.auto.down();
        this.auto.simu();
        current_y_position = this.get_current_position().im();
        assertNotEquals(this.start_position.im(), current_y_position);
        this.auto.roll();
        assertNotEquals(current_y_position, this.get_current_position());
        
        // Alles resetten
        this.auto = new Vehicle();
    }

    @Test
    public void stops_at_zero_without_active_force() {
        for (int i=0; i<6; i++) {
            this.auto.accel();
            this.auto.simu();
        }
        assertNotEquals(this.start_position.re(), this.get_current_position().re());
        while (this.get_current_position().re() != this.start_position.re()) {
            this.auto.roll();
        }
        assertEquals(this.start_position.re(), this.get_current_position().re());
        this.auto.roll();
        assertEquals(this.start_position.re(), this.get_current_position().re());
    }
    
    @Test
    public void does_reset_correctly() {

        // auto laufen lassen -> urzustand() aufrufen -> Position prüfen -> 1 "Frame" laufen lassen -> Position muss Anfangswert haben
        // Für accel() prüfen
        this.auto.accel();
        this.auto.simu();
        this.auto.urzustand();
        assertEquals(this.start_position.re(), this.get_current_position().re());
        this.auto.simu();
        assertEquals(this.start_position.re(), this.get_current_position().re());

        // Für decel() prüfen
        this.auto.decel();
        this.auto.simu();
        this.auto.urzustand();
        assertEquals(this.start_position.re(), this.get_current_position().re());
        this.auto.simu();
        assertEquals(this.start_position.re(), this.get_current_position().re());
    }

    private Complex get_current_position() {
        return new Complex(this.auto.getXPos(), this.auto.getYPos());
    }
}
