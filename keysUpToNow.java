import java.util.Arrays;
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
		/*for (Object e : a) {
		    System.out.println(((Map.Entry<String, Integer>) e).getKey() + " : "
		            + ((Map.Entry<String, Integer>) e).getValue());
		}*/
		int count=0;
		for (int i = 0; i < a.length; i++) {
			if(count==3) {
				break;
			}
			if(((Entry<String, Integer>) a[i]).getValue()==((Entry<String, Integer>) a[i+1]).getValue()) {
				//System.out.print(i+" ! ");
				
				v.add(((Entry<String, Integer>) a[i]).getKey());
			}
			if(i>0 &&((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i+1]).getValue() &&
					((Entry<String, Integer>) a[i]).getValue()==((Entry<String, Integer>) a[i-1]).getValue()) {
				//System.out.print(i+" # ");
				//System.out.println( ((Entry<String, Integer>) a[i]).getValue());	
				v.add(((Entry<String, Integer>) a[i]).getKey());
				String s="";
				for (int j = 0; j < v.size(); j++) {
					if(j!=v.size()-1)
					s+=v.get(j)+", ";
					else {
						s+=v.get(j)+": "+((Entry<String, Integer>) a[i]).getValue();
					}
				}
				System.out.println(s);
				count++;
			}
			if(i>0 &&((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i+1]).getValue() &&
					((Entry<String, Integer>) a[i]).getValue()!=((Entry<String, Integer>) a[i-1]).getValue()) {
				//System.out.print(i+" ? ");
				System.out.println(((Entry<String, Integer>) a[i]).getKey() + " : "
			            + ((Entry<String, Integer>) a[i]).getValue());	
				count++;
				
			}
			else if (i==0) {
				//System.out.print(i+" % ");
				System.out.println(((Entry<String, Integer>) a[i]).getKey() + " : "
			            + ((Entry<String, Integer>) a[i]).getValue());	
				count++;
			}
		}
		
		/* if(((Entry<String, Integer>) a[0]).getValue()!=((Entry<String, Integer>) a[1]).getValue() &&
				 ((Entry<String, Integer>) a[0]).getValue()!=((Entry<String, Integer>) a[2]).getValue() &&
				 ((Entry<String, Integer>) a[1]).getValue()!=((Entry<String, Integer>) a[2]).getValue())
		 {
				for (int i=0;i<3;i++) {	
				    System.out.println(((Entry<String, Integer>) a[i]).getKey() + " : "
				            + ((Entry<String, Integer>) a[i]).getValue());		
				}
		 }
		 else {
			    if(((Entry<String, Integer>) a[0]).getValue()==((Entry<String, Integer>) a[1]).getValue()) {
			    	System.out.println(((Entry<String, Integer>) a[0]).getKey() + " : "
				            + ((Entry<String, Integer>) a[0]).getValue()+", "+
				            ((Entry<String, Integer>) a[1]).getKey() + " : "
				            + ((Entry<String, Integer>) a[1]).getValue());	
			    	System.out.println(((Entry<String, Integer>) a[2]).getKey() + " : "
				            + ((Entry<String, Integer>) a[2]).getValue());
			    }
			    else if(((Entry<String, Integer>) a[0]).getValue()==((Entry<String, Integer>) a[2]).getValue()) {
			    	System.out.println(((Entry<String, Integer>) a[0]).getKey() + " : "
				            + ((Entry<String, Integer>) a[0]).getValue()+", "+
				            ((Entry<String, Integer>) a[2]).getKey() + " : "
				            + ((Entry<String, Integer>) a[2]).getValue());	
			    	System.out.println(((Entry<String, Integer>) a[1]).getKey() + " : "
				            + ((Entry<String, Integer>) a[1]).getValue());
			    }
			    else if(((Entry<String, Integer>) a[1]).getValue()==((Entry<String, Integer>) a[2]).getValue()) {
			    	System.out.println(((Entry<String, Integer>) a[1]).getKey() + " : "
				            + ((Entry<String, Integer>) a[1]).getValue()+", "+
				            ((Entry<String, Integer>) a[2]).getKey() + " : "
				            + ((Entry<String, Integer>) a[2]).getValue());	
			    	System.out.println(((Entry<String, Integer>) a[0]).getKey() + " : "
				            + ((Entry<String, Integer>) a[0]).getValue());
			    }
		 } */
		
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
       obj.addValues("a", 9);
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
        obj.print();
       
       /*
        System.out.println(map);
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
        	String key=s.next();
        	if(key.equals("exit")) {
        		break;
        	}
        	int value=s.nextInt();
        	map.put(key, value);
        }
        
        System.out.println(map);
		*/
        
        
	}

}

