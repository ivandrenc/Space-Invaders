package de.tum.in.ase.eist.entities;

import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboardui.rendering.IPaintBrush;

import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;
import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(EasyMockExtension.class)
public class SpaceShipTest {

    @Mock
    IPaintBrush brush;

    @Test
    void testCorrectDrawing(){
        SpaceShip ship = new SpaceShip();
        Vec2 position = new Vec2(25,75);
        Vec2 size = new Vec2(10,30);
        ship.position = position;
        ship.size = size;

        brush.drawImage(position,size, Sprite.SPACESHIP_ICON);
        EasyMock.expectLastCall();
        EasyMock.replay(brush);

        ship.onDraw(brush);
    }

    @Test
    void testTakeDamage(){
        GameBoard board = new GameBoard(null, 500,500);
        SpaceShip ship = new SpaceShip();
        board.registerEntity(ship);
        int healthBefore = ship.getHealth();
        ship.takeDamage();
        assertEquals(healthBefore-1,ship.getHealth());

    }

    @Test
    void testInvincibility(){
        GameBoard board = new GameBoard(null, 500,500);
        SpaceShip ship = new SpaceShip();
        board.registerEntity(ship);
        int healthBefore = ship.getHealth();
        ship.takeDamage();
        ship.takeDamage();
        ship.takeDamage();
        ship.takeDamage();
        assertEquals(healthBefore-1,ship.getHealth());
    }

}
