package samples.searching;

import java.util.LinkedList;
import java.util.Queue;

import samples.ds.DemoGraph;

public class BFS {
	// Breadth FS = Traverse a graph level by level
	// Utilizes a Queue
	// Better if destination is on average close to start
	// Siblings are visited before children

	private DemoGraph g;

	public BFS(DemoGraph g) {
		this.g = g;
	}

	public void traverse(int src) {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[g.matrix.length];

		queue.offer(src);
		visited[src] = true;

		while (queue.size() != 0) {

			int current = queue.poll();
			System.out.println(g.nodes.get(current).data + " = visited");

			for (int i = 0; i < g.matrix[current].length; i++) {
				if (g.matrix[current][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
