package de.tum.in.ase.eist.entities.enemys;

import de.tum.in.ase.eist.entities.enemys.guns.OmniGun;
import de.tum.in.ase.eist.entities.enemys.movement.SuicideMovement;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;
import java.util.List;

public class OctoAlien extends Enemy {

   private static List<Vec2> bullets = List.of(new Vec2(-1, 1), new Vec2(0, 1), new Vec2(1,1), new Vec2(-1,2), new Vec2(1,2),new Vec2(-1, 3), new Vec2(0, 3), new Vec2(1,3));
    public OctoAlien() {
        super(new OmniGun(180, Color.YELLOW, bullets), new SuicideMovement(2), Sprite.SPACE_INVADER2, 30);
        points = 225;
    }
}
