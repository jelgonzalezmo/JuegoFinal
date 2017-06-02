package Zombie3;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import zombietimee.Frame;
import zombietimee.NewJFrame;
import zombietimee.NewJFrameFIN;
import zombietimee.NivelPanel;

/**
 *
 * @author NataliaPabon
 */
public final class Nivel3 extends NivelPanel implements ActionListener, KeyListener {

    private static Nivel3 instance = null;

    private int m; // meteoritos

    private Zombie roberto = new Zombie();
    private int delay = 20;
    private Color color;
    private int secuencia;
    private Image zombieimg;
    private Image fondo;
    private Image naveEspacial;
    private Image gameOver;


    private ArrayList<Naves> bordeNaves;
    private ArrayList<Naves> colision = new ArrayList<>();
    
    public static NewJFrame k;
    public static void setNewJFrame( NewJFrame m ) {
        Nivel3.k = m;
    }

    private Nivel3() {
        roberto.setX(100);
        roberto.setY(350);
        this.addKeyListener(this);
        setFocusable(true);
        zombieimg = loadImage("ZRunn.png");
        fondo = loadImage("planets_by_unydel-d6uul8z.jpg");
        naveEspacial = loadImage("Nave_Espacial_icono.png");
        gameOver = loadImage("images.png");
        timer = new Timer(delay, this);
        timer.start();
        this.bordeNaves = new ArrayList<>();
        navecitas();

    }

    public static Nivel3 getInstance() {
        if (instance == null) {
            instance = new Nivel3();
        }
        return instance;
    }

    public void navecitas() {
        int iniX = 100;
        int iniY = 2;
        Random k = new Random();
        for (int i = 0; i < 5; i++) {
            iniX = Math.abs(k.nextInt() % (800 - 80));
            iniY = -(Math.abs(k.nextInt() % 5000));
            this.bordeNaves.add(new Naves(iniX, iniY));
        }
     
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, 800, 500, null);
        if (playing) {
        if (roberto.getColisiones() < 10) {
            if (bordeNaves.isEmpty()) {
                 NewJFrameFIN frameFin = NewJFrameFIN.getInstance();
                 
                    frameFin.setVisible(true);
                    
                   
            }
            g.drawImage(zombieimg, roberto.getX1(), 350, roberto.getX2(), 464,
                    (this.secuencia * 322), 0, (this.secuencia * 322) + 322, 388, this);

            g.setColor(Color.WHITE);
            Font myFont = new Font("Courier New", 1, 20);

            g.setFont(myFont);
            g.drawString("Colisiones", 600, 100);
            g.drawString(": " + roberto.getColisiones(), 670, 250);
            int xr = 0; //coordenadas del objeto que cae
            int yr = 0;
            for (int i = 0; i < bordeNaves.size(); i++) {
                Random l = new Random();

                xr = this.bordeNaves.get(i).getX();
                yr = this.bordeNaves.get(i).getY();

                if (this.bordeNaves.get(i).getY() > 500) {

                    bordeNaves.remove(i);
                    continue;
                }
                g.drawImage(naveEspacial, xr, yr, 80, 80, this);

                this.bordeNaves.get(i).setY(this.bordeNaves.get(i).getY() + 4);

                if (this.bordeNaves.get(i).Colision(roberto)) {
                    roberto.setColisiones(roberto.getColisiones() + 1);
                    bordeNaves.remove(i);
                }
            }
        } else {
            g.drawImage(gameOver, 0, 0, 800, 500, null);
        }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

    public Image loadImage(String imageName) {
        ImageIcon im = new ImageIcon(imageName);
        Image image = im.getImage();
        return image;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && roberto.getX() + 10 < 800 - 100) {
            roberto.setDireccion(true);
            roberto.setX(roberto.getX() + 10);
            if (this.secuencia == 9) {
                this.secuencia = 0;
            } else {
                this.secuencia++;
            }

        }
        if (key == KeyEvent.VK_LEFT && roberto.getX() - 10 > 0) {
            roberto.setDireccion(false);
            roberto.setX(roberto.getX() - 10);
            if (this.secuencia == 0) {
                this.secuencia = 9;
            } else {
                this.secuencia--;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
