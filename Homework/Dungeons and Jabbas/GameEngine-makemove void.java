package bg.uni.sofia.fmi.mjt.dungeon;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Enemy;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Position;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;

public class GameEngine {
	private int N=100;
	private char[][]map;
	private Hero hero;
	private Enemy[] enemies=new Enemy[N];
	private Treasure[] treasures=new Treasure[N];
	private int currentTreasure;
	private int currentEnemy;
	
	
	
	public GameEngine( char[][] m,Hero h,Enemy[] es, Treasure[] tr) {
		this.map=m;
		this.hero=h;
		this.enemies=es;
		this.treasures=tr;
	}
	
	public boolean isFree(int i, int j) {
		char ch=map[i][j];
		if(ch == ' ')
			return true;
		else
			return false;
	}
	public boolean isValid(int i,int j) {
	int n=map.length;
	if(i<n && i>=0 && j<n && j>=0)
		return true;
	else
		return false;
	}
	public void makeMove(int command) {
		int i=this.hero.getPosition().getX();
		int j=this.hero.getPosition().getY();
		if(command==2) {
			
			if(isFree(i,j+1) && isValid(i,j+1)) {
				Position newPos=new Position(i, j+1);
				hero.changePosition(newPos);
				System.out.println("You moved successfully to the next position.");
				map[i][j+1]='!';
				map[i][j]='.';
			}
			if(isValid(i, j+1) && map[i][j+1]=='#') {
				System.out.println("Wrong move. There is an obstacle and you cannot bypass it.");
			}
			if(isValid(i, j+1) && map[i][j+1]=='T') {
				Position newPos=new Position(i, j+1);
				this.getTreasure();
				hero.changePosition(newPos);
				map[i][j+1]='!';
				map[i][j]='.';
			}
			if(isValid(i, j+1) && map[i][j+1]=='E') {
				while(hero.isAlive() && enemies[currentEnemy].isAlive()) {
					int attackOfHero=hero.attack();
					 enemies[currentEnemy].takeDamage(attackOfHero);
					 int attackOfEnemy= enemies[currentEnemy].attack();
					 if(enemies[currentEnemy].isAlive())
					 hero.takeDamage(attackOfEnemy);
				}
				if(hero.isAlive()) {
					Position newPos=new Position(i, j+1);
					hero.changePosition(newPos);
					map[i][j+1]='!';
					map[i][j]='.';
					System.out.println("Enemy died.");
				}
				else {
					System.out.println( "Hero is dead! Game over!");
				}
				currentEnemy+=1;
			}
			if(isValid(i, j+1) && map[i][j+1]=='G') {
				System.out.println("You have successfully passed through the dungeon. Congrats!");
			}
			
		}
		if(command==0) {
			
			if(isFree(i,j-1) && isValid(i,j-1)) {
				Position newPos=new Position(i, j-1);
				hero.changePosition(newPos);
				System.out.println("You moved successfully to the next position.");
				map[i][j-1]='!';
				map[i][j]='.';
			}
			if(isValid(i, j-1) && map[i][j-1]=='#') {
				System.out.println("Wrong move. There is an obstacle and you cannot bypass it.");
			}
			if(isValid(i, j-1) && map[i][j-1]=='T') {
				Position newPos=new Position(i, j-1);
				this.getTreasure();
				hero.changePosition(newPos);
				map[i][j-1]='!';
				map[i][j]='.';
			}
			if(isValid(i, j-1) && map[i][j-1]=='E') {
				while(hero.isAlive() && enemies[currentEnemy].isAlive()) {
					int attackOfHero=hero.attack();
					 enemies[currentEnemy].takeDamage(attackOfHero);
					 int attackOfEnemy= enemies[currentEnemy].attack();
					 if(enemies[currentEnemy].isAlive())
					 hero.takeDamage(attackOfEnemy);
				}
				if(hero.isAlive()) {
					Position newPos=new Position(i, j-1);
					hero.changePosition(newPos);
					map[i][j-1]='!';
					map[i][j]='.';
					System.out.println("Enemy died.");
				}
				else {
					System.out.println( "Hero is dead! Game over!");
				}
				currentEnemy+=1;
			}
			
		}
		
		if(command==3) {
			
			if( isValid(i+1,j) && isFree(i+1,j)) {
				Position newPos=new Position(i+1, j);
				hero.changePosition(newPos);
				System.out.println("You moved successfully to the next position.");
				map[i+1][j]='!';
				map[i][j]='.';
			}
			if(isValid(i+1, j) && map[i+1][j]=='#') {
				System.out.println("Wrong move. There is an obstacle and you cannot bypass it.");
			}
			if(isValid(i+1, j) && map[i+1][j]=='T') {
				Position newPos=new Position(i+1, j);
				this.getTreasure();
				hero.changePosition(newPos);
				map[i+1][j]='!';
				map[i][j]='.';
			}
			if(isValid(i+1, j) && map[i+1][j]=='E') {
				while(hero.isAlive() && enemies[currentEnemy].isAlive()) {
					 int attackOfHero=hero.attack();
					 enemies[currentEnemy].takeDamage(attackOfHero);
					 int attackOfEnemy= enemies[currentEnemy].attack();
					 if(enemies[currentEnemy].isAlive())
					 hero.takeDamage(attackOfEnemy);
				}
				if(hero.isAlive()) {
					Position newPos=new Position(i+1, j);
					hero.changePosition(newPos);
					map[i+1][j]='!';
					map[i][j]='.';
					System.out.println("Enemy died.");
				}
				else {
					System.out.println( "Hero is dead! Game over!");
				}
				currentEnemy+=1;
			}
			
		}
		
		if(command==1) {
			
			if(isFree(i-1,j) && isValid(i-1,j)) {
				Position newPos=new Position(i-1, j);
				hero.changePosition(newPos);
				System.out.println("You moved successfully to the next position.");
				map[i-1][j]='!';
				map[i][j]='.';
			}
			if(isValid(i-1, j) && map[i-1][j]=='#') {
				System.out.println("Wrong move. There is an obstacle and you cannot bypass it.");
			}
			if(isValid(i-1,j) && map[i-1][j]=='T') {
				Position newPos=new Position(i-1, j);
				this.getTreasure();
				hero.changePosition(newPos);
				map[i-1][j]='!';
				map[i][j]='.';
			}
			if(isValid(i-1, j) && map[i-1][j]=='E') {
				while(hero.isAlive() && enemies[currentEnemy].isAlive()) {
					int attackOfHero=hero.attack();
					 enemies[currentEnemy].takeDamage(attackOfHero);
					 int attackOfEnemy= enemies[currentEnemy].attack();
					 if(enemies[currentEnemy].isAlive())
					 hero.takeDamage(attackOfEnemy);
				}
				if(hero.isAlive()) {
					Position newPos=new Position(i, j+1);
					hero.changePosition(newPos);
					map[i-1][j]='!';
					map[i][j]='.';
					System.out.println("Enemy died.");
				}
				else {
					System.out.println( "Hero is dead! Game over!");
				}
				currentEnemy+=1;
			}
			
		}
		if(command!=0 || command!=1 || command!=2 || command!=3 ) {
			
		}
		
	}
	
	public void getTreasure() {
		int n=treasures.length;
		System.out.printf("The hero got a %s\n",treasures[currentTreasure].getName());
		treasures[currentTreasure].collect(this.hero);
		currentTreasure+=1;
	}
	
	public char[][] getMap() {
		return this.map;
	}
	public void CurrentPos() {
			System.out.printf("The new position of x: %d, new pos of y: %d\n",hero.getPosition().getX(),
				hero.getPosition().getY());
	}
	
	public void printMap() {
		for(int i = 0; i<4; i++)
		{
		    for(int j = 0; j<4; j++)
		    {
		        System.out.print(map[i][j]);
		        System.out.print(" ");
		    }
		    System.out.println();
		}
	}
	
}

