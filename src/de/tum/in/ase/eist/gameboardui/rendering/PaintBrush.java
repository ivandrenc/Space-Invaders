package de.tum.in.ase.eist.gameboardui.rendering;

import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;


// a wrapper around java.awt.Graphics2D functionality
public class PaintBrush {

    private final Graphics2D graphics2D;

    public PaintBrush(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public void drawSquare(Vec2 position, Vec2 size, Color c) {
        graphics2D.setColor(c);
        graphics2D.fillRect(position.x(), position.y(), size.x(), size.y());
    }

    public void drawImage(Vec2 position, Vec2 size, Sprite sprite) {
        graphics2D.drawImage(sprite.getImage(), position.x(), position.y(), size.x(), size.y(), null);
    }

    public void drawText(Vec2 position, String text,Fonts font, Color c) {
        graphics2D.setFont(font.font());
        graphics2D.setColor(c);
        graphics2D.drawString(text,position.x(), position.y());
    }
}
