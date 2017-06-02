/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import zombietimee.NewJFrame;
import Zombie1.Zombie;

/**
 *
 * @author javier
 */
public class Puntajes {

    private ArrayList<Jugador> jugadores;
    private double colisionesTotales = 100;
    String inf="";
    public Puntajes() {
        this.jugadores = new ArrayList<>();
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    
    public void asignarPuntaje(Jugador jugador) {
        Zombie1.Zombie z1 = new Zombie1.Zombie();
        Zombie2.Zombie z2 = new Zombie2.Zombie();
        Zombie3.Zombie z3 = new Zombie3.Zombie();
        colisionesTotales -= z1.getColisiones() + z2.getColisiones() + z3.getColisiones();
        colisionesTotales += z2.getPoderes();
        jugador.setMaxPuntaje(colisionesTotales);
        jugadores.add(jugador);
    }

    public void Ordenar() {
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = 0; j < (jugadores.size() - 1); j++) {
                if (jugadores.get(j).getMaxPuntaje() > jugadores.get(j + 1).getMaxPuntaje()) {
                    Jugador Ju = jugadores.get(j);
                    jugadores.add(j, jugadores.get(j + 1));
                    jugadores.add(j + 1, Ju);
                }
            }
        }

    }

    public void leerPuntajes(File f) throws FileNotFoundException {

        Scanner leer = new Scanner(f);
        while (leer.hasNext()) {
            String datos[] = leer.nextLine().split("[ ]+");
            Jugador jugador = new Jugador();
            jugador.setNombre(datos[0]);
            jugador.setMaxPuntaje(Double.parseDouble(datos[1]));
        }
    }

    public void escribirPuntajes(File f) throws IOException {
        PrintStream out = new PrintStream(f);
        
        for (Jugador j : jugadores) {
           inf= j.getNombre() + " " + j.getMaxPuntaje();
           out.print(j.getNombre() + " " + j.getMaxPuntaje());        
        }
    
    }

}
