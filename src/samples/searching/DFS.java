package samples.searching;

import java.util.Stack;

import samples.general.DemoGraph;

public class DFS {
	// Depth FS = Traverse a graph branch by branch
	// Utilizes a Stack
	// Better if destination is on average far from the start
	// Children are visited before siblings
	// More popular for games/puzzles

	private DemoGraph g;

	public DFS(DemoGraph g) {
		this.g = g;
	}

	public void traverse(int src) {
		boolean[] visited = new boolean[g.matrix.length];
		dFSHelper(src, visited);
	}

	// recursive approach
	private void dFSHelper(int src, boolean[] visited) {

		visited[src] = true;
		System.out.println(g.nodes.get(src).data + " = visited");
		for (int i = 0; i < g.matrix[src].length; i++) {
			if (g.matrix[src][i] == 1 && !visited[i]) {
				dFSHelper(i, visited);
			}
		}
		return;
	}

	public void dfsByStack(int src) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[g.matrix.length];

		stack.push(src);
		while (!stack.empty()) {
			int curr = stack.pop();
			System.out.println(g.nodes.get(curr).data + " = visited");
			visited[curr] = true;
			for (int j = 0; j < g.matrix[curr].length; j++) {
				if (!visited[j] && g.matrix[curr][j]==1) {
					stack.push(j);
					visited[j] = true;
				}
			}
		}
	}
}
