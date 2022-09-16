package de.tum.in.ase.eist.entities.enemys.guns;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.physics.Vec2;

import javax.swing.text.Position;

public interface Gun {
    void fire(Entity entity);
}
