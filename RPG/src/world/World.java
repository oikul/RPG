package world;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {
	
	public static ValueNoiseGenerator generator;
	private ArrayList<Chunk> chunks = new ArrayList<Chunk>();
	
	public World(){
		generator = new ValueNoiseGenerator(0, 1, 1, 1);
		chunks.add(new Chunk(0, 0));
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics g){
		
	}

}
