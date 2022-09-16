package de.tum.in.ase.eist.gameboard.scenes;

import de.tum.in.ase.eist.entities.Backgrounds.Background;
import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.entities.enemys.EnemySpawner;
import de.tum.in.ase.eist.entities.ui.HealthLabel;
import de.tum.in.ase.eist.entities.ui.ScoreLabel;
import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboard.Scene;

public class PlayingScene extends Scene {

    public PlayingScene(GameBoard board) {
        super(board);
    }

    @Override
    public void createBeginningObjects() {
        SpaceShip spaceShip = new SpaceShip();
        this.board.setPlayer(spaceShip);
        add(new Background(), null, 0);
        add(new EnemySpawner(), "Spawner", 0);
        add(spaceShip, "Player", 1);
        add(new HealthLabel(), "Health", 2);
        add(new ScoreLabel(), "Score", 2);
    }

}
