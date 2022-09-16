package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.gameboardui.rendering.Fonts;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class HealthLabel extends StatsLabel {

    private Vec2 heartSize = new Vec2(20, (int)(Sprite.HEART1.getWidthToHeightRatio()* 20));
    private Sprite actualSprite = Sprite.HEART1;

    @Override
    public void onRegister() {
        numberLabel = new Vec2(75, 17);
        descriptionLabel = new Vec2(20, 30);
        player = board().getEntityByTag("Player");
    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawText(descriptionLabel, "Health: ", Fonts.IMPACT_15, Color.WHITE);
        Vec2 location = numberLabel;
        for( int i = 0;i < player.getMAX_HEALTH()/2;i++){
            int status = player.getHealth()-(i*2);
            Sprite s;
            if(status == 1){
                s = Sprite.HEART2;
                actualSprite = Sprite.HEART2;
            }else if(status >= 2){
                s = Sprite.HEART1;
                actualSprite = Sprite.HEART1;
            }else{
                s = Sprite.HEART3;
                actualSprite = Sprite.HEART3;
            }
            brush.drawImage(location,heartSize,s);
            location = location.add(27,0);
        }

    }

    public Sprite getActualSprite() {
        return actualSprite;
    }
}
