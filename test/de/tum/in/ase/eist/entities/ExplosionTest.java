package de.tum.in.ase.eist.entities;

import de.tum.in.ase.eist.gameboardui.rendering.IPaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;
import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EasyMockExtension.class)
public class ExplosionTest {

    @Mock
    IPaintBrush brush;

    @Test
    void testIconProgression() {
        Vec2 position = Vec2.ZERO, size = new Vec2(20, 20);
        Explosion explosion = new Explosion(position, size);
        explosion.position = position;
        explosion.size = size;
        brush.drawImage(position, size, Sprite.EXPLOSION1);
        EasyMock.expectLastCall();
        brush.drawImage(position, size, Sprite.EXPLOSION2);
        EasyMock.expectLastCall();
        brush.drawImage(position, size, Sprite.EXPLOSION3);
        EasyMock.expectLastCall();
        brush.drawImage(position, size, Sprite.EXPLOSION4);
        EasyMock.expectLastCall();
        brush.drawImage(position, size, Sprite.EXPLOSION5);
        EasyMock.expectLastCall();
        EasyMock.replay(brush);

        explosion.onUpdate();
        explosion.onDraw(brush);
        explosion.onUpdate();
        explosion.onUpdate();

        explosion.onDraw(brush);
        explosion.onUpdate();
        explosion.onUpdate();

        explosion.onDraw(brush);
        explosion.onUpdate();
        explosion.onUpdate();

        explosion.onDraw(brush);
        explosion.onUpdate();
        explosion.onUpdate();

        explosion.onDraw(brush);

    }
}
