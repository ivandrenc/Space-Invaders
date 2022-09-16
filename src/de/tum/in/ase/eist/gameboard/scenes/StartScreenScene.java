package de.tum.in.ase.eist.gameboard.scenes;

import de.tum.in.ase.eist.entities.Backgrounds.Background;
import de.tum.in.ase.eist.entities.Backgrounds.StartScreenBackground;
import de.tum.in.ase.eist.entities.ui.StartScreen;
import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboard.Scene;

public class StartScreenScene extends Scene {
    public StartScreenScene(GameBoard board) {
        super(board);
    }

    @Override
    protected void createBeginningObjects() {
        add(new StartScreen(),null,3);
        add(new StartScreenBackground(), "startBackground", 2);
    }
}
