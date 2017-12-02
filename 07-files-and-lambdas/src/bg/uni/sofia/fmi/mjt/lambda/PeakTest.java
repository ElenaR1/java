package bg.uni.sofia.fmi.mjt.lambda;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class PeakTest {
	private static final double DELTA = 1E-5;

	@Test
	public void testCreatePeak() {
		// String l="1,Mount Everest,8848.0,8848.0,Mahalangur Himalaya,1953,121";
		// Peak obj=Peak.createPeak(l);
		// assertEquals(obj.getName(),"Mount Everest");
		// assertEquals(obj.getProminence(),8848.0,DELTA);
	}

	@Test
	public void testPeakStats() throws IOException {
		String l = "1,Mount Everest,8848.0,8848.0,Mahalangur Himalaya,1953,121";
		// Peak obj=Peak.createPeak(l);
		PeakStats ob = new PeakStats("a.txt");
	}
}
