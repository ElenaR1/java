package bg.uni.sofia.fmi.mjt.streams;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FilePlaceholderReplacerTest {

	@Test
	public void replaceTest() throws IOException  {
		Map<String,String> mm=new HashMap<String,String>();
		String key1="name";
		String key2="date";
		String val1="Val";
		String val2="12.03.2005";
		mm.put(key1, val1);
		mm.put(key2, val2);
		
	
		FilePlaceholderReplacer a=new FilePlaceholderReplacer();
		a.replace("gen.txt", "invv.txt", mm);
	}

}
