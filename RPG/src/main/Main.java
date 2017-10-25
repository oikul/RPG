package main;

import java.awt.Color;
import java.awt.Graphics;

import world.Block;
import world.ValueNoiseGenerator;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;
	private Graphics offG;
	private float ratio = Math.min(InputHandler.screenSize.width, InputHandler.screenSize.height) / 12f / 16f;
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
		Block.updateliquids();
	}

	@Override
	public void draw() {
		for(int i = 0; i < noise.length; i++){
			for(int j = 0; j < noise[0].length; j++){
				if(noise[i][j] < 0.5){
					Block.water_river.draw(offG, (int)(i * 16 * ratio), (int) (j * 16 * ratio), ratio, width, height);
				}else{
					Block.sand_dunes.draw(offG, (int)(i * 16 * ratio), (int) (j * 16 * ratio), ratio, width, height);
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
