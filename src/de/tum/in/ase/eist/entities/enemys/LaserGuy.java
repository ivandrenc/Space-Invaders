package de.tum.in.ase.eist.entities.enemys;

import de.tum.in.ase.eist.entities.enemys.guns.SpaceLaser;
import de.tum.in.ase.eist.entities.enemys.movement.ChangedMyMindMovement;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;

public class LaserGuy extends Enemy {

    public LaserGuy() {
        super(new SpaceLaser(), new ChangedMyMindMovement(), Sprite.SPACE_INVADER6, 50);
        points = 175;
    }
}
