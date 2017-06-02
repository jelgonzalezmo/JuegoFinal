/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author gipao
 */
public class Rayito {

    private int x;
    private int y;
    private Image rayos;
    private boolean Luz = true;
    private int vida=10;

    public Rayito(int x, int y) {
        this.x = x;
        this.y = y;
        rayos = cargarImagen("Imagen1.png");
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public void decreaseLife(){
        vida--;
    }
    
    public boolean isAlive(){
        return vida>0;
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

    public boolean isLuz() {
        return Luz;
    }

    public void setLuz(boolean Luz) {
        this.Luz = Luz;
    }

 
    protected void paintComponent(Graphics g, Nivel2 panel,int x,int y) { 
        g.drawImage(rayos, x, -y, 10, 530, panel);
    }
    
    public Image cargarImagen(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    


}
