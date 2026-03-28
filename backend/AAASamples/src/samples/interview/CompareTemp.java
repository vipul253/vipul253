package samples.interview;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class CompareTemp {

	public static void main(String[] args) {
		// make custom comparators to sort by year, rating and name
		NavigableSet<Movie> movieList = new TreeSet<Movie>();
		movieList.add(new Movie("Bahubali", 8.3, 2015));
		movieList.add(new Movie("Janbar", 8.7, 1977));
		movieList.add(new Movie("Mr.India", 8.8, 1980));
		movieList.add(new Movie("Amar Akbar Anthony", 8.4, 1983));
		System.out.println("Movies after sorting: ");
		for (Movie movie : movieList) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
		/*
		 * Initialization is key: The comparator is specified at the TreeSet's creation
		 * time. You cannot change the comparator of an already existing TreeSet.
		 * 
		 * Consistency with equals(): The custom comparator should be consistent with
		 * the equals() method of your objects to ensure the TreeSet behaves correctly
		 * (e.g., properly handles duplicates). No new lists: By using the appropriate
		 * constructor, the TreeSet handles the sorting internally as elements are
		 * added, eliminating the need to create and sort an intermediate list
		 */
		Comparator<Movie> compareByRatingAsc = (a, b) -> Double.compare(a.getRating(), b.getRating());
		Comparator<Movie> compareByRatingDesc = (a, b) -> Double.compare(b.getRating(), a.getRating());

		Comparator<Movie> compareByNameAsc = (a, b) -> a.getName().compareTo(b.getName());
		Comparator<Movie> compareByNameDesc = (a, b) -> b.getName().compareTo(a.getName());

		Comparator<Movie> compareByYearDesc = (a, b) -> Integer.compare(b.getYear(), a.getYear());

		System.out.println("Movies after compareByRatingAsc: ");
		// Create a new TreeSet with the new comparator and add all elements from the
		// old set
		NavigableSet<Movie> movieList2 = new TreeSet<>(compareByRatingAsc);
		movieList2.addAll(movieList); // Elements are added and re-ordered
		for (Movie movie : movieList2) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
		System.out.println("Movies after compareByRatingDesc: ");
		NavigableSet<Movie> movieList3 = new TreeSet<>(compareByRatingDesc);
		movieList3.addAll(movieList);
		for (Movie movie : movieList3) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
		System.out.println("Movies after compareByNameAsc: ");
		NavigableSet<Movie> movieList4 = new TreeSet<>(compareByNameAsc);
		movieList4.addAll(movieList);
		for (Movie movie : movieList4) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
		System.out.println("Movies after compareByNameDesc: ");
		NavigableSet<Movie> movieList5 = new TreeSet<>(compareByNameDesc);
		movieList5.addAll(movieList);
		for (Movie movie : movieList5) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
		System.out.println("Movies after compareByYearDesc: ");
		NavigableSet<Movie> movieList6 = new TreeSet<>(compareByYearDesc);
		movieList6.addAll(movieList);
		for (Movie movie : movieList6) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}

		// for reverse order, define a new Comparator for reverse order
		// output will be same as compareByYearDesc because compareByYearAsc was given 
		// as natural ordering in the Movie Class
		System.out.println("Movies after reverseComparator: ");
		Comparator<Movie> reverseComparator = Comparator.reverseOrder();
		NavigableSet<Movie> movieList99 = new TreeSet<>(reverseComparator);
		movieList99.addAll(movieList);
		for (Movie movie : movieList99) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
	}
}
