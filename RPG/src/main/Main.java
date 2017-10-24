package main;

import java.awt.Color;
import java.awt.Graphics;

import world.ValueNoiseGenerator;
import handlers.InputHandler;
import utils.AbstractMain;
import world.Block;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;
	private Graphics offG;
	private float ratio = Math.min(InputHandler.screenSize.width, InputHandler.screenSize.height) / 12f / 16f;
	Block block = new Block("test", "water/water_test", 400, true, 16, 16);
	Block block2 = new Block("test2", "grass/grass_forest", 400, true, 16, 16);
	ValueNoiseGenerator generator = new ValueNoiseGenerator(0, 1, 1, 1);
	private float[][] noise;

	@Override
	public void initialise() {
		running = true;
		this.defaultInit("RPG Game");
		offG = offImage.getGraphics();
		offG.setColor(Color.BLACK);
		offG.fillRect(0, 0, width, height);
		noise = generator.getValueNoise(0, 0, 16, 16);
	}

	@Override
	public void update(float time) {
		block.update();
	}

	@Override
	public void draw() {
		for(int i = 0; i < noise.length; i++){
			for(int j = 0; j < noise[0].length; j++){
				if(noise[i][j] < 0.5){
					block.draw(offG, (int)(i * 16 * ratio), (int) (j * 16 * ratio), ratio);
				}else{
					block2.draw(offG, (int)(i * 16 * ratio), (int) (j * 16 * ratio), ratio);
				}
			}
		}
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
