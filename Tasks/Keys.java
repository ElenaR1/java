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
	private void addValues(String key, int value) {
		   if(map.containsKey(key)) {
			   int oldValue=map.get(key);
			   int newValue=value+oldValue;
			   map.put(key, newValue);
		   }
		   else {
			   map.put(key, value);
		   }
		}
	public void print() {
		Arrays.toString(map.entrySet().toArray());
		System.out.println(map);
	}
	public void sortMap() {
		Object[] a = map.entrySet().toArray();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		Arrays.sort(a, new Comparator() {
		    public int compare(Object o1, Object o2) {
		        return ((Map.Entry<String, Integer>) o2).getValue()
		                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
		    }
		});
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		System.out.println();
		int count=0;
		for (int i = 0; i < a.length; i++) {
			if(count==3) {
				break;
			}
			if(i!=a.length-1 && ((Entry<String, Integer>) a[i]).getValue()==((Entry<String, Integer>) a[i+1]).getValue()) {			
				v.add(((Entry<String, Integer>) a[i]).getKey());
			}
			if(i>0 && i!=a.length-1 && ((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i+1]).getValue() &&
					((Entry<String, Integer>) a[i]).getValue()==((Entry<String, Integer>) a[i-1]).getValue()) {

				v.add(((Entry<String, Integer>) a[i]).getKey());
				Collections.sort(v);
				String s="";
				for (int j = 0; j < v.size(); j++) {
					if(j!=v.size()-1)
					s+=v.get(j)+", ";
					else {
						s+=v.get(j)+": "+((Entry<String, Integer>) a[i]).getValue();
					}
				}
				v.clear();
				System.out.println(s);
				count++;
			}
			if(i>0 && i!=a.length-1 && ((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i+1]).getValue() &&
					((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i-1]).getValue()) {
				System.out.println(((Entry<String, Integer>) a[i]).getKey() + " : "
			            + ((Entry<String, Integer>) a[i]).getValue());	
				count++;
				
			}
		 if (i==0 && ((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i+1]).getValue()) {
				System.out.println(((Entry<String, Integer>) a[i]).getKey() + " : "
			            + ((Entry<String, Integer>) a[i]).getValue());	
				count++;
			}
		 if (i==a.length-1&&((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i-1]).getValue()) {
				System.out.println(((Entry<String, Integer>) a[i]).getKey() + " : "
			            + ((Entry<String, Integer>) a[i]).getValue());	
				count++;
			}
		 if (i==a.length-1&&((Entry<String, Integer>) a[i]).getValue()==((Entry<String, Integer>) a[i-1]).getValue()) {
			 v.add(((Entry<String, Integer>) a[i]).getKey());
				Collections.sort(v);
				String s="";
				for (int j = 0; j < v.size(); j++) {
					if(j!=v.size()-1)
					s+=v.get(j)+", ";
					else {
						s+=v.get(j)+": "+((Entry<String, Integer>) a[i]).getValue();
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
      /*  HashMap<String, Integer> map = new HashMap<>(); 
        Arrays.toString(map.entrySet().toArray());
        System.out.println(map);
        map.put("f", 1); 
        map.put("g", 2); 
        map.put("f", 3); 
        map.put("h", 10); 
        map.put("f", 5); 
        map.put("h", 2); 

        System.out.println("Size of map is: " + map.size()); 
        Arrays.toString(map.entrySet().toArray());
        System.out.println(map);
        */
        Keys obj=new Keys();
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
        obj.print();
        obj.sortMap();
        
        System.out.println("-----------------");
        Keys obj2=new Keys();
        obj2.addValues("b", 1);
        obj2.addValues("a", 1);
        obj2.addValues("c", 1);
                    
        obj2.print();
        obj2.sortMap();
        
        
        System.out.println("-----------------");
        Keys obj3=new Keys();
        obj3.addValues("8239b961379a4f9f854fd19d82b56dc9", 24);
        obj3.addValues("8239b961379a4f9f854fd19d82b56dc9", 39);
        obj3.addValues("8239b961379a4f9f854fd19d82b56dc9", 39);
        obj3.addValues("8239b961379a4f9f854fd19d82b56dc9", 18);
        obj3.addValues("8239b961379a4f9f854fd19d82b56dc9", 25);
        obj3.addValues("533cc20dc02647cb98c9cc534112e092", 66);
        obj3.addValues("533cc20dc02647cb98c9cc534112e092", 12);
        obj3.addValues("abrt", 90);
        obj3.addValues("533aa20dc02647cb98c9cc534112e092", 90);
                    
        obj3.print();
        obj3.sortMap();
        
        
        System.out.println("-----------------");
        Keys obj4=new Keys();
     
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
        	String key=s.next();
        	if(key.equals("exit")) {
        		break;
        	}
        	int value=s.nextInt();
        	obj4.addValues(key, value);
        }
        
        obj4.print();
        obj4.sortMap();
		
        
        
	}

}

