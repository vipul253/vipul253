package samples.ds;

import java.util.ArrayList;

import samples.searching.BFS;
import samples.searching.DFS;

public class DemoGraph {

	public ArrayList<Node> nodes;
	public int[][] matrix;

	DemoGraph(int size) {
		nodes = new ArrayList<>();
		matrix = new int[size][size];
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public void addEdge(int src, int dst) {
		matrix[src][dst] = 1;
		//matrix[dst][src] = 1; //for both direction edge
	}

	public void print() {

		System.out.print("  ");
		for (Node node : nodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();

		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {

		DemoGraph graph = new DemoGraph(5);

		graph.addNode(new Node('A'));
		graph.addNode(new Node('B'));
		graph.addNode(new Node('C'));
		graph.addNode(new Node('D'));
		graph.addNode(new Node('E'));

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);

		graph.print();
		BFS bfs = new BFS(graph);
		bfs.traverse(0);
		System.out.println("--------------");
		
		DFS dfs = new DFS(graph);
		dfs.traverse(0);
		System.out.println("--------------");
		dfs.dfsByStack(0);

	}
}
