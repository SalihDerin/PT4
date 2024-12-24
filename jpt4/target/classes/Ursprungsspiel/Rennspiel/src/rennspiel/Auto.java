package rennspiel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Auto extends JLabel
{ 
  public static final double dt=0.02;
  
  private double massstab=Welt.massstab;	//30 Pixel pro Meter	
  private double masse;
  private double fMax;
  
  private Complex fAkt=new Complex();
  private Complex a=new Complex();
  private Complex v=new Complex();
  private Complex s=new Complex();
  
  private Icon auto=new ImageIcon("Bilder/rotes_Auto.gif");
  private Welt welt;
  
  /** Erzeugt ein Auto.
   * 
   */
  public Auto(double xPos,double yPos, double masse, double fMax)
  { s.setReal(xPos);
    s.setImag(yPos);
	this.masse=masse;
    this.fMax=fMax;
    setIcon(auto);
    setDoubleBuffered(true);
    setSize(auto.getIconWidth(),auto.getIconHeight());
    int xPositionPixel=(int)(xPos*massstab);    
    int yPositionPixel=(int)(yPos*massstab);
    setLocation(xPositionPixel,yPositionPixel);
  }
  
  public void roll() {fAkt.setReal(0.);}
  public void accel() {fAkt.setReal(fMax);}
  public void decel() {fAkt.setReal(-fMax);}
  public void up() {fAkt.setImag(-fMax);}
  public void down() {fAkt.setImag(fMax);}
  
  public void bekommt_Referenz_auf_Welt(Welt welt)
  { this.welt=welt;}
  
  public void simu()
  { a.setReal(fAkt.re()/masse);
    a.setImag(fAkt.im()/masse);

   
    Complex vDelta=new Complex(0.,0.);
    vDelta.setReal(a.re()*dt);
    vDelta.setImag(a.im()*dt);
    v=v.plus(vDelta);
    
    if (!welt.autoAufStrasse())
    { 
//      v.setReal(0.3);
    	v.setReal(1);
    }
    System.out.println("Geschwindigkeit v" + v.re());
    Complex sDelta=new Complex(0.,0.);
    sDelta.setReal(v.re()*dt);
    sDelta.setImag(v.im()*dt);
    s=s.plus(sDelta); 
    int xPosPixel=(int)(s.re()*massstab);    
    int yPosPixel=(int)(s.im()*massstab);
    this.setLocation(xPosPixel,yPosPixel);
    fAkt.setReal(0.);
    fAkt.setImag(0.);
  }
}
