package de.tum.in.ase.eist.entities.Backgrounds;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.gameboardui.GameBoardUI;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.gameboardui.rendering.Sprite;
import de.tum.in.ase.eist.physics.Vec2;

public class Background extends Entity {

	private int rollSpeed = 2;
	private int posX = 0;
	private int posY = 0;
	private int posY2 = -GameBoardUI.height;
	private int scaleX = GameBoardUI.width;
	private int scaleY = GameBoardUI.height;

	// these are just arbitrary constants i found after experimenting with esthetics
	// and covering spaces

	public void onRegister() {
		position = new Vec2(posX, posY);
		size = new Vec2(scaleX, scaleY);
	}

	public void onUpdate() {
		this.position = new Vec2(this.position.x(), this.position.y() + rollSpeed);
		if (this.position.y() > 0) {
			this.position = new Vec2(posX, posY2);
		}
	}

	@Override
	public void onDraw(PaintBrush brush) {
		Vec2 Background2 = new Vec2(this.position.x(), (this.position.y() + this.board().getHeight()));
		brush.drawImage(position, size, Sprite.BACKGROUND_IMAGE);
		brush.drawImage(Background2, size, Sprite.BACKGROUND_IMAGE);
	}
}
