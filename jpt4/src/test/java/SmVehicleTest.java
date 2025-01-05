import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ingij.saling.*;

public class SmVehicleTest {

    private Vehicle vehicle = new Vehicle();
    private SmVehicle smVehicle = new SmVehicle(this.vehicle, new Sm(this.vehicle));

    @Test
    public void test_run_get_x_pos() {
        assertEquals(0.0, this.smVehicle.runGetXPos());
    }

    @Test
    public void test_run_get_y_pos() {
        assertEquals(256.0, this.smVehicle.runGetYPos());
    }

    @Test
    public void test_get_sm_veh_str() {
        assertEquals("Aktueller Zustand: off\nAktuelle Fahrzeugposition: (0.0|256.0)", this.smVehicle.getSmVehStr());
    }

    @Test
    public void test_run_state_mach() {
        String start_state_str = this.extract_actual_state(this.smVehicle.getSmVehStr());
        this.smVehicle.runStateMach('a');
        String current_state_str = this.extract_actual_state(this.smVehicle.getSmVehStr());
        assertNotEquals(start_state_str, current_state_str);
        assertEquals("acc", current_state_str);
    }

    @Test
    public void test_vehicle_motion () {
        // 'a'
        this.smVehicle.runStateMach('a');
        this.run_simulate_and_execute_motion_asserts(1, 0);
        // 'u'
        this.smVehicle.runStateMach('u');
        this.run_simulate_and_execute_motion_asserts(1, -1);
        // reset um wieder einen definierten Anfangszustand zu haben
        vehicle = new Vehicle();
        smVehicle = new SmVehicle(this.vehicle, new Sm(this.vehicle));
        // 'r'
        this.smVehicle.runStateMach('r');
        this.run_simulate_and_execute_motion_asserts(-1, 0);
        // 'd'
        this.smVehicle.runStateMach('d');
        this.run_simulate_and_execute_motion_asserts(-1, 1);
        // 'n'
        this.smVehicle.runStateMach('n');
        this.run_simulate_and_execute_motion_asserts(-1, 0);
    }

    /**
     * @param expected_x_position_behaviour Ein int-Wert, der 3 Fälle angibt: 0: Die x-Position hat sich nicht geändert; >0: Die x-Positionsdifferenz ist positiv; <0: Die x-Positionsdifferenz ist negativ
     * @param expected_y_position_behaviour Ein int-Wert, der 3 Fälle angibt: 0: Die y-Position hat sich nicht geändert; >0: Die y-Positionsdifferenz ist positiv; <0: Die y-Positionsdifferenz ist negativ
     * */
    private void run_simulate_and_execute_motion_asserts(int expected_x_position_behaviour, int expected_y_position_behaviour) {
        Complex positions_prior = new Complex(this.smVehicle.runGetXPos(), this.smVehicle.runGetYPos());
        this.smVehicle.runSimulate();
        Complex positions_after = new Complex(this.smVehicle.runGetXPos(), this.smVehicle.runGetYPos());

        // Mindestens eine der Positionen muss sich verändert haben (also der Betrag)
        assertNotEquals(Math.sqrt(Math.pow(positions_prior.re(), 2) + Math.pow(positions_prior.im(), 2)), Math.sqrt(Math.pow(positions_after.re(), 2) + Math.pow(positions_after.im(), 2)));

        // Abgleich der x-Position
        if (expected_x_position_behaviour == 0) {
            assertEquals(positions_prior.re(), positions_after.re());
        } else if (expected_x_position_behaviour < 0) {
            assertTrue(positions_prior.re() > positions_after.re());
        } else if (expected_x_position_behaviour > 0) {
            assertTrue(positions_prior.re() < positions_after.re());
        }

        // // Abgleich der y-Position
        if (expected_y_position_behaviour == 0) {
            assertEquals(positions_prior.im(), positions_after.im());
        } else if (expected_y_position_behaviour < 0) {
            assertTrue(positions_prior.im() > positions_after.im());
        } else if (expected_y_position_behaviour > 0) {
            assertTrue(positions_prior.im() < positions_after.im());
        }
    }

    private String extract_actual_state(String state_string) {
        return state_string.substring(state_string.indexOf(":") + 2, state_string.indexOf("\n"));
    }
}
