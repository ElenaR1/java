import java.io.Console;
import java.util.Scanner;
import java.util.Vector;

public class Forms {
	private char[][] matrix;
	private char[][] matrixToChange;

	public Forms(char[][] mat, int n, int m) {
		matrix = new char[n][m];
		matrixToChange = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = mat[i][j];
				matrixToChange[i][j] = mat[i][j];
			}
		}
	}

	public void restoreMatrix(char[][] newMat, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMat[i][j] = matrix[i][j];
			}
		}
	}

	public boolean isEmpty(char[][] mat, int n, int m) {
		// print(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] != '.' && mat[i][j] != '*') {
					// System.out.println("i: " + i + " j: " + j + " " + mat[i][j]);
					return false;
				}
			}
		}
		return true;
	}

	public int[] findEl(char el, char[][] mat) {
		int a[] = new int[2];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == el) {
					a[0] = i;
					a[1] = j;
					break;
				}
			}
		}
		return a;
	}

	public void print(char[][] matrix) {
		System.out.print("  ");
		for (int i = 0; i <matrix[0].length; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(i+" ");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void print(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public boolean isFree(char a) {
		if (a != '.')
			return false;
		else
			return true;
	}

	public boolean above(String configs[]) {
		for (int i = 0; i < configs.length; i++) {
			if (configs[i].charAt(1) == 'A')
				return true;
		}
		return false;
	}

	public boolean left(String configs[]) {
		for (int i = 0; i < configs.length; i++) {
			if (configs[i].charAt(1) == 'L')
				return true;
		}
		return false;
	}

	public boolean right(String configs[]) {
		for (int i = 0; i < configs.length; i++) {
			if (configs[i].charAt(1) == 'R')
				return true;
		}
		return false;
	}

	public boolean isAbove(String s) {
		if (s.charAt(1) == 'A')
			return true;
		else
			return false;
	}

	public boolean isRight(String s) {
		if (s.charAt(1) == 'R')
			return true;
		else
			return false;
	}

	public boolean isLeft(String s) {
		if (s.charAt(1) == 'L')
			return true;
		else
			return false;
	}

	public void check(int n, int m, char center, String configs[],int numOfConfigs) {
		boolean valid = true;
		int count = 0;
		int countOfConfs=0;
		int indexes[] = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEmpty(matrixToChange, n, m)) {
					if (isFree(matrixToChange[i][j])) {
						matrixToChange[i][j] = center;
						count = 0;
					} else
						continue;
				}
				for (int j2 = 0; j2 < numOfConfigs; j2++) {

					indexes = findEl(configs[j2].charAt(2), matrixToChange);// in "DRC" we find the 'C' el - where is
																			// its position in the matrix
					if (isAbove(configs[j2])) {
						int row = indexes[0];
						int col = indexes[1];
						if (row != 0 && isFree(matrixToChange[row - 1][col])) {
							matrixToChange[row - 1][col] = configs[j2].charAt(0);
							count++;
						}
					}
					if (isRight(configs[j2])) {

						int row = indexes[0];
						int col = indexes[1];
						if (col != m - 1 && isFree(matrixToChange[row][col + 1])) {
							matrixToChange[row][col + 1] = configs[j2].charAt(0);
							count++;

						}
					}
					if (isLeft(configs[j2])) {

						int row = indexes[0];
						int col = indexes[1];
						if (col != 0 && isFree(matrixToChange[row][col - 1])) {
							matrixToChange[row][col - 1] = configs[j2].charAt(0);
							count++;

						}
					}
					if (j2 == numOfConfigs - 1) {

						if (count == numOfConfigs) {
							countOfConfs++;
							print(matrixToChange);
							System.out.println("-----------");
						}
						restoreMatrix(matrixToChange, n, m);

					}
				}

			}
		}
		System.out.println(countOfConfs);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in); 
		System.out.println("Num of rows and columns:" ); 
		int numRow = sc.nextInt(); 
		int numCol = sc.nextInt(); 	
		
		System.out.println("Enter Matrix Data");
		char[][] mat=new char[numRow][numCol];
		// Filling the matrix
		Vector<String> v=new Vector<String>();
		for (int row = 0; row <numRow; row ++ )
			   {
				  v.add(sc.next());
			  }
		for (int row = 0; row <numRow; row ++ )
			  for (int column = 0; column < numCol; column++ ) {				 
					  mat [ row ] [ column ] = v.get(row).charAt(column);				
		  }
		
		  System.out.println("Num of forms:" ); 
		  int num = sc.nextInt(); 
		  
		  System.out.println("Center:" ); 
		  char center = sc.next().charAt(0);
		  
		  String configs4[] = new String[num];
		  System.out.println("Configurations:" ); 
		  for (int i = 0; i < num; i++) {
			configs4[i]=sc.next();
		}
		  Forms obj4 = new Forms(mat, numRow, numCol);
		  obj4.check(numRow, numCol, center, configs4,num);
	}
}
