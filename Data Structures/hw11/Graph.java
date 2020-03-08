package hw11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
	public int totalVertex;
	private ArrayList<ArrayList<Integer>> adjList;
	public ArrayList<Integer> color = new ArrayList<>();
	public int nodeColorSearch;
	private int[] dist;
	private int shortest = Integer.MAX_VALUE;
	
	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjList = new ArrayList<ArrayList<Integer>>();
		dist = new int[totalVertex];
		for(int i = 0; i < totalVertex; i ++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			adjList.add(tmp);
		}
		int edges = in.nextInt();
		for(int j = 0; j < edges; j ++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt()-1;
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}	
		for(int j = 0; j < totalVertex; j ++) {
			int nodeColor = in.nextInt();
			color.add(nodeColor);
		}	
		nodeColorSearch = in.nextInt();
		in.close();
	}
	public int nearestNodeBFS(int start) {
		for(int i=0;i<adjList.size(); i++) {
			dist[i] = -1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		dist[start] = 0;
		while(!q.isEmpty()) {
			int v = q.remove();
			for(int i : adjList.get(v)) {
				if (dist[i]>=shortest) {
					break;
				}
				if (dist[i] == -1) {
					if(color.get(i) == nodeColorSearch) {
						shortest = Math.min(shortest, dist[v]+1);
						return dist[v]+1;
					}
					dist[i]  = dist[v] + 1;
					q.add(i);
				}
				}
			}
		return -1;
	}
	/*
	public int nearestNode() {
		int numberOfColor=0;
		for(int i = 0; i<totalVertex;i++) {
			if(color.get(i)==nodeColorSearch) {
				numberOfColor+=1;
			}		
		}
		if(numberOfColor==0||numberOfColor==1) {
			return -1;
		}
		
		int[][] dist = new int[totalVertex+1][totalVertex+1];
		for(int i =0;i<totalVertex+1;i++) {
			dist[0][i]=0;
			dist[i][0]=0;
		}
		for(int i = 1; i<totalVertex+1; i++) {
			for(int j = 1; j<totalVertex+1; j++) {
				if((color.get(i-1)==nodeColorSearch||color.get(j-1)==nodeColorSearch)&&adjList.get(i-1).contains(j-1)) {
					dist[i][j]=dist[i-1][j-1]+1;
				}
				else {
					dist[i][j]=Math.max(dist[i][j-1], dist[i-1][j]);
				}
			}
		}
		if(dist[totalVertex][totalVertex]==0) {
			return -1;
		}
		else {
			return dist[totalVertex][totalVertex];
		}
	}
	*/
}
