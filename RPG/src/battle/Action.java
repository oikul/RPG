package battle;

import items.Item;
import powers.Power;

public class Action {
	
	private TYPE type;
	private double damage;
	private Power power;
	private Item item;
	
	public static enum TYPE{
		MELEE, POWER, RUN, ITEM
	}
	
	public Action(TYPE type, double damage, Power power, Item item){
		setType(type);
		setDamage(damage);
		setPower(power);
		setItem(item);
	}
	
	public void doAction(){
		switch(type){
		case ITEM:
			break;
		case MELEE:
			break;
		case POWER:
			break;
		case RUN:
			break;
		}
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
