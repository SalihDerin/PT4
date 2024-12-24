package rennspiel;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**Ingos Welt extends JPanel*/
public class Welt extends JPanel
{
  private Strecke2 strecke=new Strecke2();
  private Auto auto=new Auto(1.5, Welt.hoehe*0.5, 1250, 10000);
  
  public Zustandsautomat zustandsautomat=new Zustandsautomat(auto);
	
  /** Maßstab, in dem die Welt und alles, was darin ist, gezeichnet wird [Pixel pro Meter] */
  public static final double massstab=30;  
  /** Höhenausdehnung der Welt [Meter] */
  public static final double hoehe=24;  
  /** Breitenausdehnung der Welt [Meter] */
  public static final double breite=60;  
  
  
  /** Höhenausdehnung der Welt [Pixel] */
  public static final int hoehePixel=(int)(hoehe*massstab);		/* 720 Pixel */
  /** Breitenausdehnung der Welt [Pixel] */
  public static final int breitePixel=(int)(breite*massstab);	/* 1800 Pixel */

  
  /** Erzeugt eine Welt.*/
  public Welt()
  { //setSize(breitePixel, hoehePixel);		/* so im Original, aber dann ist im WindowDesigner nichts zu sehen */
    setSize(1825,745);  //setSize(1800,720);  
    setLayout(null);
    setDoubleBuffered(true);
    setBackground(Color.magenta);
    setBorder(new LineBorder(new Color(0,0,0)));
    
//    auto.addComponentListener(null);
    auto.bekommt_Referenz_auf_Welt(this);
    add(auto);
    
    JButton accelBtn = new JButton("Accel ");
    accelBtn.addMouseListener(new MouseAdapter() 
    { @Override
      public void mouseClicked(MouseEvent e) 
      { zustandsautomat.statemachine('a');
      }
    });
    accelBtn.setBounds(219, 68, 89, 23);
    add(accelBtn);
    
    JButton neutralBtn = new JButton("Neutral");
    neutralBtn.addMouseListener(new MouseAdapter() 
    { @Override
      public void mouseClicked(MouseEvent e) 
      { zustandsautomat.statemachine('n');
      }
    });
    neutralBtn.setBounds(120, 68, 89, 23);
    add(neutralBtn);
    
    JButton decelBtn = new JButton("Decel");
    decelBtn.addMouseListener(new MouseAdapter() 
    { @Override
      public void mouseClicked(MouseEvent e) 
      { zustandsautomat.statemachine('r');
      }
    });
    decelBtn.setBounds(21, 68, 89, 23);
    add(decelBtn);
    
    JButton upBtn = new JButton("Up");
    upBtn.addMouseListener(new MouseAdapter() 
    { @Override
      public void mouseClicked(MouseEvent e) 
      { zustandsautomat.statemachine('u');
      }
    });
    upBtn.setBounds(120, 31, 89, 23);
    add(upBtn);
    
    JButton downBtn = new JButton("Down");
    downBtn.addMouseListener(new MouseAdapter() 
    { @Override
      public void mouseClicked(MouseEvent e) 
      { zustandsautomat.statemachine('d');
      }
    });
    downBtn.setBounds(120, 102, 89, 23);
    add(downBtn);
    
    add(strecke);
  }
  
  public boolean autoAufStrasse()
  { Point positionAuto=auto.getLocation();
  	Color streckenfarbe_bei_positionAuto=
  			strecke.getColorAtPoint(positionAuto.x, positionAuto.y);
  	int farbwert_Int=streckenfarbe_bei_positionAuto.getRGB();
//  	System.out.println(farbwert_Int);
  	if (farbwert_Int==(-16777216)) {return true;}	// -16777216 Schwarz
  	else return false;
  }
  
  public boolean autoImZiel()
  { Point positionAuto=auto.getLocation();
  	Color streckenfarbe_bei_positionAuto=
  			strecke.getColorAtPoint(positionAuto.x, positionAuto.y);
  	int farbwert_Int=streckenfarbe_bei_positionAuto.getRGB();
//  	System.out.println(farbwert_Int);
  	if (farbwert_Int==(-1)) {return true;}	// -1 Weiss
  	else return false;
  }
    
  protected void paintComponent(Graphics g)
  { super.paintComponent(g);
  }
  
  public void aktualisiereZustand()
  { auto.simu();
    autoAufStrasse();
    autoImZiel();
  }
}
