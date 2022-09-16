package de.tum.in.ase.eist.gameboard;

import de.tum.in.ase.eist.entities.SpaceShip;
import de.tum.in.ase.eist.gameboard.scenes.EndScreenScene;
import de.tum.in.ase.eist.gameboard.scenes.PlayingScene;
import de.tum.in.ase.eist.gameboard.scenes.ScoreScreenScene;
import de.tum.in.ase.eist.gameboard.scenes.StartScreenScene;
import de.tum.in.ase.eist.gameboardui.Input;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Vec2;

import java.util.*;

public class GameBoard {
    private SpaceShip player = null;
    private Scene[] scenes = {new StartScreenScene(this), new PlayingScene(this), new EndScreenScene(this), new ScoreScreenScene(this)};

    private Scene activeScene;

    // temporary storage
    private GameObject[] tempGameObjects = {};

    // get user input from here
    private final Input input;

    private final Random random = new Random(42);
    private Vec2 size;

    // gets created by GameBoardUI
    public GameBoard(Input input, int width, int height) {
        this.input = input;
        this.size = new Vec2(width, height);
        activeScene = scenes[0].init();
    }

    // draw all entities, called by GameBoardUI
    public void drawAll(PaintBrush brush) {
        for (var e : tempGameObjects)
            e.onDraw(brush);
    }

    // call the update methode on all entities
    private void updateAll() {
        tempGameObjects = activeScene.getGamObjectArray();
        for (GameObject obj : tempGameObjects) {
            obj.onUpdate();
        }
    }

    // Entities have to registered in order to work properly
    public <T extends GameObject> T registerEntity(T gameObject, String tag, int layer) {
        activeScene.add(gameObject, tag, layer);
        return gameObject;
    }

    public <T extends GameObject> T registerEntity(T gameObject) {
        return registerEntity(gameObject, null, 1);
    }

    // call this to remove entities from the game
    public void removeEntity(GameObject gameObject) {
        activeScene.remove(gameObject);
    }

    public Input input() {
        return input;
    }

    public void update() {
        updateAll();
    }

    public <T extends GameObject> T getEntityByTag(String s) {
        return activeScene.getEntityByTag(s);
    }

    public SpaceShip getPlayer() {
        return player;
    }

    public int getWidth() {
        return size.x();
    }

    public int getHeight() {
        return size.y();
    }

    public Random random() {
        return random;
    }

    public Vec2 size() {
        return size;
    }

    public Scene getActiveScene() {
        return activeScene;
    }

    public Scene loadScene(int i) {
        activeScene = scenes[i];
        return activeScene;
    }

    public void setPlayer(SpaceShip player) {
        this.player = player;
    }
}
