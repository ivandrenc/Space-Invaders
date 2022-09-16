package de.tum.in.ase.eist.entities.enemys.guns;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.entities.enemys.guns.Gun;
import de.tum.in.ase.eist.entities.enemys.guns.LaserBeam;

import java.awt.*;

public class SpaceLaser implements Gun {



    private int cooldown = 120;
    private final int cooldownDuration = 400;
    private final Color color = Color.RED;

    @Override
    public void fire(Entity entity) {
        if (cooldown == 0) {
            cooldown = cooldownDuration;
            entity.board().registerEntity(new LaserBeam(entity));
        } else {
            cooldown--;
        }
    }

}
