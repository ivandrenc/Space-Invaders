package de.tum.in.ase.eist.entities.ui;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboardui.GameBoardUI;
import de.tum.in.ase.eist.gameboardui.rendering.Fonts;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Vec2;
import de.tum.in.ase.eist.scoreserver.ScoreServer;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ScoreScreen extends Entity {

    private SpaceShip player;
    private Vec2 gameOverBoard;
    private int finalScore;
    private ScoreServer scoreBoard;
    private ArrayList<String> serverData;
    private int MAX_NUM_SESSIONS = 10;

    @Override
    public void onRegister() {
        position = new Vec2(GameBoardUI.width/2 - 150, GameBoardUI.height/2 - 200);
        gameOverBoard = new Vec2(GameBoardUI.width/2 - 200, GameBoardUI.height/2 - 120);
        player = this.board().getPlayer();
        finalScore = player.getScore();
        scoreBoard = new ScoreServer();
        scoreBoard.startServer();
        scoreBoard.log(player.getScore(), LocalDateTime.now());
        serverData = scoreBoard.receiveData();

    }

    @Override
    public void onDraw(PaintBrush brush) {
        brush.drawText(position, "Scoreboard", Fonts.IMPACT_60, Color.WHITE);
        brush.drawText(new Vec2(GameBoardUI.width / 2 - 230, GameBoardUI.height / 2 - 120), "Session", Fonts.IMPACT_30, Color.WHITE);
        brush.drawText(new Vec2(GameBoardUI.width / 2 - 51, GameBoardUI.height / 2 - 120), "Score", Fonts.IMPACT_30, Color.WHITE);
        brush.drawText(new Vec2(GameBoardUI.width / 2 + 132, GameBoardUI.height / 2 - 120), "Date Played", Fonts.IMPACT_30, Color.WHITE);
        for (int i = 1; i <= serverData.size(); i++) {
            if (i == MAX_NUM_SESSIONS) {
                break;
            } else {
                String entry = serverData.get(i - 1);
                brush.drawText(new Vec2(GameBoardUI.width / 2 - 230, GameBoardUI.height / 2 - 90 + i * 30), entry, Fonts.IMPACT_30, Color.WHITE);
            }
        }

    }
}
