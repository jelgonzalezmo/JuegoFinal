/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

/**
 *
 * @author javier
 */
public class Jugador {
   private String nombre;
   private double maxPuntaje;

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMaxPuntaje() {
        return maxPuntaje;
    }

    public void setMaxPuntaje(double maxPuntaje) {
        this.maxPuntaje = maxPuntaje;
    }

    @Override
    public String toString() {
        return  nombre + " " + maxPuntaje +"\n";
    }
    
    
   
}
