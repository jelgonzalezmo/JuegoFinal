/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombietimee;

import Zombie1.Nivel1;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author USER
 */
public class NivelPanel extends JPanel {

    protected boolean playing = false;

    protected URL sonido = null;
    protected AudioClip son;
    protected Timer timer;
    protected int delay = 20;
    private String NombreJ;

    public String getNombreJ() {
        return NombreJ;
    }

    public void setNombreJ(String NombreJ) {

        this.NombreJ = NombreJ;
    }

    protected NivelPanel() {

        try {
            sonido = new URL("file:Fondo.wav");
            son = Applet.newAudioClip(sonido);

        } catch (MalformedURLException ex) {
            Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() {
        timer.start();
        this.playing = true;
        son.loop();
    }

    public void stop() {
        son.stop();
        this.playing = false;
        this.setVisible(false);
    }

}
