package world;

public class Chunk {
	
	private float[][] temperature, precipitation, height;
	
	public Chunk(int startx, int starty){
		setTemperature(World.tempGen.getValueNoise(startx, starty, 32, 32));
		setPrecipitation(World.precipGen.getValueNoise(startx, starty, 32, 32));
		setHeight(World.heightGen.getValueNoise(startx, starty, 32, 32));
	}
	
	public float getTemperature(int x, int y){
		return temperature[x][y];
	}

	public float[][] getTemperature() {
		return temperature;
	}
	
	public void setTemperature(int x, int y, float temperature){
		this.temperature[x][y] = temperature;
	}

	public void setTemperature(float[][] temperature) {
		this.temperature = temperature;
	}
	
	public float getPrecipitation(int x, int y){
		return precipitation[x][y];
	}

	public float[][] getPrecipitation() {
		return precipitation;
	}
	
	public void setPrecipitation(int x, int y, float precipitation){
		this.precipitation[x][y] = precipitation;
	}

	public void setPrecipitation(float[][] precipitation) {
		this.precipitation = precipitation;
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
