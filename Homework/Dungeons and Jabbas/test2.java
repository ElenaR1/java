package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.GameEngine;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Position p1=new Position(0,0);
		Position p2=new Position(1,0);
		Hero h1=new Hero("Stan",10,5,p1);
		Weapon w1= new Weapon("pistol",15);
		Weapon w2= new Weapon("rifle",20);
		Weapon w3= new Weapon("axe",30);
		
		Spell s1=new Spell("invisibility",5,10);//damage=5
		Spell s2=new Spell("strength",10,10);
		h1.equip(w1);
		h1.learn(s1);
		
		Enemy e1=new Enemy("Witch",10,5,w1,s1);
		Enemy e2=new Enemy("Vampire",20,10,w3,s1);
		
		Treasure[] treasures= {w2,s2};
		Enemy[] enemies= {e1,e2};
		
		
		/*char[][] map =
			   {{ 'S', '.', '#', '#', '.', '.', '.', '.', '.', 'T' },
                { '#', 'T', '#', '#', '.', '.', '#', '#', '#', '.' },
                { '#', '.', '#', '#', '#', 'E', '#', '#', '#', 'E' },
                { '#', '.', 'E', '.', '.', '.', '#', '#', '#', '.' },
                { '#', '#', '#', 'T', '#', '#', '#', '#', '#', 'G' }};
		
		GameEngine ge=new GameEngine(map, h1, enemies, treasures);
		ge.makeMove(2);
		ge.CurrentPos();
		ge.printMap();
		*/
		char map[][]=new char[4][4];
		map[0][0]='S';
		map[0][1]=' ';
		map[0][2]='T';
		map[0][3]='#';
		
		map[1][0]='#';
		map[1][1]='T';
		map[1][2]='E';
		map[1][3]='#';
		
		map[2][0]='#';
		map[2][1]=' ';
		map[2][2]='#';
		map[2][3]='#';
		
		map[3][0]='#';
		map[3][1]='E';
		map[3][2]=' ';
		map[3][3]='G';
		System.out.println(map.length);
		for(int i = 0; i<4; i++)
		{
		    for(int j = 0; j<4; j++)
		    {
		        System.out.print(map[i][j]);
		        System.out.print(" ");
		    }
		    System.out.println();
		}
		
		GameEngine ge=new GameEngine(map, h1, enemies, treasures);
		ge.makeMove(2);
		ge.CurrentPos();
		ge.printMap();
		
		
		ge.makeMove(2);
		ge.CurrentPos();
		ge.printMap();
		
		System.out.println(h1.getWeapon().getName());
		System.out.println(h1.getSpell().getName());
		ge.makeMove(3);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(0);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(3);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(3);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(2);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(2);
		ge.CurrentPos();
		ge.printMap();
		
		
		/*char map[][]=new char[4][4];
		map[0][0]='S';
		map[0][1]=' ';
		map[0][2]='T';
		map[0][3]=' ';
		
		map[1][0]='#';
		map[1][1]='T';
		map[1][2]='E';
		map[1][3]='#';
		
		map[2][0]='#';
		map[2][1]=' ';
		map[2][2]='#';
		map[2][3]='#';
		
		map[3][0]='#';
		map[3][1]='E';
		map[3][2]=' ';
		map[3][3]='G';
		GameEngine ge=new GameEngine(map, h1, enemies, treasures);
		
		ge.printMap();
		ge.makeMove(2);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(3);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(2);
		ge.CurrentPos();
		ge.printMap();
		
		ge.makeMove(1);
		ge.CurrentPos();
		ge.printMap();
		*/
		
	}

}
