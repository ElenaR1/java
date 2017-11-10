package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class HealthPotion implements Treasure {
	private int healingPoints;
	
	public  HealthPotion(int hp) {
		// TODO Auto-generated constructor stub
		setHealingPoints(hp);
	}
	
	void setHealingPoints(int h) {
		healingPoints=h;
	}
	int getHealingPoints()
	{
		return healingPoints;
	}
	
	public int heal() {
		return healingPoints;
	}
	
	@Override
	public String collect(Hero h) {
		// TODO Auto-generated method stub
		h.takeHealing(healingPoints);
		int a=getHealingPoints();
		String b=Integer.toString(a);
		String c="Health potion found! ";
		String d=" health points added to your hero!";
		return c+b+d;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


}
