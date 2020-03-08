package hw11;

public class Solution {
	public static boolean[] visited;
	public static int[][] adjMatrix;
	public long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		long totalCost = 0;
		int roads = cities.length;
		int connected = 0;
		if (c_lib <= c_road || roads == 0) {
			totalCost = c_lib * n;
			return totalCost;
		}
		
		else {
			adjMatrix = new int[n][n];
			visited = new boolean[n];
			
			//Initialize adjMatr
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adjMatrix[i][j] = 0;
				}
			}
			for (int i = 0; i < roads; i++) {
				int startCity = cities[i][0];
				int endCity = cities[i][1];
				adjMatrix[startCity - 1][endCity - 1] = 1;
				adjMatrix[endCity - 1][startCity - 1] = 1;
			}
			
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					dfs(i);
					connected++;
				}
			}
			
			totalCost = ((c_road * (n - connected)) + (c_lib * connected));
			return totalCost;
		}

    }
	public static void dfs(int city) {
		visited[city] = true;
		int cities = adjMatrix.length;
		for (int i = 0; i < cities; i++) {
			if (adjMatrix[city][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.loadAdjList();
		int shortestPath = Integer.MAX_VALUE;
		for(int i=0;i<g.totalVertex; i++) {
			if(g.color.get(i) == g.nodeColorSearch) {
				int path = g.nearestNodeBFS(i);
				if(path == -1) {
					System.out.println(-1);
					return;
				}
				if (path < shortestPath) {
					shortestPath = path;
				}
			}
		}
		System.out.println(shortestPath);
	}
}
