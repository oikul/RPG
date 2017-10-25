package world;

public class World {
	
	private ValueNoiseGenerator generator;
	
	public World(){
		generator = new ValueNoiseGenerator(0, 1, 1, 1);
	}

}
