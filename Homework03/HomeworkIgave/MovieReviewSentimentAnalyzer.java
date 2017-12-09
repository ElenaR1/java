package bg.uni.sofia.fmi.mjt.sentiment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MovieReviewSentimentAnalyzer implements SentimentAnalyzer {
	private List<String> stopwords = new ArrayList<String>();
	private List<String> reviews = new ArrayList<String>();
	private Map<String, Word> words = new TreeMap<String, Word>(String.CASE_INSENSITIVE_ORDER);

	public MovieReviewSentimentAnalyzer(String reviewsFileName, String stopwordsFileName) throws IOException {
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(stopwordsFileName));
		String line = null;
		while ((line = reader.readLine()) != null) {
			stopwords.add(line);
		}

		BufferedReader reader2;
		reader2 = new BufferedReader(new FileReader(reviewsFileName));
		String line2 = null;
		while ((line2 = reader2.readLine()) != null) {
			reviews.add(line2);
		}

		/*
		 * for(int i = 0;i < stopwords.size();i++) {
		 * System.out.println(stopwords.get(i)); }
		 * System.out.println("---------------------------"); for(int
		 * i=0;i<reviews.size();i++) { System.out.println(reviews.get(i)); }
		 * System.out.println("---------------------------");
		 */
		evaluateWords();
	}

	public void evaluateWords() {
		for (int i = 0; i < reviews.size(); i++) {
			evaluateWordsHelper(reviews.get(i));
		}

		/*
		 * System.out.println(words.containsKey("adage")); //true int count=0;
		 * for(Entry<String, Word> entry:words.entrySet()) { if (count > 200) break;
		 * else {
		 * System.out.printf("Word: %s , Rating: %f %n",entry.getKey(),entry.getValue().
		 * getRating()); count++; } }
		 */
	}

	public void evaluateWordsHelper(String a) {
		String[] parts = a.split("\\s+");
		// boolean containsSearchStr =
		// stopwords.stream().anyMatch(parts[1]::equalsIgnoreCase);
		// System.out.println(containsSearchStr);

		for (int i = 1; i < parts.length; i++) {
			boolean containsSearchStr = stopwords.stream().anyMatch(parts[i]::equalsIgnoreCase);
			if (!containsSearchStr && isValid(parts[i])) {

				if (!words.containsKey(parts[i])) {
					Word w = new Word(parts[i]);
					double value = Double.parseDouble(parts[0]);
					w.formRating(value);
					words.put(parts[i], w);
				} else {
					double value = Double.parseDouble(parts[0]);
					words.get(parts[i]).formRating(value);
				}

			}
		}

		/*
		 * System.out.printf("Number of words: %d %n",words.size()); for(Entry<String,
		 * Word> entry:words.entrySet()) {
		 * System.out.printf("Word: %s , Rating: %f %n",entry.getKey(),entry.getValue().
		 * getRating()); } System.out.println("---------------------------");
		 */
	}

	@Override
	public double getReviewSentiment(String review) {
		// TODO Auto-generated method stub
		double reviewSentiment = 0.0;
		int contains = 0;
		int numOfWords = 0;
		String[] parts = review.split("\\s+");

		for (int i = 0; i < parts.length; i++) {
			boolean containsSearchStr = stopwords.stream().anyMatch(parts[i]::equalsIgnoreCase);
			if (words.containsKey(parts[i]) && !containsSearchStr) {
				reviewSentiment += words.get(parts[i]).getRating();
				numOfWords++;
				contains++;
			}
		}
		if (contains != 0) {
			return reviewSentiment / numOfWords;
		} else
			return -1;

	}

	@Override
	public String getReviewSentimentAsName(String review) {
		// TODO Auto-generated method stub
		double reviewSentiment = getReviewSentiment(review);
		String temp;
		String result;
		if (reviewSentiment >= 0.0 && reviewSentiment < 1.00) {
			temp = ReviewSentiment.NEGATIVE.type;
			result = temp;
			return result;
		} else if (reviewSentiment >= 1.0 && reviewSentiment < 1.5) {
			temp = ReviewSentiment.SOMEWHAT_NEGATIVE.type;
			result = temp;
			return result;
		} else if (reviewSentiment >= 1.5 && reviewSentiment < 2.0) {
			temp = ReviewSentiment.NEUTRAL.type;
			result = temp;
			return result;
		} else if (reviewSentiment >= 2.0 && reviewSentiment < 3.0) {
			temp = ReviewSentiment.SOMEWHAT_POSITIVE.type;
			result = temp;
			return result;
		} else if (reviewSentiment >= 3.0 && reviewSentiment <= 4.0) {
			temp = ReviewSentiment.POSITIVE.type;
			result = temp;
			return result;
		} else if (reviewSentiment == -1) {
			temp = ReviewSentiment.UNKNOWN.type;
			result = temp;
			return result;
		}
		return "error";
	}

	@Override
	public double getWordSentiment(String word) {
		// TODO Auto-generated method stub
		if (words.containsKey(word)) {
			return words.get(word).getRating();
		} else {
			return -1;
		}

	}

	@Override
	public Collection<String> getMostFrequentWords(int n) {
		// TODO Auto-generated method stub
		List<Word> l = new ArrayList<Word>();
		for (Entry<String, Word> entry : words.entrySet()) {
			l.add(entry.getValue());
		}

		/*
		 * for(int i =0; i<l.size(); i++) {
		 * System.out.printf("%s - %d %n",l.get(i).getWord(),l.get(i).
		 * getnNumOfOccurences()); } System.out.println("---------------------------");
		 * System.out.println("Sorted:");
		 */

		Collections.sort(l, new Comparator<Word>() {
			public int compare(Word one, Word other) {
				if (one.getnNumOfOccurences() == other.getnNumOfOccurences())
					return 0;
				return one.getnNumOfOccurences() < other.getnNumOfOccurences() ? 1 : -1;
			}
		});

		/*
		 * for(int i =0; i<l.size(); i++) {
		 * System.out.printf("%s - %d %n",l.get(i).getWord(),l.get(i).
		 * getnNumOfOccurences()); } System.out.println("---------------------------");
		 */
		List<String> mostFrequentWords = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			mostFrequentWords.add(l.get(i).getWord());
		}
		System.out.println("Most Frequent words: ");
		for (String w : mostFrequentWords) {
			System.out.println(w);
		}
		return mostFrequentWords;

	}

	@Override
	public Collection<String> getMostPositiveWords(int n) {
		// TODO Auto-generated method stub
		List<Word> l = new ArrayList<Word>();
		for (Entry<String, Word> entry : words.entrySet()) {
			l.add(entry.getValue());
		}

		/*
		 * for(int i =0; i<l.size(); i++) {
		 * System.out.printf("%s - %f %n",l.get(i).getWord(),l.get(i).getRating()); }
		 * System.out.println("---------------------------");
		 * System.out.println("Sorted:");
		 */
		Collections.sort(l);
		/*
		 * for(int i =0; i<l.size(); i++) {
		 * System.out.printf("%s - %f %n",l.get(i).getWord(),l.get(i).getRating()); }
		 * System.out.println("---------------------------");
		 */

		List<String> mostPositiveWords = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			mostPositiveWords.add(l.get(i).getWord());
		}
		System.out.println("Most Positive words: ");
		for (String w : mostPositiveWords) {
			System.out.println(w);
		}
		return mostPositiveWords;
	}

	@Override
	public Collection<String> getMostNegativeWords(int n) {
		// TODO Auto-generated method stub
		List<Word> l = new ArrayList<Word>();
		for (Entry<String, Word> entry : words.entrySet()) {
			l.add(entry.getValue());
		}

		/*
		 * for(int i =0; i<l.size(); i++) {
		 * System.out.printf("%s - %f %n",l.get(i).getWord(),l.get(i).getRating()); }
		 * System.out.println("---------------------------");
		 * System.out.println("Sorted:");
		 */
		Collections.sort(l);
		Collections.reverse(l);
		/*
		 * for(int i =0; i<l.size(); i++) {
		 * System.out.printf("%s - %f %n",l.get(i).getWord(),l.get(i).getRating()); }
		 * System.out.println("---------------------------");
		 */

		List<String> mostNegativeWords = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			mostNegativeWords.add(l.get(i).getWord());
		}
		System.out.println("Most Negtive words: ");
		for (String w : mostNegativeWords) {
			System.out.println(w);
		}
		return mostNegativeWords;
	}

	@Override
	public int getSentimentDictionarySize() {
		// TODO Auto-generated method stub
		return this.words.size();
	}

	@Override
	public boolean isStopWord(String word) {
		// TODO Auto-generated method stub
		boolean containsSearchStr = stopwords.stream().anyMatch(word::equalsIgnoreCase);
		if (containsSearchStr) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValid(String word) {
		int c = 0;
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i)) || Character.isDigit(word.charAt(i))) {
				c++;
			} else {
				break;
			}
		}
		if (c == word.length()) {
			return true;
		} else {
			return false;
		}

	}
}
