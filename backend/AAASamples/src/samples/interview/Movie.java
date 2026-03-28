package samples.interview;

public class Movie implements Comparable<Movie> {

	private double rating;
	private String name;
	private int year;

	// Ascending compare as it is this - movie;
	// Descending compare movie - this;
	public int compareTo(Movie m) {
		return this.year - m.year;
	}

	public Movie(String name, double rating, int year) {
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
}