package powers;

public class Power {
	
	private enum Type {
			BALL, BLAST, BEAM, HEAL, FORM, SUMMON, SHIELD, BOOST, CANNON, AOE
	}
	
	private enum Element {
			NONE, ENERGY, FIRE, WATER, AIR, EARTH, METAL, LAVA, MIST, ICE, LIGHTNING, MUD, PSYCHIC, PLANT, DARK, LIGHT
	}
	
	private String name;
	private int level;
	private Type type;
	private Element element1, element2;
	
	public Power(String name, Type type, Element element1, Element element2, String imagePath){
		this.name = name;
		level = 1;
		this.element1 = element1;
		this.element2 = element2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Element getElement1() {
		return element1;
	}

	public void setElement1(Element element1) {
		this.element1 = element1;
	}

	public Element getElement2() {
		return element2;
	}

	public void setElement2(Element element2) {
		this.element2 = element2;
	}
	
	//energy
	public static Power energyBall = new Power("Energy Ball", Type.BALL, Element.ENERGY, Element.NONE, "");
	public static Power energyBlast = new Power("Energy Blast", Type.BLAST, Element.ENERGY, Element.NONE, "");
	public static Power energyBeam = new Power("Energy Beam", Type.BEAM, Element.ENERGY, Element.NONE, "");
	public static Power heal = new Power("Heal", Type.HEAL, Element.ENERGY, Element.NONE, "");
	public static Power energyShield = new Power("Energy Shield", Type.SHIELD, Element.ENERGY, Element.NONE, "");
	public static Power boost = new Power("Boost", Type.BOOST, Element.ENERGY, Element.NONE, "");
	public static Power energyForm = new Power("Energy Form", Type.FORM, Element.ENERGY, Element.NONE, "");
	public static Power energyCannon = new Power("Energy Cannon", Type.CANNON, Element.ENERGY, Element.NONE, "");
	
	//fire
	public static Power fireBall = new Power("Fire Ball", Type.BALL, Element.FIRE, Element.NONE, "");
	public static Power fireBlast = new Power("Fire Blast", Type.BLAST, Element.FIRE, Element.NONE, "");
	public static Power fireBeam = new Power("Fire Beam", Type.BEAM, Element.FIRE, Element.NONE, "");
	public static Power fireForm = new Power("Fire Form", Type.FORM, Element.FIRE, Element.NONE, "");
	public static Power flameBoost = new Power("Flame Boost", Type.BOOST, Element.FIRE, Element.NONE, "");
	public static Power fireCannon = new Power("Fire Cannon", Type.CANNON, Element.FIRE, Element.NONE, "");
	public static Power enflame = new Power("Enflame", Type.AOE, Element.FIRE, Element.NONE, "");

	//water
	public static Power waterBall = new Power("Water Ball", Type.BALL, Element.WATER, Element.NONE, "");
	public static Power waterBlast = new Power("Water Blast", Type.BLAST, Element.WATER, Element.NONE, "");
	public static Power waterBeam = new Power("Water Beam", Type.BEAM, Element.WATER, Element.NONE, "");
	public static Power waterHeal = new Power("Water Heal", Type.HEAL, Element.WATER, Element.NONE, "");
	public static Power waterForm = new Power("Water Form", Type.FORM, Element.WATER, Element.NONE, "");
	public static Power waterCannon = new Power("Water Cannon", Type.CANNON, Element.WATER, Element.NONE, "");
	
	//air
	public static Power airBall = new Power("Air Ball", Type.BALL, Element.AIR, Element.NONE, "");
	public static Power airBlast = new Power("Air Blast", Type.BLAST, Element.AIR, Element.NONE, "");
	public static Power airBeam = new Power("Air Beam", Type.BEAM, Element.AIR, Element.NONE, "");
	public static Power airForm = new Power("Air Form", Type.FORM, Element.AIR, Element.NONE, "");
	public static Power airBoost = new Power("Air Boost", Type.BOOST, Element.AIR, Element.NONE, "");
	public static Power airCannon = new Power("Air Cannon", Type.CANNON, Element.AIR, Element.NONE, "");
	public static Power push = new Power("Push", Type.AOE, Element.AIR, Element.NONE, "");
	
	//earth
	public static Power earthBall = new Power("Earth Ball", Type.BALL, Element.EARTH, Element.NONE, "");
	public static Power earthBlast = new Power("Earth Blast", Type.BLAST, Element.EARTH, Element.NONE, "");
	public static Power earthBeam = new Power("Earth Beam", Type.BEAM, Element.EARTH, Element.NONE, "");
	public static Power earthForm = new Power("Earth Form", Type.FORM, Element.EARTH, Element.NONE, "");
	public static Power earthShield = new Power("Earth Shield", Type.SHIELD, Element.EARTH, Element.NONE, "");
	public static Power entomb = new Power("Entomb", Type.AOE, Element.EARTH, Element.NONE, "");
	
}
