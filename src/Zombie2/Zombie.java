/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author gipao
 */
public class Zombie {

    private int colisiones = 0;
    private int x;
    private int y;
    private int width = 60;
    private int height = 97;
    private Image zombie;
    private boolean direccion;
    private int secuenciaZ;
    private int fondox;
    private int poderes;


    public Zombie() {
        this.x = x;
        this.y = y;
        zombie = cargarImagen("ZRunn.png");
        direccion = true;
    }

    protected void paintComponent(Graphics g, Nivel2 panel) {

        if (direccion) {
            g.drawImage(zombie, this.x, this.y, this.x + 60, this.y + 97,
                    (this.secuenciaZ * 322), 0, (this.secuenciaZ * 322) + 322, 388, panel);
        } else {
            g.drawImage(zombie, this.x + 60, this.y, this.x, this.y + 97,
                    (this.secuenciaZ * 322), 0, (this.secuenciaZ * 322) + 322, 388, panel);
        }
    }

    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();

        if (key == KeyEvent.VK_RIGHT && this.x + 10 < 800 - 100) {
            this.x = this.x + 10;
            if (this.secuenciaZ == 9) {
                this.secuenciaZ = 0;
            } else {
                this.secuenciaZ++;
            }
            fondox -= 1;
            poderes += 5;
            direccion = true;

        }
        if (key == KeyEvent.VK_LEFT && this.x - 10 > 0) {
            this.x = this.x - 10;
            if (this.secuenciaZ == 0) {
                this.secuenciaZ = 9;
            } else {
                this.secuenciaZ--;
            }
            fondox += 1;
            poderes -= 1;
            direccion = false;
        }
        if (key == KeyEvent.VK_UP && this.y - 5 > 258) {
            this.y = this.y - 5;
        }
        if (key == KeyEvent.VK_DOWN && this.y + 5 < 400) {
            this.y = this.y + 5;
        }

    }

    public int getFondox() {
        return fondox;
    }

    public void setFondox(int fondox) {
        this.fondox = fondox;
    }

    public int getX() {
        return x;
    }

    public int getPoderes() {
        return poderes;
    }

    public void setPoderes(int poderes) {
        this.poderes = poderes;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getColisiones() {
        return colisiones;
    }

    public void setColisiones(int colisiones) {

        this.colisiones = colisiones;

    }

    public Image cargarImagen(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

}
