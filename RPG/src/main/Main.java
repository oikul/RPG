package main;

import java.awt.Color;
import java.awt.Graphics;

import utils.AbstractMain;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;
	private Graphics offG;

	@Override
	public void initialise() {
		running = true;
		this.defaultInit("RPG Game");
		offG = offImage.getGraphics();
		offG.setColor(Color.BLACK);
		offG.fillRect(0, 0, width, height);
	}

	@Override
	public void update(float time) {
	}

	@Override
	public void draw() {
		g.drawImage(offImage, 0, 0, null);
	}

	@Override
	public void close() {
		running = false;
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

}
