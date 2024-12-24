package ingij.saling;
// package rennspiel;

/**Eine Klasses die aus einem Vehicle und einer Sm(Statemachine fürs das Vehicle) besteht.*/
public class SmVehicle {
  
  private Vehicle vehicle;
  private Sm sm;

  public SmVehicle (Vehicle vehicle, Sm sm) {
    this.vehicle = vehicle;
    this.sm = sm;
  }
  
  /**Ruft die getXPos() des Vehicles auf.
   * @return  X-Position des Vehicles.*/	
  public double runGetXPos() {
    return 0.0;
  }
  
  /**Ruft die getYPos() des Vehicles auf.
   * @return  Y-Position des Vehicles.*/	
  public double runGetYPos() {
    return 0.0;
  }
  
  /**Ruft die simu() des Vehicles auf.*/	
  public void runSimulate() {
    ;
  }
  
  /**Ruft die statemach(char input) 
   * der Sm(Statemachine des Vehicles) auf.
   * @param input ein char aus dem Rennspiel. Mögliche strings sind d(runter), u(hoch), r(bremsen), a(beschleunigen), n(neutral/rollen).*/	
  public void runStateMach(char input) {
    ;
  }

  /**Ruft die getVehStr() des Vehicles auf,
   * und ruft die getStateStr() der Sm(Statemachine des Vehicles) auf.
   * @return Eine Zeichenkette, welche die Position, Geschwindigkeit,
   * Beschleunigung und den Zustand(off, neut, acc, dec) des Vehicles 
   * anzeigt.*/	
  public String getSmVehStr() {
    return "";
  }
}
