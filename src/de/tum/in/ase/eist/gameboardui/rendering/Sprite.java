package de.tum.in.ase.eist.gameboardui.rendering;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// a simple buffer for sprites
public enum Sprite {

	SPACESHIP_ICON("ressources/spaceship.png"),
	SPACE_INVADER1("ressources/Enemy1.png"),
	SPACE_INVADER3("ressources/Enemy3.png"),
	SPACE_INVADER4("ressources/Enemy4.png"),
	SPACE_INVADER6("ressources/Enemy6.png"),
	SPACE_INVADER2("ressources/Enemy2.png"),
	BACKGROUND_IMAGE("ressources/spaceBackground.jpg"),
	END_BACKGROUND("ressources/EndBackground.jpg"),
	HEART1("ressources/Heart1.png"),
	HEART2("ressources/Heart2.png"),
	HEART3("ressources/Heart3.png"),
	COIN("ressources/Coin.png"),
	EXPLOSION1("ressources/Explosions/explosion1.png"),
	EXPLOSION2("ressources/Explosions/explosion2.png"),
	EXPLOSION3("ressources/Explosions/explosion3.png"),
	EXPLOSION4("ressources/Explosions/explosion4.png"),
	EXPLOSION5("ressources/Explosions/explosion5.png");


	private final Image img;
	private final float widthToHeightRatio;

	Sprite(String s) {
		try {
			img = ImageIO.read(new File(s));
			widthToHeightRatio = (float) img.getHeight(null) / img.getWidth(null);
		} catch (IOException e) {
			throw new IllegalArgumentException("could not load: " + "s");
		}
	}

	Image getImage() {
		return img;
	}

	public float getWidthToHeightRatio() {
		return widthToHeightRatio;
	}
}
