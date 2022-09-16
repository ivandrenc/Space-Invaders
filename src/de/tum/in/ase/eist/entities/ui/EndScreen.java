package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.gameboardui.GameBoardUI;
import de.tum.in.ase.eist.gameboardui.rendering.Fonts;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;
import java.awt.event.KeyEvent;

// SCENE 2
public class EndScreen extends Entity {
    // Game Over label
    private Vec2 subTextPosition1;
    private Vec2 subTextPosition2;
    private Vec2 subTextPosition3_YES;
    private Vec2 subTextPosition4_NO;
    private Vec2 getSubTextPosition5_PLAYAGAIN;

    final int selectionSwappCooldown = 10;
    int cooldown = 0;
    private boolean onYes = true;

    @Override
    public void onRegister() {
        int offsetMiddle = 20;
        position = new Vec2(GameBoardUI.width / 2 - 160 + offsetMiddle, GameBoardUI.height / 2 - 100);
        subTextPosition1 = new Vec2(GameBoardUI.width / 2 - 260 + offsetMiddle, GameBoardUI.height / 2 - 40);
        subTextPosition2 = new Vec2(GameBoardUI.width / 2 + 35 + offsetMiddle, GameBoardUI.height / 2 - 40);
        getSubTextPosition5_PLAYAGAIN = new Vec2(GameBoardUI.width / 2 - 180 + offsetMiddle, GameBoardUI.height / 2 + 80);
        subTextPosition3_YES = new Vec2(GameBoardUI.width / 2 - 120 + offsetMiddle, GameBoardUI.height / 2 + 130);
        subTextPosition4_NO = new Vec2(GameBoardUI.width / 2 + 40 + offsetMiddle, GameBoardUI.height / 2 + 130);
    }

    @Override
    public void onUpdate() {

        if (cooldown == 0) {
            if (board().input().getKey(KeyEvent.VK_ENTER)) {
                if (onYes) {
                    board().loadScene(0).init();
                } else {
                    board().loadScene(3).init();
                }
            } else if (board().input().getKey(KeyEvent.VK_RIGHT) || board().input().getKey(KeyEvent.VK_LEFT)) {
                cooldown = selectionSwappCooldown;
                onYes = !onYes;
            }
        } else {
            cooldown--;
        }

    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawText(position, "GAME OVER", Fonts.IMPACT_60, Color.white);
        brush.drawText(subTextPosition1, "You have been killed by", Fonts.IMPACT_30, Color.white);
        brush.drawText(subTextPosition2, "a deadly alien!", Fonts.IMPACT_30, Color.RED);
        brush.drawText(getSubTextPosition5_PLAYAGAIN, "Do you want to try again ?", Fonts.IMPACT_30, Color.ORANGE);
        if (onYes) {
            brush.drawSquare(subTextPosition3_YES.add(0,5), new Vec2(45, 3), Color.ORANGE);
        } else {
            brush.drawSquare(subTextPosition4_NO.add(0,5), new Vec2(35, 3), Color.ORANGE);
        }
        brush.drawText(subTextPosition3_YES, "YES", Fonts.IMPACT_30, Color.ORANGE);
        brush.drawText(subTextPosition4_NO, "NO", Fonts.IMPACT_30, Color.ORANGE);
    }
}
