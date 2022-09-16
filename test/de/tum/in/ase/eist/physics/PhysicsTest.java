package de.tum.in.ase.eist.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhysicsTest {


    @Test
    void testCollision() {
        Vec2 pos1 = new Vec2(20, 20), pos2 = new Vec2(40, 60), size1 = new Vec2(50, 70), size2 = new Vec2(40, 20);
        assertTrue(Physics.detectCollision(pos1,size1,pos2,size2));
    }

    @Test
    void testNoCollision() {
        Vec2 pos1 = new Vec2(20, 20), pos2 = new Vec2(40, 40), size1 = new Vec2(10, 10), size2 = new Vec2(40, 20);
        assertFalse(Physics.detectCollision(pos1,size1,pos2,size2));
    }
}
