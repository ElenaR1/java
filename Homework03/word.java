package bg.uni.sofia.fmi.mjt.sentiment;

public class Word implements Comparable<Word> {
	private String wordMeaning;
	private double rating;
	private double sumOfRatings;
	private int numOfOccurences;

	public Word(String w) {
		this.wordMeaning = w;
		this.numOfOccurences = 0;
		this.rating = 0.0;
		this.sumOfRatings = 0.0;

	}

	/*
	 * public void increment() { this.numOfOccurences+=1; }
	 */
	public void formRating(double r) {
		sumOfRatings += r;
		this.rating = sumOfRatings / (++numOfOccurences);
	}

	public int getnNumOfOccurences() {
		return this.numOfOccurences;
	}

	public double getRating() {
		return this.rating;
	}

	public String getWord() {
		return this.wordMeaning;
	}

	@Override
	public int compareTo(Word other) {
		if (this.rating == other.getRating())
			return 0;
		return this.rating < other.getRating() ? 1 : -1;
	}

}
