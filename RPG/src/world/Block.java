package world;

import java.awt.Image;

import handlers.ResourceHandler;

public class Block {
	
	private String name;
	private int frames, delay;
	private boolean collideable;
	private Image[] sprites;
	
	public Block(String name, String imagePath, int delay, boolean collideable){
		setName(name);
		sprites = ResourceHandler.getBlockSprites(imagePath, 16, 16);
		setFrames(sprites.length);
		setDelay(delay);
		setCollideable(collideable);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getFrames() {
		return frames;
	}
	
	public void setFrames(int frames) {
		this.frames = frames;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public boolean isCollideable() {
		return collideable;
	}
	
	public void setCollideable(boolean collideable) {
		this.collideable = collideable;
	}

}
