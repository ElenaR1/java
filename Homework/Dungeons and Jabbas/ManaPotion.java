package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class ManaPotion implements Treasure{
	private int manaPoints;

	
	public ManaPotion(int mp) {
		setManaPoints(mp);
	}
	@Override
	public String collect(Hero h) {
		// TODO Auto-generated method stub
		h.takeMana(manaPoints);
		int a=getManaPoints();
		String b=Integer.toString(a);
		String c="Mana potion found! ";
		String d=" mana points added to your hero!";
		return c+b+d;
		
	}
	public int heal() {
		return manaPoints;
	}
	public void setManaPoints(int mp) {
		this.manaPoints=mp;
	}
	
	public int getManaPoints() {
		return this.manaPoints;
		}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
