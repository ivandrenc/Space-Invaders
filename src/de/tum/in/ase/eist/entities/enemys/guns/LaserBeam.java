package de.tum.in.ase.eist.entities.enemys.guns;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Physics;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class LaserBeam extends Entity {

    private int warmUp = 40;
    private int duration = 100;
    private Color color = Color.RED;
    public Entity parent;
    public SpaceShip player;

    public LaserBeam(Entity parent) {
        this.parent = parent;
        position = new Vec2(parent.position.x() + parent.size.x() / 2 - 3, parent.position.y() + parent.size.y());
        size = new Vec2(2, parent.board().getHeight());
    }

    @Override
    public void onUpdate() {
        position = new Vec2(parent.position.x() + parent.size.x() / 2 - 3, parent.position.y() + parent.size.y());
        if (warmUp == 0) {
            if (player == null) {
                player = board().getEntityByTag("Player");
            } else {
                if (Physics.detectCollision(player.position, player.size, position, size)) {
                    player.takeDamage();
                }
            }
            duration--;
            if (duration == 0) {
                board().removeEntity(this);
            }
        } else {
            warmUp--;
            if (warmUp == 0) {
                size = new Vec2(6, board().getHeight());
                color = Color.MAGENTA;
            }
        }
    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawSquare(position, size, color);
    }
}
