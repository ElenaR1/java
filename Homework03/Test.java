package bg.uni.sofia.fmi.mjt.sentiment;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * String
		 * a="4 This quiet , 			introspective and entertaining  *   independent is worth seeking ."
		 * ; String[] parts = a.split("\\s+");//1 or more spaces \\s+ 0 or more spaces
		 * (\s*), for(int i=0;i<parts.length;i++) { System.out.println(parts[i]);
		 * 
		 * } System.out.println(Character.isDigit(parts[1].charAt(0))); List<String>
		 * l=new ArrayList<String>(); for(int i=0;i<parts.length;i++) {
		 * if(Character.isDigit(parts[i].charAt(0)) ||
		 * Character.isLetter(parts[i].charAt(0))) { l.add(parts[i]); } } for(int
		 * i=0;i<l.size();i++) { System.out.println(l.get(i)); }
		 * System.out.println(l.size());
		 */

		/*
		 * MovieReviewSentimentAnalyzer obj=new MovieReviewSentimentAnalyzer("a.txt",
		 * "stopwords.txt"); String
		 * review="This is an absolutely quiet , entertaining and handsome film .";
		 * System.out.println(obj.getReviewSentiment(review));
		 */
		MovieReviewSentimentAnalyzer obj2 = new MovieReviewSentimentAnalyzer("movieReviews.txt", "stopwords.txt");
		System.out.println(obj2.getReviewSentimentAsName("throes"));
	}

}
