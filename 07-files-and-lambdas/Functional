public double shortestNotAscended() {
		Peak shortest = this.peaks.stream().filter(p -> p.getFirstAscent() == 0)
				.reduce((x, y) -> x.getHeight() < y.getHeight() ? x : y).get();
		return shortest.getHeight();

	}

	
	public double avgAscentsTopN(int n) {
		if (peaks.stream().limit(n).allMatch(el -> el.getFirstAscent() > 0)) {
			double sum = this.peaks.stream().limit(n).map(e -> e.getTotalAscents()).reduce(0, (res, el) -> res + el);
			return (sum / n);
		}
		return 0.0;
	}


	public long getPositionByProminence(double prominence) {
	
		double place = this.peaks.stream()
				.map(e -> e.getProminence())
				.sorted(Comparator.reverseOrder())
				.reduce(1.0,(res,el)->el>prominence ? 1+res:res); 
		
		return (long)place;
	}


	public Peak getHighestAscentPerYear(int year) {
		this.peaks.stream().filter(p-> p.getFirstAscent()==year).findFirst().orElseThrow(() -> new IllegalArgumentException());
		Peak highest = this.peaks.stream().filter(p-> p.getFirstAscent()==year).reduce((x, y)-> x.getHeight()>=y.getHeight()? x : y).get();
		return highest;
	}
