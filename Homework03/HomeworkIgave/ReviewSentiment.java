package bg.uni.sofia.fmi.mjt.sentiment;

public enum ReviewSentiment {
	NEGATIVE("negative"), SOMEWHAT_NEGATIVE("somewhat negative"), NEUTRAL("neutral"), SOMEWHAT_POSITIVE(
			"somewhat positive"), POSITIVE("positive"), UNKNOWN("unknown");

	ReviewSentiment(String type) {
		this.type = type;
	}

	String type;
}
