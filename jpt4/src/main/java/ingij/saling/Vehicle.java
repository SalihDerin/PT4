package ingij.saling;
// package rennspiel;

import javax.swing.*;

/**Das Vehicle des Spiels; extends JLabel.*/
public class Vehicle extends JLabel {
   
   /**Zeitschritt*/
   public static final double dt = 0.02;
   private double mass;
   private double fMax;
   private Complex fAkt;
   private Complex a;
   private Complex v;
   private Complex s;
  
   public Vehicle() {
      this.mass = 0.0;
      this.fMax = 0.0;
      this.fAkt = null;
      this.a = null;
      this.v = null;
      this.s = null;
      setIcon(new ImageIcon(Vehicle.class.getResource("/auto_png_256_256.png")));
      setBounds(0, 0, 100, 100);
      setVisible(true);
   }

   /**Konstruktor Vehicle.
      @param mass die Masse des Vehicles.
      @param fMax Maximalkraft des Vehicles.
      @param fAkt die aktuell wirkende Kraft am Vehicle.
      @param a die Beschleunigung des Vehicles.
      @param v die Geschwindigkeit des Vehicles.
      @param s die Wegmarke des Vehicles.
   */
   public Vehicle(double mass, double fMax, Complex fAkt, Complex a, Complex v, Complex s) {
      this.mass = mass;
      this.fMax = fMax;
      this.fAkt = fAkt;
      this.a = a;
      this.v = v;
      this.s = s;
      setIcon(new ImageIcon(Vehicle.class.getResource("/auto_png_256_256.png")));
      setBounds(0, 0, 100, 100);
      setVisible(true);
   }
	
   /**Das Fahrzeug rollt.*/  
   public void roll() {
      ;
   }

   /**Das Fahrzeug beschleunigt in x-Richtung positiv.*/
   public void accel() {
      ;
   }

   /**Das Fahrzeug beschleugnigt in x-Richtung negativ.*/
   public void decel() {
      ;
   }

   /**Das Fahrzeug beschleunigt in y-Richtung negativ.*/
   public void up() {
      ;
   }

   /**Das Fahrzeug beschleunigt in y-Richtung positiv.*/
   public void down() {
      ;
   }

   /**Aktualisiert den Zustand des Fahrzeugs. Der neue Zustand, den das Fahrzeugs im nächsten Zeitschritt einnimmt,hängt von der aktuellen Kraft ab.*/
   public void simu() {
      ;
   }

   /**Setzt das Fahrzeug in den Urzustand zurück. Also alle Kräfte auf Null und Startposition.*/
   public void urzustand() {
      ;
   }

   /**Gibt die x-Position des Vehicles zurück.*/
   public double getXPos() {
      return 0.0;
   }

   /**Gibt die y-Position des Vehicles zurück.*/
   public double getYPos() {
      return 0.0;
   }

}
