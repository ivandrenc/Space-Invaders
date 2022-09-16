package de.tum.in.ase.eist.gameboardui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.DriverManager;

// wrapper around user input related functionality
public class Input {

    private boolean[] currentlyPressed = new boolean[0xFFFF];

    Input(){}

    KeyListener getKeyListener(){
        return new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                Input.this.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Input.this.keyReleased(e);
            }
        };
    }

    public void keyPressed(KeyEvent e) {
        currentlyPressed[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        currentlyPressed[e.getKeyCode()] = false;
    }



    public boolean getKey(int keyCode){
       return currentlyPressed[keyCode];
    }
}
