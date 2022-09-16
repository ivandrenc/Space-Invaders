package de.tum.in.ase.eist.entities.enemys.movement;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.physics.Vec2;

public class WrappedMove implements MovementPattern {


    private final Vec2 velocity;
    private boolean leftSlide;

    public WrappedMove(boolean leftSlide) {
        this.velocity = leftSlide ? new Vec2(3, 1) : new Vec2(-3, 1);
        this.leftSlide = leftSlide;
    }

    @Override
    public void move(Entity e) {
        e.position = e.position.add(velocity);
        if (leftSlide) {
            if (e.position.x() >= e.board().getWidth() - 3) {
                e.position = new Vec2(3 - e.size.x(), e.position.y());
            }
        } else {
            if (e.position.x() <= 3 - e.size.x()) {
                e.position = new Vec2( e.board().getWidth() - 3, e.position.y());
            }
        }
    }

    @Override
    public Vec2 getSpawnLocation(Entity e) {
        return e.board().random().nextBoolean() ? new Vec2(3 - e.size.x(), 0) : new Vec2(e.board().getWidth() - 3, 0);
    }
}
