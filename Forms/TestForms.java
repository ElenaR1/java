import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class TestForms {
	@Test
	void testExample() {
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
		String configs2[] = { "BAA", "FRA", "CAB","DRC","EAD","GLE" };
		Forms obj = new Forms(arr, 10, 10);
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		obj.check(10, 10, 'A', configs2,numConfigs);
		assertEquals(
				"  0 1 2 3 4 5 6 7 8 9 \r\n" + 
				"0 . . * G E . * . * * \r\n" + 
				"1 . . . C D * * . . . \r\n" + 
				"2 * . * B . . * . . * \r\n" + 
				"3 . * * A F . . * . * \r\n" + 
				"4 . . . * . . * . * . \r\n" + 
				"5 . * * * . . . * . . \r\n" + 
				"6 * . . . . . . * . * \r\n" + 
				"7 . . . . . * * . . * \r\n" + 
				"8 . . * . * . * . . * \r\n" + 
				"9 * * * . * . * * . . \r\n" + 
				"-----------\r\n" + 
				"  0 1 2 3 4 5 6 7 8 9 \r\n" + 
				"0 . . * . . . * . * * \r\n" + 
				"1 . . . . . * * . . . \r\n" + 
				"2 * . * . G E * . . * \r\n" + 
				"3 . * * . C D . * . * \r\n" + 
				"4 . . . * B . * . * . \r\n" + 
				"5 . * * * A F . * . . \r\n" + 
				"6 * . . . . . . * . * \r\n" + 
				"7 . . . . . * * . . * \r\n" + 
				"8 . . * . * . * . . * \r\n" + 
				"9 * * * . * . * * . . \r\n" + 
				"-----------\r\n" + 
				"  0 1 2 3 4 5 6 7 8 9 \r\n" + 
				"0 . . * . . . * . * * \r\n" + 
				"1 . . . . . * * . . . \r\n" + 
				"2 * . * . . . * . . * \r\n" + 
				"3 . * * . G E . * . * \r\n" + 
				"4 . . . * C D * . * . \r\n" + 
				"5 . * * * B . . * . . \r\n" + 
				"6 * . . . A F . * . * \r\n" + 
				"7 . . . . . * * . . * \r\n" + 
				"8 . . * . * . * . . * \r\n" + 
				"9 * * * . * . * * . . \r\n" + 
				"-----------\r\n" + 
				"3\r\n",
				outContent.toString());
	}
	@Test
	void test2() {
		char[][] arr2 ={{ '.', '.', '*', '.', '.',  },
				{ '*', '*', '.', '.', '.' },
				{ '*', '.', '*', '.', '.', },
				{ '.', '*', '*', '.', '.',  },
				{ '.', '.', '.', '*', '.', },
				{ '.', '*', '*', '*', '.',  }
				};
		String configs[] = { "GLA","KLG","VAG" };
		int numConfigs2 = 3;
		Forms obj2 = new Forms(arr2, 6, 5);
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		obj2.check(6, 5, 'A', configs,numConfigs2);
		
		assertEquals(
				"  0 1 2 3 4 \r\n" + 
				"0 . . * V . \r\n" + 
				"1 * * K G A \r\n" + 
				"2 * . * . . \r\n" + 
				"3 . * * . . \r\n" + 
				"4 . . . * . \r\n" + 
				"5 . * * * . \r\n" + 
				"-----------\r\n" + 
				"1\r\n",
				outContent.toString());
		
		
	}
	@Test
	void test3() {
		char[][] arr3 ={{ '.', '.', '*', '.', '.',  },
				{ '*', '.', '.', '.', '.' },
				{ '*', '.', '*', '.', '.', },
				{ '.', '*', '*', '.', '.',  },
				{ '.', '.', '.', '*', '.', },
				{ '.', '*', '*', '*', '.',  }
				};
		//String configs3[] = {"BAA"};
		String configs3[] = {"BAA","GAB","FRB","KRF"};
		int numConfigs3 = 4;
		Forms obj3 = new Forms(arr3, 6, 5);
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		obj3.check(6, 5, 'A', configs3,numConfigs3);
		assertEquals(
				"  0 1 2 3 4 \r\n" + 
				"0 . G * . . \r\n" + 
				"1 * B F K . \r\n" + 
				"2 * A * . . \r\n" + 
				"3 . * * . . \r\n" + 
				"4 . . . * . \r\n" + 
				"5 . * * * . \r\n" + 
				"-----------\r\n" + 
				"  0 1 2 3 4 \r\n" + 
				"0 . . * . . \r\n" + 
				"1 * . . . . \r\n" + 
				"2 * . * . . \r\n" + 
				"3 G * * . . \r\n" + 
				"4 B F K * . \r\n" + 
				"5 A * * * . \r\n" + 
				"-----------\r\n" + 
				"2\r\n",
				outContent.toString());
		
		
	}
	@Test
	void testFirstExample() {
		char[][] arr5 ={{ '.', '.', '.', '*', '.','.','.','.','*','*','*','*','*','.','.' },
				{ '.', '.', '*', '.', '.','*','.','.','.','.','*','.','*','.','.' },
				{ '.', '.', '.', '.', '*','.','.','.','.','.','*','.','.','.','.' }
				};
			String configs5[] = {"MAI","VAM","GRM"};
			int numConfigs5 = 3;
			Forms obj5 = new Forms(arr5, 3, 15);
			//obj5.print(arr5);
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
			obj5.check(3, 15, 'I', configs5,numConfigs5);


		assertEquals(
				"  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 \r\n" + 
				"0 V . . * . . . . * * * * * . . \r\n" + 
				"1 M G * . . * . . . . * . * . . \r\n" + 
				"2 I . . . * . . . . . * . . . . \r\n" + 
				"-----------\r\n" + 
				"  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 \r\n" + 
				"0 . . . * . . V . * * * * * . . \r\n" + 
				"1 . . * . . * M G . . * . * . . \r\n" + 
				"2 . . . . * . I . . . * . . . . \r\n" + 
				"-----------\r\n" + 
				"  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 \r\n" + 
				"0 . . . * . . . V * * * * * . . \r\n" + 
				"1 . . * . . * . M G . * . * . . \r\n" + 
				"2 . . . . * . . I . . * . . . . \r\n" + 
				"-----------\r\n" + 
				"  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 \r\n" + 
				"0 . . . * . . . . * * * * * V . \r\n" + 
				"1 . . * . . * . . . . * . * M G \r\n" + 
				"2 . . . . * . . . . . * . . I . \r\n" + 
				"-----------\r\n" + 
				"4\r\n",
				outContent.toString());
		
		
	}
}
