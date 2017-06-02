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
public class Frame1 extends JFrame {

    private static Frame1 instance = null;

    private Frame1() {
        add(Nivel1.getInstance());
    }

    public static Frame1 getInstance() {
        if (instance == null) {
            instance = new Frame1();
        }
        return instance;
}
}
