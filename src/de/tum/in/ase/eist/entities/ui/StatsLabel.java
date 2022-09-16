package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.gameboard.GameObject;
import de.tum.in.ase.eist.physics.Vec2;

public abstract class StatsLabel extends GameObject {
    public SpaceShip player;
    public Vec2 numberLabel;
    public Vec2 descriptionLabel;

}
