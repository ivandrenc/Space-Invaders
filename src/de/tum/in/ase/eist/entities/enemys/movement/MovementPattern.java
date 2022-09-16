package de.tum.in.ase.eist.entities.enemys.movement;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.physics.Vec2;

import java.util.Random;

public interface MovementPattern {
    void move(Entity e);
    Vec2 getSpawnLocation(Entity e);
}
