package battle;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Battle {

	private Random random;
	private ArrayList<Entity> entities, party, enemies;

	public Battle(Image background, ArrayList<Entity> party, long seed) {
		random = new Random();
		this.party = party;
		getEnemies();
		fillEntityList();
		for(Entity e : entities){
			System.out.println(e.getSpeed());
		}
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics g){
		
	}

	/**
	 * fills the list of enemies
	 */
	public void getEnemies() {
		enemies = new ArrayList<Entity>();
		int num = random.nextInt(10);
		System.out.println("making " + num + " enemies");
		for(int i = 0; i < num; i++){
			enemies.add(new Entity());
		}
	}

	/**
	 * adds entities to the list in the right order based on their speed and
	 * random chance
	 */
	public void fillEntityList() {
		entities = new ArrayList<Entity>();
		entities.addAll(party);
		entities.addAll(enemies);
		entities.sort(new Comparator<Entity>(){
			@Override
			public int compare(Entity e1, Entity e2) {
				if(e1.getSpeed() >= e2.getSpeed()){
					return 1;
				}else{
					return -1;
				}
			}
		});
	}

	public void doTurn() {
		for(Entity e : entities){
			e.takeTurn();
		}
	}

}
