package Zombie1;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import zombietimee.Frame;
import zombietimee.NivelPanel;

/**
 *
 * @author NataliaPabon
 */
public final class Nivel1 extends NivelPanel {

    private static Nivel1 instance = null;
    private int m; // meteoritos
    private int k;
    private Zombie roberto = new Zombie();
    private Color color;
    private int secuencia;
    private Image zombieimg;
    private Image fondo;
    private Image MEteoros;
    private Image gameOver;
    private ArrayList<Meteoritos> bordeMeteoritos;
    private ArrayList<Meteoritos> colision = new ArrayList<>();
    private Nivel1KeyListener keyListener;
    
    private Nivel1() {
        super();
        roberto.setX(100);
        roberto.setY(350);
        setFocusable(true);
        zombieimg = loadImage("ZRunn.png");
        fondo = loadImage("fondo1.jpg");
        MEteoros = loadImage("meteorito.png");
        gameOver = loadImage("images.png");
keyListener=new Nivel1KeyListener();
        timer = new Timer(delay, keyListener);

        this.bordeMeteoritos = new ArrayList<>();
    }

    public KeyListener getKeyListener(){
        return keyListener;
    }
    
    public static Nivel1 getInstance() {
        if (instance == null) {
            instance = new Nivel1();
        }
        return instance;
    }

    @Override
    public void start() {
        super.start();
        Meteoross();
        this.addKeyListener(keyListener);
    }

    public void stop(){
        super.stop();
        this.removeKeyListener(keyListener);
     }
    
    public void Meteoross() {
        int iniX = 100;
        int iniY = 20;
        Random k = new Random();
        this.bordeMeteoritos = new ArrayList<>();
       
        for (int i = 0; i < 1; i++) {
            iniX = 100 + Math.abs(k.nextInt() % (900));
            iniY = -(Math.abs(k.nextInt() % 500));
            this.bordeMeteoritos.add(new Meteoritos(iniX, iniY));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (playing) {
            super.paintComponent(g);

            if (roberto.getColisiones() < 10) {
                if (roberto.getColisiones() < 10) {
                    for (int i = 0; i < k; i++) {
                        g.drawImage(fondo, -k + (i * 800), 0, 800, 500, this);
                    }
                }
                
                g.drawImage(zombieimg, roberto.getX1(), 350, roberto.getX2(), 464,
                        (this.secuencia * 322), 0, (this.secuencia * 322) + 322, 388, this);
                g.drawString("Colisiones", 600, 30);
                g.drawString(": " + roberto.getColisiones(), 670, 30);
                int xr = 0;
                int yr = 0;
                for (int i = 0; i < bordeMeteoritos.size(); i++) {
                    Random l = new Random();
                    int in = Math.abs(l.nextInt() % 6000);
                    xr = this.bordeMeteoritos.get(i).getX();
                    yr = this.bordeMeteoritos.get(i).getY();

                    if (this.bordeMeteoritos.get(i).getY() > 500) {
                        bordeMeteoritos.remove(i);
                        continue;
                    }
                    g.drawImage(MEteoros, xr, yr, 60, 100, this);

                    this.bordeMeteoritos.get(i).setY(this.bordeMeteoritos.get(i).getY() + 2);
                    this.bordeMeteoritos.get(i).setX(this.bordeMeteoritos.get(i).getX() - 2);
                    if (this.bordeMeteoritos.get(i).Colision(roberto)) {
                        roberto.setColisiones(roberto.getColisiones() + 1);
                        bordeMeteoritos.remove(i);
                    }
                }
                if (bordeMeteoritos.size() == 0) {
                    Frame frame2 = Frame.getInstance();
                    frame2.setVisible(true);
                    frame2.setNivel(2);
                }
            } else {
                g.drawImage(gameOver, 0, 0, 800, 500, null);
            }
        }
    }

    public Image loadImage(String imageName) {
        ImageIcon im = new ImageIcon(imageName);
        Image image = im.getImage();
        return image;
    }

    
    
    
    class Nivel1KeyListener implements ActionListener, KeyListener {
    
    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && roberto.getX() + 10 < 700) {
            roberto.setDireccion(true);
            roberto.setX(roberto.getX() + 10);
            if (secuencia == 9) {
                secuencia = 0;
            } else {
                secuencia++;
            }

        }
        if (key == KeyEvent.VK_LEFT && roberto.getX() - 10 > 0) {
            roberto.setDireccion(false);
            roberto.setX(roberto.getX() - 10);
            if (secuencia == 0) {
                secuencia = 9;
            } else {
                secuencia--;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

           @Override
    public void actionPerformed(ActionEvent ae) {
        k += 3;
        repaint();
    }
}
    
}
