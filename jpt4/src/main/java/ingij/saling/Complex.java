// package rennspiel;
package ingij.saling;

/** Diese Klasse stellt komplexe Zahlen bereit.*/
public class Complex 
{ private static final double eps=0.0000000000001; // f�r div: Teilen durch Null  

  // die Datenfelder sind intern und gegen Zugriff gesch�tzt.
  // Die Funktionen "re" und "im" weiter unten geben lesenden 
  // Zugriff.
  private double re;
  private double im;
  
  /** Erzeugt die komplexe Zahl 0 + 0j.*/  
  public Complex(){this(0,0);}
  
  /** Erzeugt eine komplexe Zahl.
	  @param real Realteil der komplexen Zahl. 
	  @param imag Imaginaerteil der komplexen Zahl.*/
  public Complex(double real, double imag)
  { this.re=real;
    this.im=imag;
  }
  
  /** Multiplikation. 
      Die komplexe Zahl c1 = a1 + j*b1 wird mit einer anderen, 
      c = a + j*b, multipliziert und das Produkt p zur�ckgegeben.<br> 
      Es gilt: p = (a1 + j*b1)*(a + j*b).
      @param c komplexe Zahl, die multipliziert werden soll.
      @returns Produkt*/
  public Complex mult(Complex c)
  { return new Complex(re*c.re-im*c.im, re*c.im+im*c.re);
  }
  
  /** Addition.
      Die komplexe Zahl c1 = a1 + j*b1 wird zu  einer anderen, 
      c = a + j*b addiert und die Summe s zurueckgegeben. <br>    
      Es gilt: s = (a1 + a) + j*(b1 + b).
      @param c komplexe Zahl, die addiert werden soll.
      @returns Summe*/ 
  public Complex plus(Complex c)
  { return new Complex(re+c.re, im+c.im);
  }    
  
  /** Division.
      Die komplexe Zahl c1 = a1 + j*b1 wird durch eine andere, 
      c = a + j*b, dividiert und der Quotient q zurueckgegeben.  <br>   
      Es gilt: q = (a1 + j*b1)/(a + j*b)<br> 
      @param c der Divisor, eine komplexe Zahl.
      @returns Quotient
      @throws NullDivExpt, wenn versucht wird, durch Null zu teilen.
      Ist der Betrag von c gleich oder fast gleich Null wird kein
      Quotient berechnet. Fast Null ist hier ein Betrag, der kleiner als 10 exp -12 ist. */
  public Complex div(Complex c) throws NullDivExpt
  { double c_betrag_quadrat=(c.re*c.re)+(c.im*c.im);  
    if(c_betrag_quadrat<eps) throw new Complex.NullDivExpt();
 // Berechnung: Erweitern mit konj. komplexem Nenner.
    return new Complex ((re*c.re + im*c.im)/c_betrag_quadrat,
    				   (-re*c.im + im*c.re)/c_betrag_quadrat);
  }  
  
  /** Wenn versucht wird, durch Null zu teilen, wird ein
  NulldivisionException-Objekt geworfen.*/
  @SuppressWarnings("serial")
  public class NullDivExpt extends RuntimeException{} 

  /** Realteil. 
      Der Realteil der komplexen Zahl wird berechnet und 
      zurueckgegeben.
      @returns Realteil */
  public double re(){return re;}
    
  /** Imaginaerteil. 
      Der Imaginaerteil der komplexen Zahl wird berechnet und 
      zurueckgegeben.
      @returns Imagin�rteil*/
  public double im(){return im;}
  
  /** Realteil setzen. 
      Der Realteil der komplexen Zahl wird gesetzt.
      @param real der Realteil der komplexen Zahl*/ 
  public void setReal(double real) {this.re=real;}
  
  /** Imaginaerteil setzen. 
      Der Imaginaerteil der komplexen Zahl wird gesetzt.
      @param imag der Imaginaerteil der komplexen Zahl*/
  public void setImag(double imag) {this.im=imag;}
}
