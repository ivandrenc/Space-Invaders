package de.tum.in.ase.eist.gameboard.scenes;

import de.tum.in.ase.eist.entities.Backgrounds.EndScreenBackground;
import de.tum.in.ase.eist.entities.ui.EndScreen;
import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboard.Scene;

public class EndScreenScene extends Scene {

    public EndScreenScene(GameBoard board) {
        super(board);
    }

    @Override
    protected void createBeginningObjects() {
        add(new EndScreen(), null, 1);
        add(new EndScreenBackground(), null, 0);
    }
}
