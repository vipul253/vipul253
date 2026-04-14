package samples.interview;

import java.util.TreeMap;

//Must implement Comparable to work as a TreeMap key
class Player implements Comparable<Player> {
	int ranking;
	String name;

	public Player(int ranking, String name) {
		this.ranking = ranking;
		this.name = name;
	}

	// This is the ONLY method TreeMap uses for uniqueness and sorting
	@Override
	public int compareTo(Player other) {
		// Sort by ranking (Natural Ordering)
		return Integer.compare(this.ranking, other.ranking);
	}

	@Override
	public String toString() {
		return name + " (Rank: " + ranking + ")";
	}
}

public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<Player, String> leaderboard = new TreeMap<>();

		leaderboard.put(new Player(1, "Alice"), "Gold Medal");
		leaderboard.put(new Player(2, "Bob"), "Silver Medal");

		// This will OVERWRITE Alice because compareTo returns 0 for rank 1
		leaderboard.put(new Player(1, "Charlie"), "Updated Gold");

		System.out.println(leaderboard);
		// Output: {Charlie (Rank: 1)=Updated Gold, Bob (Rank: 2)=Silver Medal}
	}
}
