package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.GameEngine;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
	Position p1=new Position(1,1);
	Position p2=new Position(1,0);
	Hero h1=new Hero("Stan",6,5,p1);
	
	System.out.println(h1.getHealth());
	h1.takeDamage(2);
	System.out.println(h1.getHealth());
	//h1.takeHealing(7);
	//System.out.println(h1.getHealth());//4
	h1.takeHealing(1);
	System.out.println(h1.getHealth());
	
	Weapon w1= new Weapon("pistol",15);
	Weapon w2= new Weapon("rifle",20);
	Weapon w3= new Weapon("knife",10);
	Weapon w4= new Weapon("ball",5);
	
	
	Spell s1=new Spell("invisibility",5,10);//damage=5
	Spell s2=new Spell("strength",10,10);
	
	
	h1.equip(w1);
	System.out.println(h1.getWeapon().getName());
	h1.equip(w2);
	System.out.println(h1.getWeapon().getName());
	//h1.equip(w3);
	System.out.println(w3.collect(h1));	
	System.out.println(h1.getWeapon().getName());
	
	Hero h2=new Hero("Dave",10,15,p2);//mana=15
	h2.learn(s2);
	System.out.println(h2.getSpell().getName());
	System.out.println(s2.collect(h2));
	System.out.println(h2.getSpell().getName());
	h2.equip(w4);

	System.out.print("The attack of h2 is: ");
	System.out.print(h2.attack());
	System.out.print(" After the attack the mana of h2 is: ");
	System.out.println(h2.getMana());
	
	Enemy e1=new Enemy("Witch",10,5,w1,s2);
	Enemy e2=new Enemy("Vampire",20,10,w1,s2);
	System.out.print("The attack of the witch is: ");
	System.out.println(e1.attack());
	
	
	}
}
