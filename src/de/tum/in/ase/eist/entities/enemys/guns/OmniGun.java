package de.tum.in.ase.eist.entities.enemys.guns;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;
import java.util.List;


public class OmniGun implements Gun {
    private int cooldown;
    private final int cooldownDuration;
    private final Color bulletColor;
    private final List<Vec2> velocitys;
    private final Vec2 bulletSize = new Vec2(4, 8);

    public OmniGun(int cooldownDuration, Color bulletColor, List<Vec2> velocitys) {
        this.cooldownDuration = cooldownDuration;
        this.bulletColor = bulletColor;
        this.velocitys = velocitys;
    }


    @Override
    public void fire(Entity entity) {
        if (cooldown == 0) {
            cooldown = cooldownDuration;
            Vec2 barrel = entity.position.cornerToCenter(entity.size);
            for (Vec2 velocity : velocitys) {
                entity.board().registerEntity(new Bullet(barrel, bulletSize, bulletColor, velocity));
            }
        } else {
            cooldown--;
        }

    }
}
