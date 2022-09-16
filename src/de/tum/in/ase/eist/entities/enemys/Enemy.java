package de.tum.in.ase.eist.entities.enemys;

import java.awt.Color;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.entities.Explosion;
import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.entities.enemys.guns.Gun;
import de.tum.in.ase.eist.entities.enemys.movement.MovementPattern;
import de.tum.in.ase.eist.entities.ui.TextEffect;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Physics;
import de.tum.in.ase.eist.physics.Vec2;

public abstract class Enemy extends Entity {

    EnemySpawner spawner;
    private Color color = Color.RED;
    private int direction = 1;
    private Gun gun;
    private MovementPattern movement;
    private Sprite sprite;
    private boolean destroyNextFrame;
    int points = 200;

    public Enemy(Gun gun, MovementPattern movement, Sprite sprite, int size) {
        this.gun = gun;
        this.movement = movement;
        this.sprite = sprite;
        this.size = new Vec2(size, (int) (size * sprite.getWidthToHeightRatio()));
    }

    public void moveToRandomStartPoint() {
        position = movement.getSpawnLocation(this);
    }

    @Override
    public void onUpdate() {

        if (destroyNextFrame || !Physics.detectCollision(position, size, Vec2.ZERO, board().size())) {
            selfdestruct();
            return;
        }

        gun.fire(this);
        movement.move(this);

    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawImage(position, size, sprite);
    }

    public void takeDamage() {
        board().registerEntity(new Explosion(position.cornerToCenter(size), new Vec2(size.x(), size.x())));
        board().registerEntity(new TextEffect(position.cornerToCenter(size),""+points),null,2);
        SpaceShip player = board().getEntityByTag("Player");
        player.addScore(points);
        destroyNextFrame = true;
    }


    private void selfdestruct() {
        board().removeEntity(this);
        spawner.getAllEnemys().remove(this);
    }
}
