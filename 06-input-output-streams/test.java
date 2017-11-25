package bg.uni.sofia.fmi.mjt.streams;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//File file = new File("a.txt");
		//StringReplacer obj=new StringReplacer("a.txt");
		//Map.of("name", "Ники", "date", "15-17 декември 2017")
		Map<String,String> mm=new HashMap<String,String>();
		String key1="name";
		String key2="date";
		String val1="Val";
		String val2="12.03.2005";
		mm.put(key1, val1);
		mm.put(key2, val2);
		
		String text="Dear {name}, lalall {CODES}. Come here on {date}";
		StringReplacer test=new StringReplacer(text);
		String check=test.replace(mm);
		//System.out.println(check);
		
		
		String text2="Dear  { name}, lalall {CODES}. Come here on {date}";
		StringReplacer test2=new StringReplacer(text2);
		String check2=test2.replace(mm);
		System.out.println(check2);
		
		//FilePlaceholderReplacer a=new FilePlaceholderReplacer();
		//a.replace("gen.txt", "invv.txt", mm);
		
	}

}
