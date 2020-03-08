package lab12;

public class DijkstraMain {
	public static void main(String[] argv) {
		Graph g = new Graph();
		g.loadAdjMatrix();
		int[] dist = g.MST(0);
		int d =0;
		for(int i = 0; i < g.getTotalVertex(); i ++) {
			d+=dist[i];
		}
		System.out.println(d);
	}
}
