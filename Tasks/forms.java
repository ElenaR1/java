
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
	public boolean isEmpty(char[][] mat,int n,int m) {
		//print(mat);
		for (int i = 0; i <mat.length; i++) {
			for (int j = 0; j <mat[i].length; j++) {
				if(mat[i][j]!='.' && mat[i][j]!='*') {
					System.out.println("i: "+i+" j: "+j+" "+mat[i][j]);
					return false;
				}
			}
		}
		return true;
	}
	public int[] findEl(char el,char[][] mat) {
		int a[]=new int[2];
		for (int i = 0; i <mat.length; i++) {
			for (int j = 0; j <mat[i].length; j++) {
				if(mat[i][j]==el) {
					a[0]=i;
					a[1]=j;
					break;
				}
			}
		}
		return a;
		}
	public void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
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

	
	public void check(int n, int m, char center, String configs[]) {
		boolean valid = true;
		int count=0;
		int indexes[]=new int[2];
		for (int i = 0; i < n; i++) {
			if (i == 0 && above(configs)) {
				continue;
			} else {
				for (int j = 0; j < m; j++) {
					if ((j == 0 && left(configs)) || (j == m - 1 && right(configs))) {
						continue;
					}

					for (int j2 = 0; j2 < configs.length; j2++) {
						System.out.println(j2);						
						if(isEmpty(matrixToChange,n,m)) {
							matrixToChange[i][j] = center;	
							count=0;
						}
						indexes=findEl(configs[j2].charAt(2), matrixToChange);
						if (isAbove(configs[j2]) && isFree(matrixToChange[i - 1][j])) {
							System.out.println("i: " + i + " j: " + j + " j2: " + j2 + ": " + configs[j2]);
							matrixToChange[i - 1][j] = configs[j2].charAt(0);
							count++;
							System.out.println("-----------new one :");
							print(matrixToChange);
							// restoreMatrix(matrixToChange,n,m);
							// System.out.println("-----------restored:");
							// print(matrixToChange);
						}
						if (isRight(configs[j2]) && isFree(matrixToChange[i][j + 1]) ) {
							System.out.println("i: " + i + " j: " + j + " j2: " + j2 + ": " + configs[j2]);
							matrixToChange[i][j + 1] = configs[j2].charAt(0);
							count++;
							System.out.println("-----------new one :");
							print(matrixToChange);
						}
						if(j2==configs.length-1) {
							if(count==configs.length) {
							System.out.println("-----------new one :");
							print(matrixToChange);
							}
							restoreMatrix(matrixToChange,n,m);
							System.out.println("-----------restored:");
							 print(matrixToChange);
						}
					}

				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		char[][] a = new char[n][n];
		char[][] arr = { { '.', '.', '*', '.', '.', '.', '*', '.', '*', '*' },
				{ '.', '.', '.', '.', '.', '*', '*', '.', '.', '.' },
				{ '*', '.', '*', '.', '.', '.', '*', '.', '.', '*' },
				{ '.', '*', '*', '.', '.', '.', '.', '*', '.', '*' },
				{ '.', '.', '.', '*', '.', '.', '*', '.', '*', '.' },
				{ '.', '*', '*', '*', '.', '.', '.', '*', '.', '.' },
				{ '*', '.', '.', '.', '.', '.', '.', '*', '.', '*' },
				{ '.', '.', '.', '.', '.', '*', '*', '.', '.', '*' },
				{ '.', '.', '*', '.', '*', '.', '*', '.', '.', '*' },
				{ '*', '*', '*', '.', '*', '.', '*', '*', '.', '.' } };

		int numConfigs = 6;
		// String configs[] = { "BAA", "FRA", "CAB", "DRC", "EAD", "GLE" };
		String configs2[] = { "BAA", "FRA","CRF" };
		int len = numConfigs + 1;
		Forms obj = new Forms(arr, 10, 10);
		// obj.print(arr);
		// obj.print(configs);
		obj.check(10, 10, 'A', configs2);
		// Filling the matrix
		/*
		 * for ( row = 0; row < 4; row ++ ) for ( column = 0; column < 5; column + + ) {
		 * scores [ row ] [ column ] = Console.readInt ("Enter score " + column +
		 * "for contestant " + row ); }
		 */

	}
}
