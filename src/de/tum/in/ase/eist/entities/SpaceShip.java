package de.tum.in.ase.eist.entities;

import java.awt.event.KeyEvent;

import de.tum.in.ase.eist.gameboardui.GameBoardUI;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;

public class SpaceShip extends Entity {

    public static final Vec2 DEFAULT_POSITION = new Vec2(GameBoardUI.width/2 - 35, 500);
    public static final Vec2 DEFAULT_SIZE =  new Vec2(50, (int) (50 * Sprite.SPACESHIP_ICON.getWidthToHeightRatio()));

    private final int speed = 6;
    private final int MAX_HEALTH = 6;
    private int health;
    private int score = 0;

    //track invincibility after taking damage
    private int invincibleFramesDuration = 45;
    private int invincibleFrames;

    //cooldown for gun
    private int cooldown;
    private final int cooldownDuration = 30;


    public void onRegister() {
        position = DEFAULT_POSITION;
        size = DEFAULT_SIZE;
        health = MAX_HEALTH;
    }

    @Override
    public void onUpdate() {
        if (board().input().getKey(KeyEvent.VK_DOWN)) {
            if ((this.position.y() + size.y()) < GameBoardUI.height) {
                position = new Vec2(this.position.x(), this.position.y() + speed);
            }
        } else if (board().input().getKey(KeyEvent.VK_UP)) {
            if (this.position.y() > 0) {
                position = new Vec2(this.position.x(), this.position.y() - speed);
            }

        } else if (board().input().getKey(KeyEvent.VK_RIGHT)) {
            if ((this.position.x() + size.x()) < GameBoardUI.width) {
                position = new Vec2(this.position.x() + speed, this.position.y());
            }
        } else if (board().input().getKey(KeyEvent.VK_LEFT)) {
            if (this.position.x() > 0) {
                position = new Vec2(this.position.x() - speed, this.position.y());
            }
        }

        if (cooldown == 0 && board().input().getKey(KeyEvent.VK_SPACE)) {
            cooldown = cooldownDuration;
            board().registerEntity(new FriendlyBullet(position.add(size.x() / 2, 0)));
        }

        if (cooldown != 0)
            cooldown--;

        if (invincibleFrames != 0)
            invincibleFrames--;
        if (isPlayerDead()) {
            this.board().loadScene(2).init();
        }
    }

    public void takeDamage() {
        if (invincibleFrames == 0) {
            health--;
            invincibleFrames = invincibleFramesDuration;
            board().registerEntity(new Explosion(position.cornerToCenter(size), new Vec2(30, 30)));
        }
    }

    public boolean isPlayerDead() {
        return getHealth() <= 0;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void onDraw(PaintBrush brush) {
        if (invincibleFrames % 10 < 5) {
            brush.drawImage(position, size, Sprite.SPACESHIP_ICON);
        }
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public void setInvincibleFrames(int invincibleFrames) {
        this.invincibleFrames = invincibleFrames;
    }
}
