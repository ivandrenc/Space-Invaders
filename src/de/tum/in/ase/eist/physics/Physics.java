package de.tum.in.ase.eist.physics;

public class Physics {
	public static boolean detectCollision(Vec2 position1, Vec2 size1, Vec2 position2, Vec2 size2) {
		boolean above = position1.y() + size1.y() < position2.y();
		boolean below = position1.y() > position2.y() + size2.y();
		boolean right = position1.x() + size1.x() < position2.x();
		boolean left = position1.x() > position2.x() + size2.x();

		return !above && !below && !right && !left;
	}

}
