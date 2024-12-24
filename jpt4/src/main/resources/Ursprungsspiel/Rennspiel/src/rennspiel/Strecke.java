package rennspiel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Strecke extends JLabel
{ 
  /* Strecke.png hat 1800x720 Pixel */
  private Icon strecke=new ImageIcon("Bilder/Strecke_Gruen.png");
  
  public Strecke() 
  { setIcon(strecke);
    setSize(strecke.getIconWidth(),strecke.getIconHeight());
    setLocation(0,0);
    
	System.out.println("Strecke-Konstruktor->"+getBounds());
  }
}
