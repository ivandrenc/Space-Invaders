package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.gameboardui.rendering.Fonts;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class TextUI extends Entity {


    @Override
    public void onRegister(){
        position = new Vec2(10,100);
    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawText(position,"Hello World", Fonts.IMPACT_15, Color.BLUE);
    }
}
