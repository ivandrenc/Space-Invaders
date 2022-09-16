package de.tum.in.ase.eist.gameboard.scenes;

import de.tum.in.ase.eist.entities.Backgrounds.Background;
import de.tum.in.ase.eist.entities.ui.ScoreScreen;
import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboard.Scene;

public class ScoreScreenScene extends Scene {

    public ScoreScreenScene(GameBoard board) {
        super(board);
    }

    @Override
    protected void createBeginningObjects() {
        add(new ScoreScreen(), null, 1);
        add(new Background(), null, 0);
    }
}
