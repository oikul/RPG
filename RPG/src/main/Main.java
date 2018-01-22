package main;

import java.awt.Graphics;
import java.util.Random;

import world.World;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;
	private Graphics offG;
	public static float ratio = Math.min(InputHandler.screenSize.width, InputHandler.screenSize.height) / 12f / 16f;
	private World world;
	private Random random = new Random();

	@Override
	public void initialise() {
		running = true;
		this.defaultInit("RPG Game");
		offG = offImage.getGraphics();
		world = new World(random.nextLong(), random.nextLong(), random.nextLong());
	}

	@Override
	public void update(float time) {
		world.update();
	}

	@Override
	public void draw() {
		world.draw(offG);
		g.drawImage(offImage, 0, 0, width, height, null);
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
