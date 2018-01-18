package world;

public class Chunk {
	
	private float[][] noise;
	
	public Chunk(int startx, int starty){
		setNoise(World.generator.getValueNoise(startx, starty, 32, 32));
	}
	
	public float getNoise(int x, int y){
		return noise[x][y];
	}

	public float[][] getNoise() {
		return noise;
	}
	
	public void setNoise(int x, int y, float value){
		this.noise[x][y] = value;
	}

	public void setNoise(float[][] noise) {
		this.noise = noise;
	}

}
