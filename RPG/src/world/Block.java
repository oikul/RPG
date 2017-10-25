package world;

import java.awt.Graphics;
import java.awt.Image;

import main.ResourceHandler;

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
	
	public void draw(Graphics g, int x, int y, float scale, int screenWidth, int screenHeight){
		if(x < screenWidth && y < screenHeight){
			g.drawImage(sprites[currentFrame], x, y, (int) (width * scale), (int) (height * scale), null);
		}
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
	
	public static final Block grass_forest = new Block("grass", "grass/grass_forest", 0, false, 16, 16);
	public static final Block grass_jungle = new Block("grass", "grass/grass_jungle", 0, false, 16, 16);
	public static final Block grass_mountains = new Block("grass", "grass/grass_mountains", 0, false, 16, 16);
	public static final Block grass_plains = new Block("grass", "grass/grass_plains", 0, false, 16, 16);
	public static final Block grass_rainforest = new Block("grass", "grass/grass_rainforest", 0, false, 16, 16);
	public static final Block grass_savannah = new Block("grass", "grass/grass_savannah", 0, false, 16, 16);
	public static final Block grass_snowy = new Block("grass", "grass/grass_snowy", 0, false, 16, 16);
	public static final Block grass_steppe = new Block("grass", "grass/grass_steppe", 0, false, 16, 16);
	public static final Block grass_tundra = new Block("grass", "grass/grass_tundra", 0, false, 16, 16);
	
	public static final Block ice = new Block("ice", "ice/ice_1", 0, false, 16, 16);
	public static final Block ice_spikes = new Block("ice spikes", "ice/ice_spikes", 0, false, 16, 16);
	public static final Block ice_spikes_1 = new Block("ice spikes", "ice/ice_spikes_1", 0, false, 16, 16);
	public static final Block snow = new Block("snow", "ice/snow_1", 0, false, 16, 16);
	
	public static final Block lava = new Block("lava", "lava/lava", 700, true, 16, 16);
	
	public static final Block sand = new Block("sand", "sand/sand", 0, false, 16, 16);
	public static final Block sand_arid = new Block("sand", "sand/sand_arid", 0, false, 16, 16);
	public static final Block sand_beach = new Block("sand", "sand/sand_beach", 0, false, 16, 16);
	public static final Block sand_cracked = new Block("sand", "sand/sand_cracked", 0, false, 16, 16);
	public static final Block sand_dunes = new Block("sand", "sand/sand_dunes", 0, false, 16, 16);
	
	public static final Block clay = new Block("clay", "stone/clay", 0, false, 16, 16);
	public static final Block rock = new Block("rock", "stone/rock", 0, true, 16, 16);
	public static final Block rocks = new Block("rocks", "stone/rocks", 0, true, 16, 16);
	public static final Block stone = new Block("stone", "stone/stone", 0, false, 16, 16);
	public static final Block stone_mossy = new Block("mossy stone", "stone/stone_mossy", 0, false, 16, 16);
	public static final Block stone_snowy = new Block("snowy stone", "stone/stone_snowy", 0, false, 16, 16);
	public static final Block stone_solid = new Block("solid stone", "stone/stone_solid", 0, false, 16, 16);
	public static final Block stone_volcanic = new Block("volcanic stone", "stone/stone_volcanic", 0, false, 16, 16);
	
	public static final Block tree_baobab = new Block("baobab tree", "trees/tree_baobab", 0, true, 16, 16);
	public static final Block tree_birch = new Block("birch tree", "trees/tree_birch", 0, true, 16, 16);
	public static final Block tree_birch_1 = new Block("birch tree", "trees/tree_birch_1", 0, true, 16, 16);
	public static final Block tree_cactus = new Block("cactus", "trees/tree_cactus", 0, true, 16, 16);
	public static final Block tree_oak = new Block("oak tree", "trees/tree_oak", 0, true, 16, 16);
	public static final Block tree_oak_1= new Block("oak tree", "trees/tree_oak_1", 0, true, 16, 16);
	public static final Block tree_palm = new Block("palm tree", "trees/tree_palm", 0, true, 16, 16);
	public static final Block tree_pine = new Block("pine tree", "trees/tree_pine", 0, true, 16, 16);
	public static final Block tree_rubber = new Block("rubber tree", "trees/tree_rubber", 0, true, 16, 16);
	public static final Block tree_sequoia = new Block("sequoia tree", "trees/tree_sequoia", 0, true, 16, 16);
	public static final Block tree_shrub = new Block("shrub", "trees/tree_shrub", 0, false, 16, 16);
	public static final Block tree_shrub_1 = new Block("shrub", "trees/tree_shrub_1", 0, false, 16, 16);
	public static final Block tree_spruce = new Block("spruce tree", "trees/tree_spruce", 0, true, 16, 16);
	
	public static final Block water_test = new Block("test", "water/water_test", 400, true, 16, 16);
	public static final Block water_murky = new Block("murky water", "water/water_murky", 400, true, 16, 16);
	public static final Block water_ocean = new Block("deep water", "water/water_ocean", 400, true, 16, 16);
	public static final Block water_river = new Block("river water", "water/water_river", 400, true, 16, 16);
	

}
