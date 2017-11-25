package bg.uni.sofia.fmi.mjt.streams;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class StringReplacerTest {

	@Test
	public void constructorTest() {
		StringReplacer obj = new StringReplacer("Dear {name}, lalall {CODES}. Come here on {date}");
		assertEquals("Dear {name}, lalall {CODES}. Come here on {date}", obj.getInput());
	}
	
	@Test
	public void test()throws IOException {
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
		assertEquals("Dear Val, lalall {CODES}. Come here on 12.03.2005",check);
		
		String text2="Dear  { name}, lalall {CODES}. Come here on {date}";
		StringReplacer test2=new StringReplacer(text2);
		String check2=test2.replace(mm);
		assertEquals("Dear  { name}, lalall {CODES}. Come here on 12.03.2005",check2);
	}

}
