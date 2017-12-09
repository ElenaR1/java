package bg.uni.sofia.fmi.mjt.sentiment;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestMovieReviewSentimentAnalyzer  {
	private static final double DELTA = 1E-5;
    public static final double REVIEW_SENTIMENT = 2.5625;
	public static final double WORD_SENTIMENT = 3.5;
	private static MovieReviewSentimentAnalyzer analyzer;
    static {
        try {
            analyzer = new MovieReviewSentimentAnalyzer("movieReviews.txt",
                                                        "stopwords.txt");
        } catch (IOException e) {
            e.printStackTrace(); // TODO
        }
    }
  
	
	
	@Test
	public void testMovieReviewSentimentAnalyzer()throws IOException {
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt"); 
		//obj.evaluateWords();
		//String review = "This is an absolutely quiet , entertaining film with a handsome main actor ."; 
		//assertEquals(REVIEW_SENTIMENT, obj.getReviewSentiment(review),DELTA); //The words that we have are: entertaining,quiet & handsome
		//rating->2,166
		//assertEquals("somewhat positive", obj.getReviewSentimentAsName(review)); 
		//assertEquals(WORD_SENTIMENT, obj.getWordSentiment("entertaining"), DELTA); 
		//obj.getMostFrequentWords(3);  
	} 
	
	
	@Test
	public void testgetReviewSentiment()throws IOException{
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt"); 
		String review = "This is a quietly , grenade pesen with a  midlife neshto ."; 
		assertEquals(REVIEW_SENTIMENT, obj.getReviewSentiment(review),DELTA);   
		 assertEquals(-1.0, obj.getReviewSentiment("jfpwehf "),DELTA);
		 assertEquals(-1.0, obj.getReviewSentiment(""),DELTA);
		 assertEquals(1.8286893704850362, obj.getReviewSentiment("movie"),DELTA);
		 assertEquals(1.8286893704850362, obj.getReviewSentiment("mOvIe"),DELTA);
		 assertEquals(1.8286893704850362, obj.getReviewSentiment("Movie"),DELTA);
	}
	@Test
	public void testgetReviewSentimentAsName()throws IOException{
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt"); 
		String review = "This is a quietly , grenade pesen with a  midlife neshto ."; 
		assertEquals("somewhat positive", obj.getReviewSentimentAsName(review));    
		assertEquals("negative", obj.getReviewSentimentAsName("zzzzzzzzz "));
	    assertEquals("positive", obj.getReviewSentimentAsName("menacing "));
	    assertEquals("neutral", obj.getReviewSentimentAsName("solemnity "));
	    assertEquals("unknown", obj.getReviewSentimentAsName("jfpwehf "));
	}
	@Test
	public void testgetWordSentiment()throws IOException{
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt"); 
		String review = "This is a quietly , grenade pesen with a  midlife neshto ."; 
		assertEquals(WORD_SENTIMENT, obj.getWordSentiment("midlife"), DELTA); 
	}
	
	@Test
	public void testgetMostPositiveWords()throws IOException {
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
		List<String> l=new ArrayList<String>();
		l.add("12th");
		l.add("1930s");
		l.add("1937");
		assertEquals(l, obj.getMostPositiveWords(3));
	}
	@Test
	public void testgetMostNegativeWords()throws IOException {
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt"); 
		List<String> l=new ArrayList<String>();
		l.add("zzzzzzzzz");
		l.add("Zipper");
		l.add("zeroes");
		assertEquals(l, obj.getMostNegativeWords(3));
	}
	@Test
	public void testgetMostFrequentWords()throws IOException {
		//MovieReviewSentimentAnalyzer obj=new MovieReviewSentimentAnalyzer("b.txt", "stopwords.txt");
		//obj.getMostFrequentWords(2);
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt"); 
		List<String> l=new ArrayList<String>();
		l.add("film");
		l.add("movie"); 
		l.add("one");
		assertEquals(l, obj.getMostFrequentWords(3));
	}
	 @Test
	    public void testIsStopWord()throws IOException {
		 MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt"); 
	        assertTrue(obj.isStopWord("this")); 
	        assertFalse(obj.isStopWord("'"));
	    }

	@Test
	public void testGetSentimentDictionarySize()throws IOException  {
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
		assertEquals(14588,obj.getSentimentDictionarySize());
		
	}
	
	/*@Test
    public void getsReviewOfEmptySequence() throws IOException {
		MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
        assertEquals(-1.0, obj.getReviewSentiment(""), 0.0);
    }
	  @Test
	    public void getsReviewOfSequenceWithUnknownWords() throws IOException{
		  MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
	      assertEquals(-1.0, obj.getReviewSentiment("zakiunknown"), 0.0);
	    }
	  @Test
	    public void getsReviewOfSequenceWithOnlyKnownWords() throws IOException {
		  MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
	        assertEquals(2.8, obj.getReviewSentiment("The film proves perfection"), 0.1);
	    } 
	  @Test
	    public void getsReviewOfSequenceWithKnownAndUnknownWords()  throws IOException{
		  MovieReviewSentimentAnalyzer obj = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
	      assertEquals(2.8, obj.getReviewSentiment("The film proves perfection zdrkp zaki is"), 0.1);
	    }
	  @Test
	    public void getsReviewOfSequenceWithStopWords() {
	        assertEquals(2.8, analyzer.getReviewSentiment("The is film yours a proves perfection"), 0.1);
	    }
	  //??????
	  @Test
	    public void getsReviewOfSequenceWithMixedSymbols() {
	       // assertEquals(2.1,,DELTA);
		 // System.out.println( analyzer.getReviewSentiment("The ' a yours proves is .,"));//proves is 2,4
	    }
	    @Test
	    public void returnsTrueIfWordIsStopWord() {
	        assertTrue(analyzer.isStopWord("is"));
	        assertTrue(analyzer.isStopWord("your"));
	    }
	    @Test
	    public void returnsFalseIfWordIsNotStopWord() {
	        assertFalse(analyzer.isStopWord("'"));
	        assertFalse(analyzer.isStopWord("Movie"));
	    }
	    @Test
	    public void returnsCorrectSentimentResultIfWordIsNotFound() {
	        assertEquals(-1.0, analyzer.getWordSentiment("notfound404"), 0.0);
	    }
	    @Test
	    public void returnsWordSentimentLowerCase() {
	        assertEquals(1.8, analyzer.getWordSentiment("movie"), 0.1);
	    }
	    @Test
	    public void returnsWordSentimentUpperCase() {
	        assertEquals(1.8, analyzer.getWordSentiment("MOVIE"), 0.1);
	    }
	    @Test
	    public void returnsWordSentimentMixedCase() {
	        assertEquals(1.8, analyzer.getWordSentiment("mOvIe"), 0.1);
	    }
	    @Test
	    public void returnsCorrectSentimentNameIfWordIsUnknown() {
	        assertEquals("unknown", analyzer.getReviewSentimentAsName("zaki"));
	        String review = "This is a quietly , grenade pesen with a  midlife neshto ."; 
			assertEquals("somewhat positive", analyzer.getReviewSentimentAsName(review));  
	    }
	    @Test
	    public void returnsCorrectSentimentNameIfWordIsKnown() {
	        assertEquals("negative", analyzer.getReviewSentimentAsName("throes"));
	        assertEquals("somewhat negative", analyzer.getReviewSentimentAsName("dreadful"));
	        assertEquals("somewhat positive", analyzer.getReviewSentimentAsName("pollution")); //zaki-neutral
	        assertEquals("positive", analyzer.getReviewSentimentAsName("chronicle"));
	        assertEquals("positive", analyzer.getReviewSentimentAsName("spontaneous"));
	    }
	    //?????
	    @Test
	    public void returnsCorrectDictionarySize() {
	        // better test is to remove all the stop words and then distinct all the words and count their size
	        assertEquals(16389, analyzer.getSentimentDictionarySize());
	    }*/
	   
	    
}
