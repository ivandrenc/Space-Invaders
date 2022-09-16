package de.tum.in.ase.eist.entities;

import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DebugSquare extends Entity {

    private Color c;

    public void onRegister() {
        position = new Vec2(20, 20);
        size = new Vec2(50, 50);
    }

    @Override
    public void onUpdate() {
        if (board().input().getKey(KeyEvent.VK_SPACE)) {
            c = Color.BLUE;
        } else {
            c = Color.RED;
        }
    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawSquare(position, size, c);
    }
}
