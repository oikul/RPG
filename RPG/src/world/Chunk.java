package world;

public class Chunk {
	
	private float[][] height;
	
	public Chunk(int startx, int starty){
		setHeight(World.heightGen.getValueNoise(startx, starty, 32, 32));
	}
	
	public float getHeight(int x, int y){
		return height[x][y];
	}

	public float[][] getHeight() {
		return height;
	}
	
	public void setHeight(int x, int y, float height){
		this.height[x][y] = height;
	}

	public void setHeight(float[][] height) {
		this.height = height;
	}

}
