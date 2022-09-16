package de.tum.in.ase.eist.entities;

import de.tum.in.ase.eist.entities.enemys.Enemy;
import de.tum.in.ase.eist.entities.enemys.EnemySpawner;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Physics;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class FriendlyBullet extends Entity {
    private Vec2 velocity = new Vec2(0, -14);
    private EnemySpawner spawner;
    private Color bulletColor = Color.MAGENTA;

    public FriendlyBullet(Vec2 position) {
        this.position = position;
    }


    @Override
    public void onRegister() {
        size = new Vec2(5, 16);
        spawner = board().getEntityByTag("Spawner");

    }

    @Override
    public void onUpdate() {
        position = position.add(velocity);

        for (Enemy e : spawner.getAllEnemys()) {
            if (Physics.detectCollision(position, size, e.position, e.size)) {
                e.takeDamage();
                board().removeEntity(this);
            }
        }

        if (!Physics.detectCollision(position, size, Vec2.ZERO, board().size())) {
            board().removeEntity(this);

        }

    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawSquare(position, size, bulletColor);
    }
}
