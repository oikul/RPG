package world;

import java.awt.Graphics;
import java.awt.Image;

import handlers.ResourceHandler;

public class Block {
	
	private String name;
	private int frames, currentFrame, width, height;
	private long delay, currentTime, lastTime;
	private boolean collideable;
	private Image[] sprites;
	
	public Block(String name, String imagePath, long delay, boolean collideable, int width, int height){
		setName(name);
		sprites = ResourceHandler.getBlockSprites(imagePath, width, height);
		setFrames(sprites.length);
		setDelay(delay);
		setCollideable(collideable);
		setWidth(width);
		setHeight(height);
	}
	
	public void update(){
		currentTime = System.currentTimeMillis();
		if(lastTime + delay <= currentTime){
			if(currentFrame < sprites.length - 1){
				currentFrame++;
			}else{
				currentFrame = 0;
			}
			lastTime = System.currentTimeMillis();
		}
	}
	
	public void draw(Graphics g, int x, int y, float scale){
		g.drawImage(sprites[currentFrame], x, y, (int) (width * scale), (int) (height * scale), null);
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
	
	public long getDelay() {
		return delay;
	}
	
	public void setDelay(long delay) {
		this.delay = delay;
	}
	
	public boolean isCollideable() {
		return collideable;
	}
	
	public void setCollideable(boolean collideable) {
		this.collideable = collideable;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
