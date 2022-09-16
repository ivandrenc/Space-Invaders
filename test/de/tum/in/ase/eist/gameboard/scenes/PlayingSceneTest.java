package de.tum.in.ase.eist.gameboard.scenes;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboard.Scene;
import de.tum.in.ase.eist.gameboardui.Input;
import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

public class PlayingSceneTest {

    @Test
    void testCorrectObjectCreation() {
        PlayingScene scene = new PlayingScene(new GameBoard(null, 500, 500));
        scene.init();
        assertNotNull(scene.getEntityByTag("Player"));
        assertNotNull(scene.getEntityByTag("Spawner"));
        assertNotNull(scene.getEntityByTag("Health"));
        assertNotNull(scene.getEntityByTag("Score"));
    }

    @Test
    void testConcurrentModification() {
        PlayingScene scene = new PlayingScene(new GameBoard(null, 500, 500));
        scene.init();
        assertDoesNotThrow(() -> {
            for (var e : scene.getGamObjectArray()) {
                scene.remove(e);
            }
        });
    }

    @Test
    void testRemove() {
        PlayingScene scene = new PlayingScene(new GameBoard(null, 500, 500));
        scene.init();

        for (var e : scene.getGamObjectArray()) {
            scene.remove(e);
        }

        assertNull(scene.getEntityByTag("Player"));
        assertNull(scene.getEntityByTag("Spawner"));
        assertNull(scene.getEntityByTag("Health"));
        assertNull(scene.getEntityByTag("Score"));

    }

    @Test
    void testCorrectRegistration(){
        var board = new GameBoard(null, 500, 500);
        PlayingScene scene = new PlayingScene(board);
        boolean[] onRegisterCalled = new boolean[1];
        scene.init();
        Entity e = new Entity() {
            @Override
            public void onRegister() {
                onRegisterCalled[0] = true;
            }
        };
        scene.add(e,"TestTag",3);

        assertEquals(e, scene.getEntityByTag("TestTag"));
        assertEquals("TestTag",e.getTag());
        assertTrue(onRegisterCalled[0]);

    }


}