package bg.uni.sofia.fmi.mjt.sentiment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MovieReviewSentimentAnalyzerTest {
	private static final double DELTA = 1E-5;
	private static final double A = -1.0;
	private static final double B = 1.8286893704850362;
	private static final int NUM_OF_WORDS = 14588;
	private static final int N = 3;
	public static final double REVIEW_SENTIMENT = 2.5625;
	public static final double WORD_SENTIMENT = 3.5;
	private static MovieReviewSentimentAnalyzer obj;
	static {
		try {
			obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testgetReviewSentiment() throws IOException {
		String review = "This is a quietly , grenade pesen with a  midlife neshto .";
		assertEquals(REVIEW_SENTIMENT, obj.getReviewSentiment(review), DELTA);
		assertEquals(A, obj.getReviewSentiment("jfpwehf "), DELTA);
		assertEquals(A, obj.getReviewSentiment(""), DELTA);

	}

	@Test
	public void getWordSentimentLowerCase() throws IOException {
		assertEquals(B, obj.getWordSentiment("movie"), DELTA);
	}

	@Test
	public void getWordSentimentMixedCase() throws IOException {
		assertEquals(B, obj.getWordSentiment("mOvIe"), DELTA);
	}

	@Test
	public void getWordSentimentUpperCase() throws IOException {
		assertEquals(B, obj.getWordSentiment("MOVIE"), DELTA);
	}

	@Test
	public void testgetReviewSentimentAsName() throws IOException {
		String review = "This is a quietly , grenade pesen with a  midlife neshto .";
		assertEquals(ReviewSentiment.SOMEWHAT_POSITIVE.type, obj.getReviewSentimentAsName(review));
		assertEquals(ReviewSentiment.NEGATIVE.type, obj.getReviewSentimentAsName("zzzzzzzzz "));
		assertEquals(ReviewSentiment.SOMEWHAT_NEGATIVE.type, obj.getReviewSentimentAsName("dreadful"));
		assertEquals(ReviewSentiment.POSITIVE.type, obj.getReviewSentimentAsName("menacing "));
		assertEquals(ReviewSentiment.NEUTRAL.type, obj.getReviewSentimentAsName("solemnity "));
		assertEquals(ReviewSentiment.UNKNOWN.type, obj.getReviewSentimentAsName("jfpwehf "));
	}

	@Test
	public void testgetWordSentiment() throws IOException {
		assertEquals(WORD_SENTIMENT, obj.getWordSentiment("midlife"), DELTA);
	}

	@Test
	public void testgetMostPositiveWords() throws IOException {
		List<String> l = new ArrayList<String>();
		l.add("12th");
		l.add("1930s");
		l.add("1937");
		assertEquals(l, obj.getMostPositiveWords(N));
	}

	@Test
	public void testgetMostNegativeWords() throws IOException {
		List<String> l = new ArrayList<String>();
		l.add("zzzzzzzzz");
		l.add("Zipper");
		l.add("zeroes");
		assertEquals(l, obj.getMostNegativeWords(N));
	}

	@Test
	public void testgetMostFrequentWords() throws IOException {
		List<String> l = new ArrayList<String>();
		l.add("film");
		l.add("movie");
		l.add("one");
		assertEquals(l, obj.getMostFrequentWords(N));
	}

	@Test
	public void testIsStopWord() throws IOException {
		assertTrue(obj.isStopWord("this"));
		assertFalse(obj.isStopWord("'"));
	}

	@Test
	public void testGetSentimentDictionarySize() throws IOException {
		assertEquals(NUM_OF_WORDS, obj.getSentimentDictionarySize());

	}

}
