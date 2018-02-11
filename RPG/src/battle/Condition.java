package battle;

public class Condition {
	
	public static enum STAT{
		HEALTH, ENERGY
	}
	
	private STAT stat;
	private double value, percentage;
	private boolean state;
	
	
	public Condition(STAT stat, double value, double percentage, boolean state){
		
	}

}
