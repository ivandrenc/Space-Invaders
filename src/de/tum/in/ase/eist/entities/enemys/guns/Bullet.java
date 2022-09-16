package de.tum.in.ase.eist.entities.enemys.guns;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Physics;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class Bullet extends Entity {

    private Color bulletColor;
    private Vec2 velocity;
    private SpaceShip player;

    public Bullet(Vec2 position, Vec2 size, Color bulletColor, Vec2 velocity) {
        this.position = position;
        this.size = size;
        this.bulletColor = bulletColor;
        this.velocity = velocity;
    }

    @Override
    public void onUpdate() {
        position = position.add(velocity);
        if(!Physics.detectCollision(position, size, Vec2.ZERO, board().size())){
            board().removeEntity(this);
        }

        if (player == null) {
            player = board().getEntityByTag("Player");
        } else {
            if (Physics.detectCollision(player.position, player.size, position, size)) {
                player.takeDamage();
                board().removeEntity(this);
            }
        }

    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawSquare(position, size, bulletColor);
    }
}
