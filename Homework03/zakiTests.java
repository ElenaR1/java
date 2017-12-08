 /* private static MovieReviewSentimentAnalyzer analyzer;
    static {
        try {
            analyzer = new MovieReviewSentimentAnalyzer("movieReviews.txt",
                                                        "stopwords.txt");
        } catch (IOException e) {
            e.printStackTrace(); // TODO
        }
    }
    */

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
	   
