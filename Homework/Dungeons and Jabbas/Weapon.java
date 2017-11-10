package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Weapon implements Treasure{
	private String name;
	private int damage;
	
	public  Weapon(String n, int d) {
		setName(n);
		setDamage(d);
	}
	
	public void setName(String n) {
		this.name=n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDamage(int d) {
		this.damage=d;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String collect(Hero h) {
	//	if(h_attack<this.getDamage()) doesn't work ?
		h.equip(this);
		String a="Weapon found! Damage points: ";
		int d=h.getWeapon().getDamage(); 
		String b=Integer.toString(d);
		return a+b;

	}

}
