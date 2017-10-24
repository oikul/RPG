package world;

public class World {
	
	private ValueNoiseGenerator generator;
	
	public World(){
		generator = new ValueNoiseGenerator(0, 40, 60, 4);
	}

}
