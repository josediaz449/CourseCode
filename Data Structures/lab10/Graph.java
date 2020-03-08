package lab10;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	private int totalVertex;
	private LinkedList<LinkedList<Integer>> adjList;
	int[] d = new int[totalVertex];
	int[] f = new int[totalVertex];

	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjList = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < totalVertex; i++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			int idx1 = in.nextInt() - 1;
			int degree = in.nextInt();
			//System.out.println("mark idx1 = " + idx1 + " degree = " + degree);
			for(int j = 0; j < degree; j ++) {
				int idx2 = in.nextInt() - 1;
				tmp.add(idx2);
			}	
			adjList.add(tmp);
		}
		in.close();
	}
	public void printAdjMatrix() {
		Integer[][] adjMatrix = new Integer[totalVertex][totalVertex];
		//complete the following
		for(int i = 0; i < totalVertex;i++) {
			for(int j =0; j<totalVertex;j++) {
			LinkedList<Integer> list = adjList.get(i);
			if(list.contains(j)) {
				System.out.print(1+" ");
			}
			else {
				System.out.print(0+" ");
			}
			}
			System.out.println();
		}
	}
	public int DFS(int vertex,  int time) {
		LinkedList<Integer> list = adjList.get(vertex);
		if(d[vertex]==0){
		d[vertex]=time;
		}
		for(int i = 0; i < totalVertex;i++) {
			if(list.contains(i)&&(d[i]==0)) {
				time++;
				time = DFS(i,time);
			}
			
		}
		f[vertex]=time+1;
		
		return f[vertex];
	}
	public static void main(String argv[]) {
		int time = 1;
		Graph g = new Graph();
		g.loadAdjList();
		
		//g.printAdjMatrix();
		
		for(int i =0; i<g.totalVertex;i++) {
			if(g.d[i]==0) {
				time = g.DFS(i, time);
				time++;
			}
		}
		
		
		//System.out.print(g.d[0]+" "+g.d[0]);
	}
}
