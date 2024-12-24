package rennspiel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Strecke2 extends JLabel 
{  
  /* Strecke.png hat 1800x720 Pixel */
  private Icon streckeIcon = new ImageIcon("Bilder/Strecke_gerade.png");

  public Strecke2() 
  { setIcon(streckeIcon);
    setSize(streckeIcon.getIconWidth(), streckeIcon.getIconHeight());
    setLocation(0, 0);
        
    // Beispiel: Farbe an Position (800, 100) ausgeben
//    Color colorAtPoint = getColorAtPoint(800, 100);
//    if (colorAtPoint != null) 
//	  { System.out.println("Farbe an (800, 100): " + colorAtPoint.toString());
//    }

//    System.out.println("Strecke-Konstruktor->" + getBounds());
  }

  private BufferedImage convertToBufferedImage(Image img) 
  { if (img instanceof BufferedImage){ return (BufferedImage) img; }

    // Erstelle ein BufferedImage mit den Abmessungen des Bildes
    BufferedImage bimage=new BufferedImage(
    					  img.getWidth(null), 
    					  img.getHeight(null), 
    					  BufferedImage.TYPE_INT_ARGB);

    // Zeichne das Bild auf das BufferedImage
    Graphics2D bGr=bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    return bimage;
  }

  public Color getColorAtPoint(int x, int y) 
  { Image img=((ImageIcon)streckeIcon).getImage();
    BufferedImage bufferedImage=convertToBufferedImage(img);

    if (x >= 0 && x < bufferedImage.getWidth() && y >= 0 && y < bufferedImage.getHeight()) 
	{ int rgb=bufferedImage.getRGB(x,y);
      return new Color(rgb,true);
    }
    return null; // Punkt außerhalb des Bildes
  }
}
