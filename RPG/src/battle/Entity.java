package battle;

import java.util.ArrayList;
import java.util.Random;

public class Entity {
	
	private int permHealth, tempHealth, permEnergy, tempEnergy;
	private double strength, weaponDamage, speed;
	private boolean side;
	private Random random;
	private ArrayList<Behaviour> AI;
	
	public Entity(){
		random = new Random();
		speed = Math.round(random.nextDouble() * 100) / 10.0;
	}

	public void takeTurn(){
		if(tempHealth > 0){
			
		}
	}
	
	public int getPermHealth() {
		return permHealth;
	}

	public void setPermHealth(int permHealth) {
		this.permHealth = permHealth;
	}

	public int getTempHealth() {
		return tempHealth;
	}

	public void setTempHealth(int tempHealth) {
		this.tempHealth = tempHealth;
	}

	public int getPermEnergy() {
		return permEnergy;
	}

	public void setPermEnergy(int permEnergy) {
		this.permEnergy = permEnergy;
	}

	public int getTempEnergy() {
		return tempEnergy;
	}

	public void setTempEnergy(int tempEnergy) {
		this.tempEnergy = tempEnergy;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public double getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(double weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}

}
