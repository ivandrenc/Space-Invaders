package de.tum.in.ase.eist.entities.enemys;

import de.tum.in.ase.eist.entities.enemys.guns.BulletGun;
import de.tum.in.ase.eist.entities.enemys.movement.WrappedMove;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;

import java.awt.*;

public class TheSmoothSilder extends Enemy {

    public TheSmoothSilder(boolean leftSlide) {
        super(new BulletGun(Color.CYAN),new WrappedMove(leftSlide), Sprite.SPACE_INVADER4, 35);
        points = 125;
    }
}
