package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Spell implements Treasure{
	private String name;
	private int damage;
	private int manaCost;
	
	public  Spell(String n, int d,int mc) {
		setName(n);
		setDamage(d);
		setmanaCost(mc);
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
	public void setmanaCost(int mc) {
		this.manaCost=mc;
	}
	
	public int getManaCost() {
		return this.manaCost;
	}
	
	@Override
	public String collect(Hero h) {
		h.learn(this);
		String a="Spell found! Damage points: ";
		int d=h.getSpell().getDamage();
		String b=Integer.toString(d);
		int mc=getManaCost();
		String c=Integer.toString(mc);
		String f=" Mana cost: ";
		return a+b+f+c;
		
	}

}
