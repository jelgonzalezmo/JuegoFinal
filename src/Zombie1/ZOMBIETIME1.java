/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zombie1;

import javax.swing.JFrame;

/**
 *
 * @author NataliaPabon
 */
public class ZOMBIETIME1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame1 frame = Frame1.getInstance();
        frame.setTitle("ZombieTime1");
        frame.setSize(800,530);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }
    
}
