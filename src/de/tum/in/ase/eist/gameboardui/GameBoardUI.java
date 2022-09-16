package de.tum.in.ase.eist.gameboardui;

import de.tum.in.ase.eist.gameboard.GameBoard;
import de.tum.in.ase.eist.gameboardui.rendering.PaintBrush;
import de.tum.in.ase.eist.physics.Vec2;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class GameBoardUI {

	public static void main(String[] args) {
		new GameBoardUI();
	}

	// With toolkit we get the width and height of the screen independent of the users machine.
	public static final int width = 800, height = 720, framerateGraphics = 60, frameratePhysic = 60;
	private JFrame frame;
	private GameBoard gameBoard;
	private Input input = new Input();

	public GameBoardUI() {
		// setup swing stuff
		frame = new JFrame("Space Invaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics graphics) {
				super.paint(graphics);
				draw(new PaintBrush((Graphics2D) graphics));
			}
		};
		panel.setPreferredSize(new Dimension(width, height));
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		// Make appear the window in the center of the screen for the user, independent of the size of the users computer
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

		// setup input
		frame.addKeyListener(input.getKeyListener());
		frame.setFocusable(true);

		// setup gameBoard
		gameBoard = new GameBoard(input, width, height);

		// start the game

		frame.setVisible(true);

		// timer for graphical updates
		Timer graphicsTimer = new Timer(1000 / framerateGraphics, s -> {
			frame.repaint();
		});
		graphicsTimer.start();

		// timer for Physic updates
		java.util.Timer timer = new java.util.Timer(true);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				gameBoard.update();
			}
		}, 1000, 1000 / frameratePhysic);

	}

	private void draw(PaintBrush brush) {
		brush.drawSquare(Vec2.ZERO, new Vec2(width, height), Color.BLACK);
		gameBoard.drawAll(brush);
	}

	public JFrame getFrame() {
		return frame;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public Input getInput() {
		return input;
	}
}
