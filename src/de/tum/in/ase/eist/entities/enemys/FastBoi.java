package de.tum.in.ase.eist.entities.enemys;

import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.entities.enemys.guns.OmniGun;
import de.tum.in.ase.eist.entities.enemys.movement.SuicideMovement;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Physics;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;
import java.util.List;

public class FastBoi extends Enemy {

    private static List<Vec2> barrels =  List.of(new Vec2(-3, -1), new Vec2(-1, -2), new Vec2(1, -2), new Vec2(3, -1));
    SpaceShip player;

    public FastBoi() {
        super(new OmniGun(30, Color.GREEN, barrels),
                new SuicideMovement(7),
                Sprite.SPACE_INVADER3,
                60);
        points = 300;
    }


    @Override
    public void onUpdate() {
        super.onUpdate();


        if (player == null) {
            player = board().getEntityByTag("Player");
        } else {
            if (Physics.detectCollision(player.position, player.size, position, size)) {
                player.takeDamage();
                board().removeEntity(this);
            }
        }
    }
}
