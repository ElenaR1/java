package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public interface Treasure {
	
	//void setName(String name);
	//
	String getName();
	//void setDamage(int damage);
	//int getDamage();
	String collect(Hero h);
	



}
