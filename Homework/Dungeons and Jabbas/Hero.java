package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Hero implements Actor {
	private String name;
	private int health;
	private int healthInTheBeginning;
	private int mana;
	private int manaInTheBeginning;
	private Position position;
	private boolean hasWeapon;
	private Weapon weapon;
	private boolean knowsSpell;
	private Spell spell;
	
	public Hero(String n, int h, int m,Position pos) {
		//hasWeapon=false;
		setName(n);
		setHealth(h);
		setMana(m);
		setPostition(pos);
		healthInTheBeginning=health;
		}
	
	public void setPostition(Position pos) {
		this.position=pos;
	}
	
	public void changePosition(Position pos) {
		this.position=pos;
	}
	public void setName(String n) {
		this.name=n;
	}
	
	@Override
	public String getName() {
		return this.name;
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
	
	public Position getPosition() {
		return this.position;
	}
	
	public void takeHealing(int healingPoints) {
		if(this.isAlive()) {
		/*do {
			health+=1;
			healingPoints--;
		}while(healingPoints==0 || health==healthInTheBeginning);*/
			if(health+healingPoints<=healthInTheBeginning) {
				health=health+healingPoints;
			}
			else
				health=healthInTheBeginning;
		}
	}
	
	public void takeDamage(int damagePoints) {
		if(health-damagePoints>=0) {
			health=health-damagePoints;
		}
		else
			health=0;
	}
	
	public void takeMana(int manaPoints) {
		if(this.isAlive()) {
			if(mana+manaPoints<=manaInTheBeginning) {
				mana=mana+manaPoints;
			}
			else
				mana=manaInTheBeginning;
		}
	}
	
	public void equip(Weapon we) {
		if(this.hasWeapon==false) {
			hasWeapon=true;
			this.weapon=we;
		}
		else
			if(this.weapon.getDamage()<we.getDamage())
			{
				this.weapon=we;
			}
	}
	public Weapon getWeapon() {
		return this.weapon;
		
	}
	
	public void learn(Spell s) {
		if(this.knowsSpell==false) {
			knowsSpell=true;
			this.spell=s;
		}
		else
			if(this.spell.getDamage()<s.getDamage())
			{
				this.spell=s;
			}
	}
	public Spell getSpell() {
		return this.spell;
	}
	public int damageOfWeapon() {
		if(this.hasWeapon==true)
		return weapon.getDamage();
		else
		return 0;
	}
	public int attack() {
		
		if(this.hasWeapon==true && this.knowsSpell==true) {
		if(getWeapon().getDamage()<getSpell().getDamage()&&this.mana>=getSpell().getManaCost()) {
			int magicPoints=this.getSpell().getDamage();
			this.mana -= spell.getManaCost();
			return  magicPoints;
		}
		else {
			return this.getWeapon().getDamage();
		}
		}
		else if(this.hasWeapon) {
	        return this.getWeapon().getDamage();
	    } else if(this.knowsSpell && this.mana >= getSpell().getManaCost()) {
	        int magicPoints=this.getSpell().getDamage();
	        this.mana -= spell.getManaCost();
	        return magicPoints;
	    }
	    return 0;
	}
}
