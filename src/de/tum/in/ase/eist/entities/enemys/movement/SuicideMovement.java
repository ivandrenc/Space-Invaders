package de.tum.in.ase.eist.entities.enemys.movement;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.physics.Vec2;

public class SuicideMovement implements MovementPattern{

    private final int speed;

    public SuicideMovement(int speed) {
        this.speed = speed;
    }

    @Override
    public void move(Entity e) {
        e.position = e.position.add(0,speed);
    }

    @Override
    public Vec2 getSpawnLocation(Entity e) {
        return new Vec2(e.board().random().nextInt(e.board().getWidth() - e.size.x()), 3 - e.size.y());
    }
}
