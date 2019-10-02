import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Test {
	Intervals hw = new Intervals();

	@org.junit.jupiter.api.Test
	void test() {
		int[] arr = { 1, 5, -2, 3, 2, 10, 6 };
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		hw.checkCons(arr);
		assertEquals(
				"[-2, -2] with consecutive count of 1\r\n" + "[1, 3] with consecutive count of 3\r\n"
						+ "[5, 6] with consecutive count of 2\r\n" + "[10, 10] with consecutive count of 1\r\n",
				outContent.toString());

	}

	@org.junit.jupiter.api.Test
	void testFirstExample() {
		int[] arr2 = { -181, -414, 441, 889, -547, -313, 622, 679, 782, -640 };
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		hw.checkCons(arr2);
		assertEquals("[-640, -640] with consecutive count of 1\r\n" + "[-547, -547] with consecutive count of 1\r\n"
				+ "[-414, -414] with consecutive count of 1\r\n" + "[-313, -313] with consecutive count of 1\r\n"
				+ "[-181, -181] with consecutive count of 1\r\n" + "[441, 441] with consecutive count of 1\r\n"
				+ "[622, 622] with consecutive count of 1\r\n" + "[679, 679] with consecutive count of 1\r\n"
				+ "[782, 782] with consecutive count of 1\r\n" + "[889, 889] with consecutive count of 1\r\n",
				outContent.toString());
	}

	@org.junit.jupiter.api.Test
	void testSecondExample() {
		int[] arr3 = { 123, 567, 124, 568, -100, -99 };
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		hw.checkCons(arr3);
		assertEquals("[-100, -99] with consecutive count of 2\r\n" + "[123, 124] with consecutive count of 2\r\n"
				+ "[567, 568] with consecutive count of 2\r\n", outContent.toString());
	}
	@org.junit.jupiter.api.Test
	void testLongSequence() {
		int[] arr3 = { -5,-4,-3,-2,-1,0,1,2,3};
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		hw.checkCons(arr3);
		assertEquals("[-5, 3] with consecutive count of 9\r\n", outContent.toString());
	}
	@org.junit.jupiter.api.Test
	void testDuplicates() {
		int[] arr3 = {1,0,1,2,3,7,8,7};
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		hw.checkCons(arr3);
		assertEquals("[0, 3] with consecutive count of 4\r\n" + 
				"[7, 8] with consecutive count of 2\r\n", outContent.toString());
	}
	@org.junit.jupiter.api.Test
	void testDuplicates2() {
		int[] arr3 = {9,0,-1,-1,12,1,2,10,12};
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		hw.checkCons(arr3);
		assertEquals("[-1, 2] with consecutive count of 4\r\n" + 
				"[9, 10] with consecutive count of 2\r\n" + 
				"[12, 12] with consecutive count of 1\r\n", outContent.toString());
	}
	@org.junit.jupiter.api.Test
	void testOnlyOneElement() {
		int[] arr3 = {5,5,5,5};
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		hw.checkCons(arr3);
		assertEquals("[5, 5] with consecutive count of 1\r\n", outContent.toString());
	}
}
