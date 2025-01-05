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
      this.urzustand();
      setIcon(new ImageIcon(Vehicle.class.getResource("/auto_png_256_256.png")));
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
      setBounds((int) this.s.re(), (int) this.s.im(), 256, 256);
      setVisible(true);
   }
	
   /**Das Fahrzeug rollt.*/  
   public void roll() {
      // F_r=m*g*c_r
      this.fAkt.setReal(this.mass*9.81*0.015);
      this.a.setReal(this.fAkt.re()/this.mass*(-1));
      if (this.v.re() < 0) this.a.setReal(this.a.re()*(-1));
      if (this.v.re() == 0.0 || (this.v.re() * (this.v.re() + this.a.re() * Vehicle.dt)) < 0) {
         this.a.setReal(0.0);
         this.v.setReal(0.0);
      }
   }

   /**Das Fahrzeug beschleunigt in x-Richtung positiv.*/
   public void accel() {
      this.a.setImag(0.0);
      this.fAkt.setReal(this.fMax);
      this.a.setReal(this.fAkt.re()/this.mass);
   }

   /**Das Fahrzeug beschleunigt in x-Richtung negativ.*/
   public void decel() {
      this.a.setImag(0.0);
      this.fAkt.setReal(this.fMax*(-1));
      this.a.setReal(this.fAkt.re()/this.mass);
   }

   /**Das Fahrzeug beschleunigt in y-Richtung negativ.*/
   public void up() {
      this.roll();
      this.a.setImag(-0.25);
   }

   /**Das Fahrzeug beschleunigt in y-Richtung positiv.*/
   public void down() {
      this.roll();
      this.a.setImag(0.25);
   }

   /**Aktualisiert den Zustand des Fahrzeugs. Der neue Zustand, den das Fahrzeugs im nächsten Zeitschritt einnimmt, hängt von der aktuellen Kraft ab.*/
   public void simu() {
      // a=v/t; v=s/t
      this.v.setReal(this.v.re() + this.a.re() * Vehicle.dt);
      this.s.setReal(this.s.re() + this.v.re() * Vehicle.dt);
      
      // physikalisch inakkurat, aber...joa :P      
      if (Math.abs(this.a.im()) == 0.25 && this.v.re() > 0) {
         this.s.setImag(this.s.im() + this.v.re() * Vehicle.dt * this.a.im());
      } else if (Math.abs(this.a.im()) == 0.25 && this.v.re() < 0) {
         this.s.setImag(this.s.im() + this.v.re() * Vehicle.dt * this.a.im() * (-1.0));
      }
      
      setBounds((int) this.s.re(), (int) this.s.im(), 256, 256);
      this.a = new Complex(0.0, 0.0);
   }

   /**Setzt das Fahrzeug in den Urzustand zurück. Also alle Kräfte auf Null und Startposition.*/
   public void urzustand() {
      this.mass = 1500;
      this.fMax = 4170;
      this.fAkt = new Complex(0, 0);
      this.a = new Complex(0, 0);
      this.v = new Complex(0, 0);
      this.s = new Complex(0, 256);
      setBounds((int) this.s.re(), (int) this.s.im(), 256, 256);
      setVisible(true);
   }

   /**Gibt die x-Position des Vehicles zurück.*/
   public double getXPos() {
      return this.s.re();
   }

   /**Gibt die y-Position des Vehicles zurück.*/
   public double getYPos() {
      return this.s.im();
   }

}
