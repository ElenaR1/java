import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class TestKeys {
	 Keys obj=new Keys();
	@Test
	void test() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
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
	        assertEquals(
					"c, h: 12\r\n" + 
					"abc, b, f: 9\r\n" + 
					"z : 7\r\n",
					outContent.toString());
	}
	@Test
	void testGivenExample() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

	        obj.addValues("f", 1);
	        obj.addValues("g", 2); 
	        obj.addValues("f", 3); 
	        obj.addValues("h", 10); 
	        obj.addValues("f", 5); 
	        obj.addValues("h", 2);                     
	        obj.sortMap();
	        assertEquals(
	        		"h : 12\r\n" + 
	        		"f : 9\r\n" + 
	        		"g : 2\r\n",
					outContent.toString());
	}
	@Test
	void testEqualValues() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		obj.addValues("b", 1);
	       obj.addValues("a", 1);
	        obj.addValues("c", 1);
	        obj.sortMap();
	        
	        assertEquals(
					"a, b, c: 1\r\n",
					outContent.toString());
	}
	@Test
	void testAlphabeticalOrder() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		obj.addValues("bd", 9);
        obj.addValues("ab", 7);
        obj.addValues("bd", 2);
        obj.addValues("5685aa90", 7);
        obj.addValues("c", 2);
        obj.addValues("d", 6);
        obj.addValues("ba", 11);
        obj.sortMap();
	        
	        assertEquals(
					"ba, bd: 11\r\n" + 
					"5685aa90, ab: 7\r\n" + 
					"d : 6\r\n",
					outContent.toString());
	}
	@Test
	void testAlphabeticalOrder2() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		 obj.addValues("8239b961379a4f9f854fd19d82b56dc9", 24);
	        obj.addValues("8239b961379a4f9f854fd19d82b56dc9", 39);
	        obj.addValues("8239b961379a4f9f854fd19d82b56dc9", 39);
	        obj.addValues("8239b961379a4f9f854fd19d82b56dc9", 18);
	        obj.addValues("8239b961379a4f9f854fd19d82b56dc9", 25);
	        obj.addValues("533cc20dc02647cb98c9cc534112e092", 66);
	        obj.addValues("533cc20dc02647cb98c9cc534112e092", 12);
	        obj.addValues("abrt", 90);
	        obj.addValues("533aa20dc02647cb98c9cc534112e092", 90);
        obj.sortMap();
	        
	        assertEquals(
					"8239b961379a4f9f854fd19d82b56dc9 : 145\r\n" + 
					"533aa20dc02647cb98c9cc534112e092, abrt: 90\r\n" + 
					"533cc20dc02647cb98c9cc534112e092 : 78\r\n",
					outContent.toString());
	}
}
