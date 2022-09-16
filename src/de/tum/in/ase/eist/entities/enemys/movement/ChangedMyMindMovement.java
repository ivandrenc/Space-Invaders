package de.tum.in.ase.eist.entities.enemys.movement;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.physics.Vec2;

public class ChangedMyMindMovement implements MovementPattern {

    boolean retreat;
    int distance = 50;
    int waiting = 250;
    int speed = 1;

    @Override
    public void move(Entity e) {
        if (retreat) {
            if (waiting == 0) {
                e.position = e.position.add(0, -speed);
            } else {
                waiting--;
            }
        } else {
            if(e.position.y() > distance){
                retreat = true;
            }
            e.position = e.position.add(0, speed);
        }

    }

    @Override
    public Vec2 getSpawnLocation(Entity e) {
        return new Vec2(e.board().random().nextInt(e.board().getWidth() - e.size.x()), 3 - e.size.y());
    }
}
