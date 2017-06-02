/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author gipao
 */
public class Persona {

    private int x;
    private int y;
    private int height = 97;
    private int width = 60;
    private int vidas = 3;
    private Image ImagPerson;
    private int secuenciaP = 7;
    int xPersonas;
    int yPersonas;

    public Persona(int x, int y) {
        this.x = x;
        this.y = y;
        ImagPerson = cargarImagen("capguy-walk.png");
    }

    protected void paintComponent(Graphics g, Nivel2 panel) {
        g.drawImage(ImagPerson, this.x + 60, this.y, this.x, this.y + 97,
                (this.secuenciaP * 184), 0, (this.secuenciaP * 184) + 184, 325, panel);

    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final Persona other = (Persona) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    

    public void actionPerformed(ActionEvent e) {
        xPersonas -= 1;

            if (this.secuenciaP == 0) {
                this.secuenciaP = 7;
            } else {
                this.secuenciaP--;
            }
            
            this.x--;
            //repaint();
        }

    public Image getImagPerson() {
        return ImagPerson;
    }

    public void setImagPerson(Image ImagPerson) {
        this.ImagPerson = ImagPerson;
    }

    public int getSecuenciaP() {
        return secuenciaP;
    }

    public void setSecuenciaP(int secuenciaP) {
        this.secuenciaP = secuenciaP;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
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

    public boolean contains(Point mp) {
        if (((mp.x >= this.x) && (mp.x <= this.x + width))
                && (mp.y >= this.y) && (mp.y <= this.y + height)) {
            return true;
        }
        return false;
    }

    public Image cargarImagen(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

}
