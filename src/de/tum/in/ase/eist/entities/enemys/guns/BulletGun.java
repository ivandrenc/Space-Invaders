package de.tum.in.ase.eist.entities.enemys.guns;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class BulletGun implements Gun {

    private int cooldown;
    private final int cooldownDuration = 60;
    private final Color bulletColor;
    private final Vec2 velocity = new Vec2(0,5);
    private final Vec2 bulletSize = new Vec2(4,8);

    public BulletGun(Color bulletColor) {
        this.bulletColor = bulletColor;
    }


    @Override
    public void fire(Entity entity) {
        if (cooldown == 0) {
            cooldown = cooldownDuration;

            Vec2 barrel = new Vec2(entity.position.x() + entity.size.x()/2, entity.position.y() + entity.size.y());
            entity.board().registerEntity(new Bullet(entity.position, bulletSize, bulletColor, velocity));
        } else {
            cooldown--;
        }
    }

}
