/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
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
 * @author Estudiante
 */
public class Nivel2 extends NivelPanel implements ActionListener, MouseListener, KeyListener {

    private int delay = 20;
    private Image fondo;
    private Image gameOver;
    private ArrayList<Persona> personas;
    private ArrayList<Persona> muertos = new ArrayList<>();
    private ArrayList<Rayito> rayitos = new ArrayList<>();
    private ArrayList<Rayito> apagados = new ArrayList<>();
    private Zombie roberto = new Zombie();
    private int clicX;
    private int clicY;
    private URL choque = null;
    private AudioClip sonch;

    private static Nivel2 instance = null;

    private Nivel2() {
        super();
        roberto.setX(10);
        roberto.setY(300);
        setFocusable(true);
        fondo = cargarImagen("graficaCiudad.jpg");
        timer = new Timer(delay, this);
        this.addMouseListener(this);
        this.personas = new ArrayList<>();
        gameOver = cargarImagen("images.png");
    }
    
    public void start(){
        super.start();
            llenarRectangulos();
            this.addKeyListener(this);
    }
     public void stop(){
        super.stop();
        this.removeKeyListener(this);
     }

    public static Nivel2 getInstance() {
        if (instance == null) {
            instance = new Nivel2();
        }
        return instance;
    }

    public void llenarRectangulos() {
        Random r = new Random();
        int iniX = 500;
        int iniY = 0;
        for (int i = 0; i < 2; i++) {
            iniX += 60 + Math.abs(r.nextInt() % 71);
            iniY = 250 + Math.abs(r.nextInt() % 130);
            this.personas.add(new Persona(iniX, iniY));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (playing) {
            if (roberto.getColisiones() < 10) {
                //for (int i = 0; i < 4; i++) {
                    g.drawImage(fondo, roberto.getFondox(), 0, 2000, 500, null);
                //}
                

                if (roberto.getPoderes() > 1000 && (roberto.getColisiones() < 10 && roberto.getColisiones() > 0)) {
                    roberto.setColisiones(roberto.getColisiones() - 1);
                    roberto.setPoderes(roberto.getPoderes() - 1000);
                }

                roberto.paintComponent(g, this);

                g.drawString("Poderes", 400, 30);
                g.drawString(": " + roberto.getPoderes(), 470, 30);

                g.drawString("Colisiones", 600, 30);
                g.drawString(": " + roberto.getColisiones(), 670, 30);

                for (Rayito rayote : rayitos) {
                    if (rayote.isAlive()) {
                        rayote.paintComponent(g, this, rayote.getX(), rayote.getY());
                        rayote.decreaseLife();
                    } else {
                        apagados.add(rayote);
                    }
                }
                for (Rayito muere : apagados) {
                    rayitos.remove(muere);
                }
                apagados = new ArrayList<>();

                Rectangle r = new Rectangle(roberto.getX(), roberto.getY(), roberto.getWidth(), roberto.getHeight());

                for (int i = 0; i < personas.size(); i++) {
                    int xr = this.personas.get(i).getX();
                    int yr = this.personas.get(i).getY();
                    if (personas.get(i).getVidas() > 0) {
                        personas.get(i).paintComponent(g, this);

                        Rectangle m = new Rectangle(xr, yr, 60, 97);

                        if (r.intersects(m)) {
                            try {
                                choque = new URL("file:OUTCH.wav");
                                sonch = Applet.newAudioClip(choque);

                            } catch (MalformedURLException ex) {
                                Logger.getLogger(Nivel2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            sonch.play();

                            roberto.setColisiones(roberto.getColisiones() + 1);
                            for (Persona rec : personas) {
                                if ((rec.getX() == xr) && (rec.getY() == yr)) {
                                    muertos.add(rec);
                                    break;
                                }
                            }
                        }
                    } else {
                        muertos.add(personas.get(i));
                    }
                }
                for (Persona dead : muertos) {
                    personas.remove(dead);
                }
                if (personas.size()==0) {
                    Frame frame = Frame.getInstance();
                    frame.setVisible(true);
                    frame.setNivel(3);
                    
                }
                muertos = new ArrayList<>();

            } else {
                g.drawImage(gameOver, 0, 0, 800, 500, null);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Persona p : personas) {
            p.actionPerformed(e);
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point mp = e.getPoint();
        
        for (Persona rec : this.personas) {
            if (rec.contains(mp)) {
                clicX = rec.getX();
                clicY = rec.getY();

                rayitos.add(new Rayito(clicX, clicY));
                //System.out.println("-"+rayitos.size());
                rec.setVidas(rec.getVidas() - 1);
                break;
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public Image cargarImagen(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        roberto.keyPressed(ke);
        System.out.println("Tecla nivel 2");
    }
}
