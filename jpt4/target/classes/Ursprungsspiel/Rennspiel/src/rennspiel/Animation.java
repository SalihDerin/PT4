package rennspiel;
import java.awt.Insets;
import java.awt.Rectangle;

//import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Animation extends JFrame
{
  private Welt welt;
  private JPanel contentpane;

  public static void main(String[] args)
  { Animation animation=new Animation();
    animation.starteAnimation();
  }

  public Animation()
  { setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setBounds(100,100,Welt.breitePixel+16,Welt.hoehePixel+40);	
    setSize(Welt.breitePixel+60,Welt.hoehePixel+80);	//  setSize(Welt.breitePixel+26,Welt.hoehePixel+50);
    setLocationRelativeTo(null);
    
    contentpane=new JPanel();
    contentpane.setBackground(Color.CYAN);
    setContentPane(contentpane);
    contentpane.setLayout(null);
    contentpane.setDoubleBuffered(false);
    contentpane.setBorder(new EmptyBorder(5,5,5,5));
    
    welt=new Welt();
    contentpane.add(welt);  
  }
  
  public void starteAnimation()
  { for(;;)
    { try{Thread.sleep(20);}catch(InterruptedException e){}
      welt.zustandsautomat.statemachine('t');
      welt.aktualisiereZustand();
      welt.repaint();
//      this.repaint();		//geht auch
    }
  }
}

//Test in starteAnimation() für Positionsbestimmung
//Rectangle rect1=new Rectangle();
//rect1=this.getBounds();
//getBounds();
//System.out.println(rect1.height+"\t"+rect1.width);
//System.out.println(rect1.x+"\t"+rect1.y);
//System.out.println(getBounds().width+"\t"+getBounds().height);
//System.out.println("animation JFrame");
//System.out.println(getBounds());
//System.out.println(getInsets());
//
//System.out.println("\n");
//System.out.println("contentpane JPanel");
//System.out.println(contentpane.getBounds());
//System.out.println(contentpane.getInsets());
//
//System.out.println("\n");
//System.out.println("welt JPanel");
//System.out.println(welt.getBounds());
//System.out.println(welt.getInsets());
