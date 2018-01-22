package world;

public class Chunk {
	
	private float[][] height;
	private int startx, starty;
	
	public Chunk(int startx, int starty){
		setHeight(World.heightGen.getValueNoise(startx, starty, 32, 32));
		this.startx = startx;
		this.starty = starty;
	}
	
	public int getStartx() {
		return startx;
	}

	public void setStartx(int startx) {
		this.startx = startx;
	}

	public int getStarty() {
		return starty;
	}

	public void setStarty(int starty) {
		this.starty = starty;
	}

	public float getHeight(int x, int y){
		return height[x - startx][y - starty];
	}

	public float[][] getHeight() {
		return height;
	}
	
	public void setHeight(int x, int y, float height){
		this.height[x - startx][y - starty] = height;
	}

	public void setHeight(float[][] height) {
		this.height = height;
	}

}
