package lab10;

import java.util.LinkedList;
import java.util.Scanner;
/*
class Graph {
	private int totalVertex;
	private LinkedList<LinkedList<Integer>> adjList;
	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjList = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < totalVertex; i ++) {
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
			if(list.contains(j)&&!(j==totalVertex-1)) {
				System.out.print(1+" ");
			}
			else if(list.contains(j)&&(j==totalVertex-1)) {
				System.out.println(1);
			}
			else if(!(list.contains(j))&&(j==totalVertex-1)) {
				System.out.println(0);
			}
			else {
				System.out.print(0+" ");
			}
			}
		
		}
	}
}

*/
public class GraphRepresentation {
	public static void main(String argv[]) {
		Graph g = new Graph();
		g.loadAdjList();
		//g.printAdjMatrix();
		//for(int i =0; i<g.)
		//g.DFS(vertex, time)
	}
}
