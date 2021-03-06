/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NataliaPabon
 */
public class Naves {

    private int x; //alto y ancho del zombie
    private int y;
    private int alto = 80; //alto y ancho de la nave
    private int ancho = 80;
    private URL choque = null;
    private AudioClip son;

    public Naves(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean Colision(Zombie z) {
        if (((z.getY() + z.getAlto() > getY() + alto) && (getY() + alto > z.getY())
                || (z.getY() + z.getAlto() > getY()) && (getY() > z.getY()))
                && ((z.getX() + z.getAncho() > getX() + ancho) && (getX() + ancho > z.getX())
                || (z.getX() + z.getAncho() > getX()) && (getX() > z.getX()))) {
            try {
                choque = new URL("file:OUTCH.wav");
                son = Applet.newAudioClip(choque);

            } catch (MalformedURLException ex) {
                Logger.getLogger(Nivel3.class.getName()).log(Level.SEVERE, null, ex);
            }
            son.play();
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Naves other = (Naves) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
}
