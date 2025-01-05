package ingij.saling;
// package rennspiel;

/**Die Statemachine hat Zugriff auf das Vehicle aus der SmVehicle-Klasse. Die Statemachine hat eine enumeration vehState {off, neut, acc, dec}.
 * Je nach Zustand und Eingabe des Spielers werden verschiedene Funktionen des Vehicles aufgerufen.
*/
public class Sm {
  
  private Vehicle vehicle;
  private vehState state = vehState.off;
  private int timer;
  private int timeout;

  /**Konstruktor Sm.
  @param vehicle Objekt der Klasse Vehicle. 
  */
  public Sm (Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  /**Die Eingaben des Spielers bestimmen welche Vehicle-Funktionen aufgerufen werden.
   * @param input die Eingabe des Spielers als char. 
   * */
  public void statemach(char input) {
    switch (input) {
      case 'a':
        this.state = vehState.acc;
        this.vehicle.accel();
        break;
      case 'r':
        this.state = vehState.dec;
        this.vehicle.decel();
        break;
      case 'u':
        this.state = vehState.neut;
        this.vehicle.up();
        break;
      case 'd':
        this.state = vehState.neut;
        this.vehicle.down();
        break;
      case 'n':
        this.state = vehState.neut;
        this.vehicle.roll();
        break;
    }
  }	
 
  /**Der aktuelle State der Statemachine 
   * wird als String ausgegeben.
   * @return den aktuellen State als String.
   * */
  public String getStateStr() {
    return "Aktueller Zustand: " + state.toString() + "\n";
  }

}
