package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.gameboardui.GameBoardUI;
import de.tum.in.ase.eist.gameboardui.rendering.Fonts;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;

import java.awt.*;

public class ScoreLabel extends StatsLabel{

    private Vec2 scoreLabelCoinSize = new Vec2(20, (int)(Sprite.COIN.getWidthToHeightRatio()* 20));
    private Vec2 spriteLocation = new Vec2(GameBoardUI.width - 130, 13);

    @Override
    public void onRegister() {
        numberLabel = new Vec2(GameBoardUI.width - 100, 30);
        descriptionLabel = new Vec2(GameBoardUI.width - 30, 30);
        player = board().getEntityByTag("Player");
    }

    @Override
    public void onDraw(PaintBrush brush) {
        Sprite scoreSprite = Sprite.COIN;
        brush.drawImage(spriteLocation, scoreLabelCoinSize, scoreSprite);
        brush.drawText(numberLabel, " Score: ", Fonts.IMPACT_15, Color.WHITE);
        brush.drawText(descriptionLabel, ""+player.getScore(), Fonts.IMPACT_15, Color.WHITE);
    }
}
