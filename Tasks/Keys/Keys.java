import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class Keys {
	HashMap<String, Integer> map = new HashMap<>();
	Vector<String> v = new Vector<>();

	//if the key already exists the new value is added to the existing one
	void addValues(String key, int value) {
		if (map.containsKey(key)) {
			int oldValue = map.get(key);// it gets the value for 'key'
			int newValue = value + oldValue;
			map.put(key, newValue);
		} else//otherwise it just adds a new elem in  map
		{
			map.put(key, value);
		}
	}

	public void print() {
		Arrays.toString(map.entrySet().toArray());
		System.out.println(map);
	}
	
	public void print(Object a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	//sortMap sorts the map by values and prints the top3 keys with their summed values
	public void sortMap() {
		Object[] a = map.entrySet().toArray();//map.entrySet()  returns a set having same elements as map.

		print(a);
		
		Arrays.sort(a, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Map.Entry<String, Integer>) o2).getValue()
						.compareTo(((Map.Entry<String, Integer>) o1).getValue());
			}
		});
		print(a);
		int count = 0;
		//we find the keys with the same summed up value by checking the next and the previous element
		for (int i = 0; i < a.length; i++) {
			if (count == 3) {
				break;
			}
			if (i != a.length - 1
					&& ((Entry<String, Integer>) a[i]).getValue() == ((Entry<String, Integer>) a[i + 1]).getValue()) {
				v.add(((Entry<String, Integer>) a[i]).getKey());
			}
			if (i > 0 && i != a.length - 1
					&& ((Entry<String, Integer>) a[i]).getValue() != ((Entry<String, Integer>) a[i + 1]).getValue()
					&& ((Entry<String, Integer>) a[i]).getValue() == ((Entry<String, Integer>) a[i - 1]).getValue()) {

				v.add(((Entry<String, Integer>) a[i]).getKey());
				// If there are keys with equal summed values they should be ordered
				// alphabetically
				Collections.sort(v);
				String s = "";
				for (int j = 0; j < v.size(); j++) {
					if (j != v.size() - 1)
						s += v.get(j) + ", ";
					else {
						s += v.get(j) + ": " + ((Entry<String, Integer>) a[i]).getValue();
					}
				}
				v.clear();
				System.out.println(s);
				count++;
			}
			if (i > 0 && i != a.length - 1
					&& ((Entry<String, Integer>) a[i]).getValue() != ((Entry<String, Integer>) a[i + 1]).getValue()
					&& ((Entry<String, Integer>) a[i]).getValue() != ((Entry<String, Integer>) a[i - 1]).getValue()) {
				System.out.println(
						((Entry<String, Integer>) a[i]).getKey() + " : " + ((Entry<String, Integer>) a[i]).getValue());
				count++;

			}
			if (i == 0
					&& ((Entry<String, Integer>) a[i]).getValue() != ((Entry<String, Integer>) a[i + 1]).getValue()) {
				System.out.println(
						((Entry<String, Integer>) a[i]).getKey() + " : " + ((Entry<String, Integer>) a[i]).getValue());
				count++;
			}
			if (i == a.length - 1
					&& ((Entry<String, Integer>) a[i]).getValue() != ((Entry<String, Integer>) a[i - 1]).getValue()) {
				System.out.println(
						((Entry<String, Integer>) a[i]).getKey() + " : " + ((Entry<String, Integer>) a[i]).getValue());
				count++;
			}
			if (i == a.length - 1
					&& ((Entry<String, Integer>) a[i]).getValue() == ((Entry<String, Integer>) a[i - 1]).getValue()) {
				v.add(((Entry<String, Integer>) a[i]).getKey());
				// If there are keys with equal summed values they should be ordered
				// alphabetically
				Collections.sort(v);
				String s = "";
				for (int j = 0; j < v.size(); j++) {
					if (j != v.size() - 1)
						s += v.get(j) + ", ";
					else {
						s += v.get(j) + ": " + ((Entry<String, Integer>) a[i]).getValue();
					}
				}
				v.clear();
				System.out.println(s);
				count++;
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Keys obj = new Keys();
		obj.addValues("b", 9);
	       obj.addValues("abc", 9);
	        obj.addValues("f", 1);
	        obj.addValues("g", 2); 
	        obj.addValues("f", 3); 
	        obj.addValues("h", 10); 
	        obj.addValues("c", 12); 
	        obj.addValues("f", 5); 
	        obj.addValues("h", 2);           
	        obj.addValues("z", 7);            
	        obj.sortMap();
		
		System.out.println("If you want to stop entering numbers and strings write exit");
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String key = s.next();
			if (key.equals("exit")) {
				break;
			}
			int value = s.nextInt();
			obj.addValues(key, value);
		}

		obj.sortMap();

	}

}
