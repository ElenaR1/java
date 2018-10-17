import java.util.Scanner;


/******************************************************************************
 *  Compilation:  javac Minesweeper.java
 *  Execution:    java Minesweeper m n p
 *  
 *  Creates an MxN minesweeper game where each cell is a bomb with
 *  probability p. Prints out the m-by-n game and the neighboring bomb
 *  counts.
 *
 *  Sample execution:
 *
 *      % java Minesweeper  5 10 0.3
 *      * . . . . . . . . * 
 *      . . . . . . * . . . 
 *      . . . . . . . . * * 
 *      . . . * * * . . * . 
 *      . . . * . . . . . . 
 *
 *      * 1 0 0 0 1 1 1 1 * 
 *      1 1 0 0 0 1 * 2 3 3 
 *      0 0 1 2 3 3 2 3 * * 
 *      0 0 2 * * * 1 2 * 3 
 *      0 0 2 * 4 2 1 1 1 1 
 *
 *A cell can contain a number or it can be blank. The number indicates how many mines are adjacent to thi
 *s particular cell. We set a mark on a cell by right clicking on it. This way we indicate that we believe, 
 *there is a mine. i po diagonal !
 ******************************************************************************/






public class MineSweeperFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Board obj=new Board();
		int [][] arr=new int[3][3];
		System.out.println(arr.length);
		int a;
		Scanner input=new Scanner(System.in);//we make a new scanner var
        a=input.nextInt();
        System.out.println(a);*/
		Game obj=new Game();
	}

}
