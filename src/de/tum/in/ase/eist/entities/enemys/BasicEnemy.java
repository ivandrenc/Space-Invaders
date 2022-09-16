package de.tum.in.ase.eist.entities.enemys;

import de.tum.in.ase.eist.entities.enemys.guns.BulletGun;
import de.tum.in.ase.eist.entities.enemys.movement.SnakeLineMove;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;

import java.awt.*;

public class BasicEnemy extends  Enemy{

    public BasicEnemy() {
        super(new BulletGun(Color.RED), new SnakeLineMove(), Sprite.SPACE_INVADER1,30);
        points = 100;
    }
}
