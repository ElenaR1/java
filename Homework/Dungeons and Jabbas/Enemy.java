package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Enemy implements Actor {
	private String name;
	private int health;
	private int mana;
	private Weapon weapon;
	private Spell spell;
	
	public Enemy(String n, int h, int m,Weapon w,Spell s) {
		setName(n);
		setHealth(h);
		setMana(m);
		setWeapon(w);
		setSpell(s);
	}
	
	public void setName(String n) {
		this.name=n;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setHealth(int h) {
		this.health=h;
	}
	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.health;
	}

	public void setMana(int m) {
		this.mana=m;
	}
	@Override
	public int getMana() {
		// TODO Auto-generated method stub
		return this.mana;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		if(this.health>0)
			return true;
		else
		return false;
	}
	
	public void takeDamage(int damagePoints) {
		if(health-damagePoints>=0) {
			health=health-damagePoints;
		}
		else
			health=0;
	}
	public void setWeapon(Weapon w) {
		this.weapon=w;
	}
	public Weapon getWeapon() {
		return this.weapon;
	}
	public void setSpell(Spell s) {
		this.spell=s;
	}
	public Spell getSpell() {
		return this.spell;
	}
	
	public int attack() {
		if(this.getWeapon()!=null && this.getSpell()!=null) {
			
		if(this.getWeapon().getDamage()<this.getSpell().getDamage()&&this.mana>=this.getSpell().getManaCost()) {
			int magicPoints=this.getSpell().getDamage();
			this.mana -= spell.getManaCost();
			return  magicPoints;
		}
		else {
			return this.getWeapon().getDamage();
		}
		}
		
		return 0;
	}
}
