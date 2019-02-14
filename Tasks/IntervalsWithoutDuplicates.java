import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class Intervals {
	Vector<Integer> v = new Vector<>();

	//finds the intervals with consecutive numbers. In the for-cycle it checks all poosible cases for each element of the array
	public void checkCons(int[] a) {
		Arrays.sort(a);

		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1 && a[i] + 1 == a[i + 1]) {
				count++;
				v.addElement(a[i]);
			}
			if (i > 0 && i != a.length - 1 && a[i] + 1 != a[i + 1] && a[i] == a[i - 1] + 1) {
				count++;
				v.addElement(a[i]);
				String s = "[" + v.get(0) + ", " + v.get(v.size() - 1) + "]" + " with consecutive count of " + count;
				count = 0;
				v.clear();
				System.out.println(s);
			}
			if (i > 0 && i != a.length - 1 && a[i] + 1 != a[i + 1] && a[i] != a[i - 1] + 1) {
				System.out.println("[" + a[i] + ", " + a[i] + "] with consecutive count of 1");
			}
			if (i == 0 && a[i] + 1 != a[i + 1]) {
				System.out.println("[" + a[i] + ", " + a[i] + "] with consecutive count of 1");
			}
			if (i == a.length - 1 && a[i] != a[i - 1] + 1) {
				System.out.println("[" + a[i] + ", " + a[i] + "] with consecutive count of 1");
			}
			if (i == a.length - 1 && a[i] == a[i - 1] + 1) {
				count++;
				v.addElement(a[i]);
				String s = "[" + v.get(0) + ", " + v.get(v.size() - 1) + "]" + " with consecutive count of " + count;
				count = 0;
				v.clear();
				System.out.println(s);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> vec = new Vector<>();
		Intervals obj = new Intervals();
		System.out.println("Ener a different number on each line and write exit when you want to quit");
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			if (s.hasNextInt()) {
				int value = s.nextInt();
				vec.add(value);
			} else
				break;
		}

		int[] arr = new int[vec.size()];

		for (int i = 0; i < vec.size(); i++) {
			arr[i] = vec.get(i);
		}

		obj.checkCons(arr);

	}

}
