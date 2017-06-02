/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie2;



import javax.swing.JFrame;
/**
 *
 * @author Estudiante
 */
public class Frame2 extends JFrame{


    private static Frame2 instance = null;

    private Frame2() {
        add(Nivel2.getInstance());
    }

    public static Frame2 getInstance() {
        if (instance == null) {
            instance = new Frame2();
        }
        return instance;
}
}
