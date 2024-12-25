package ingij.saling;

import javax.swing.*;

public class Rennspiel extends JFrame {

    public Rennspiel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(900, 0, 900, 900);
        setVisible(true);
    }

    public static void main(String[] args) {
        Rennspiel spielfeld = new Rennspiel();
        spielfeld.setLayout(null);
        Vehicle auto = new Vehicle();
        spielfeld.add(auto);
        spielfeld.setVisible(true);
        spielfeld.repaint();
        



        // try {
        //     Thread.sleep(1500);
        // } catch (Exception e) {
        //     System.out.println("Dood, da isch a Fehler bassiet.");
        // }
        // auto.setBounds(900, 900, 50, 50);
    }

}
