/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombietimee;

import Archivos.Jugador;
import Zombie1.Frame1;
import Zombie1.Nivel1;
import Zombie2.Frame2;
import Zombie2.Nivel2;
import Zombie3.Frame3;
import Zombie3.Nivel3;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Frame extends JFrame {

    private static Frame instance;

    Frame( ) {
        setTitle("ZOMBIE TIME");
        setSize(800, 530);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Nivel1.getInstance().setVisible(false);
        //Nivel2.getInstance().setVisible(false);
        Nivel3.getInstance().setVisible(false);

    }

    public static Frame getInstance() {
        if (instance != null) {
            instance.setVisible(false);
        }
        instance = new Frame();

        return instance;
    }

   private void terminoJuego( NewJFrame m ) {
        
        try {
            m.p.leerPuntajes(m.getF());
            m.p.Ordenar();
            m.p.escribirPuntajes(m.getF());
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNivel(int nivel) {
        Nivel1.getInstance().stop();
        Nivel2.getInstance().stop();
        Nivel3.getInstance().stop();

        switch (nivel) {
            case 1: {
                this.add(Nivel1.getInstance());
                Nivel1.getInstance().setVisible(true);
                Nivel1.getInstance().start();

                break;

            }
            case 2: {
                this.add(Nivel2.getInstance());
                Nivel2.getInstance().setVisible(true);
                Nivel2.getInstance().start();
                break;
            }
            case 3: {
                this.add(Nivel3.getInstance());
                Nivel3.getInstance().setVisible(true);
                Nivel3.getInstance().start();
               terminoJuego(Nivel3.k );
                break;
            }
        }

    }
}
