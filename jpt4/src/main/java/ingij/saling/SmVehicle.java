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
    return this.vehicle.getXPos();
  }
  
  /**Ruft die getYPos() des Vehicles auf.
   * @return  Y-Position des Vehicles.*/	
  public double runGetYPos() {
    return this.vehicle.getYPos();
  }
  
  /**Ruft die simu() des Vehicles auf.*/	
  public void runSimulate() {
    this.vehicle.simu();
  }
  
  /**Ruft die statemach(char input) 
   * der Sm(Statemachine des Vehicles) auf.
   * @param input ein char aus dem Rennspiel. Mögliche strings sind d(runter), u(hoch), r(bremsen), a(beschleunigen), n(neutral/rollen).*/	
  public void runStateMach(char input) {
    this.sm.statemach(input);
  }

  /**Ruft die getVehStr() des Vehicles auf,
   * und ruft die getStateStr() der Sm(Statemachine des Vehicles) auf.
   * @return Eine Zeichenkette, welche die Position, Geschwindigkeit,
   * Beschleunigung und den Zustand(off, neut, acc, dec) des Vehicles 
   * anzeigt.*/	
  public String getSmVehStr() {
    return this.sm.getStateStr() + "Aktuelle Fahrzeugposition: (" + this.vehicle.getXPos() + "|" + this.vehicle.getYPos() + ")";
  }
}
