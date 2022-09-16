package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.gameboardui.rendering.Fonts;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class TextEffect extends Entity {

    Vec2 velocity = new Vec2(0,-1);
    String text;
    int duration = 30;
    Color c = Color.WHITE;

    public TextEffect(Vec2 position, String text) {
        this.position = position;
        this.text = text;
    }

    @Override
    public void onUpdate() {
        position = position.add(velocity);
        duration--;
        if (duration == 0){
            board().removeEntity(this);
        }
    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawText(position,text,Fonts.IMPACT_15, c);
    }
}
