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
        //     Thread.sleep(2000);
        // } catch (Exception e) {
        //     System.out.println("Doooood! A Fehla!");
        // }
        // for (int i=0; i<10000; i++) {
        //     auto.accel();
        //     auto.simu();
        //     spielfeld.repaint();
        //     try {
        //         Thread.sleep(20);
        //     } catch (Exception e) {
        //         System.out.println("Doooood! A Fehla!");
        //     }
        // }
        // while (true) {
        //     auto.roll();
        //     auto.simu();
        //     spielfeld.repaint();
        //     try {
        //         Thread.sleep(20);
        //     } catch (Exception e) {
        //         System.out.println("Doooood! A Fehla!");
        //     }
        // }
    }

}
