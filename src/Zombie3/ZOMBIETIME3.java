/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie3;

import javax.swing.JFrame;
/**
 *
 * @author NataliaPabon
 */
public class ZOMBIETIME3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame3 frame = Frame3.getInstance();
        frame.setTitle("ZombieTime3");
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
    
}
