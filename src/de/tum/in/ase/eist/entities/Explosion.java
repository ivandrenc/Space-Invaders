package de.tum.in.ase.eist.entities;

import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;

public class Explosion extends Entity {

    private static int DIAMETER =100;
    private int time = 10;
    private Sprite sprite;


    public Explosion(Vec2 position, Vec2 size) {
        this.position = position.centerToCorner(size);
        this.size = size;
    }

    @Override
    public void onUpdate() {
        time--;
        sprite = switch (time/2){
            default -> Sprite.EXPLOSION1;
            case 3 -> Sprite.EXPLOSION2;
            case 2 -> Sprite.EXPLOSION3;
            case 1 -> Sprite.EXPLOSION4;
            case 0 -> Sprite.EXPLOSION5;
        };
       if(time == 0){
           board().removeEntity(this);
       }
    }


    @Override
    public void onDraw(PaintBrush brush){
        brush.drawImage(position,size,sprite);
    }

}
