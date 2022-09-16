package de.tum.in.ase.eist.gameboard;

import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;

public abstract class GameObject {
    //only used and set by gameboard
    int layer;
    GameBoard gameBoard;
    String tag; // can be null

    //called on creation
    public void onRegister() {

    }

    // called in fixed time intervals
    public void onUpdate() {

    }

    // called when the object is supposed to be destroyed
    public void onRemove() {

    }

    // in this methode the object should draw itself, called independent from onUpdate()
    public void onDraw(PaintBrush brush) {

    }

    // get this objects tag, will be null most of the time
    public String getTag() {
        return tag;
    }

    // get the gameboard, use this to create/delete entities
    public GameBoard board() {
        return gameBoard;
    }
}
