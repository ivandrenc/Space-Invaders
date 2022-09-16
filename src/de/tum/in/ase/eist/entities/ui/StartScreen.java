package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.gameboardui.GameBoardUI;
import de.tum.in.ase.eist.gameboardui.rendering.Fonts;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StartScreen extends Entity {


    private Vec2 subTextPosition;

    @Override
    public void onRegister() {
        position = new Vec2(GameBoardUI.width/2 - 200, GameBoardUI.height/2 - 100);
        subTextPosition = new Vec2(GameBoardUI.width / 2 - 145, GameBoardUI.height / 2 - 40);
    }

    @Override
    public void onUpdate() {
        if (board().input().getKey(KeyEvent.VK_SPACE)) {
            board().loadScene(1).init();
        }
    }

    @Override
    public void onDraw(PaintBrush brush) {
        //brush.drawSquare(Vec2.ZERO,board().size(),Color.black);
        brush.drawText(position, "SpaceInvaders", Fonts.IMPACT_60, Color.white);
        brush.drawText(subTextPosition, "[ press space to start ]", Fonts.IMPACT_30, Color.white);
        brush.drawImage(SpaceShip.DEFAULT_POSITION, SpaceShip.DEFAULT_SIZE, Sprite.SPACESHIP_ICON);
    }
}
