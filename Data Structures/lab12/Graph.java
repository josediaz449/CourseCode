package lab12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	private int totalVertex;
	//adjMatrix[u][v] = 1 if there is an edge from u to v, otherwise 0
	private int[][] adjMatrix;
	//adjWeight[u][v] -- the weight of the edge from u to v if there is one
	private int[][] adjWeight;
	//if a node is settled (e.g., processed in the Dijkstra's algorithm)
	private Boolean[] ifSettled;
	public Graph() { totalVertex = 0; }
	public int getTotalVertex() { return totalVertex; }
	//load graph from standard input
	public void loadAdjMatrix() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjMatrix = new int[totalVertex][totalVertex];
		adjWeight = new int[totalVertex][totalVertex];
		ifSettled = new Boolean[totalVertex];
		int i, j;
		for(i = 0; i < totalVertex; i ++) {
			ifSettled[i] = false;
			for(j = 0; j < totalVertex; j ++) {
				adjMatrix[i][j] = adjWeight[i][j] = 0;
			}
		}
		for(i = 0; i < totalVertex; i ++) {
			for(j = 0; j < totalVertex; j ++) {
				int w = in.nextInt();
				if(w==-1) {
				adjMatrix[i][j] = 0;
				}
				else {
					adjMatrix[i][j] = 1;
				adjWeight[i][j] = w;
				}
			}	
		}
		in.close();
	}
	//return weight of the edge from u to v if there is one
	public int getWeight(int u, int v) {
		return adjWeight[u][v];
	}
	//return neighbors of u as a LinkedList
	public LinkedList<Integer> getNeighbors(int u) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for(int v = 0; v < totalVertex; v ++) {
			if(adjMatrix[u][v] == 1) tmp.add(v);
		}
		return tmp;
	}
	//return unsettled neighbors of u as a LinkedList
	public LinkedList<Integer> getUnsettledNeighbors(int u) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for(int v = 0; v < totalVertex; v ++) {
			if((adjMatrix[u][v] == 1) && (ifSettled[v] == false)) tmp.add(v);
		}
		return tmp;
	}
	//return the unsettled node that has the smallest dist
	public int getUnsettledNearest(int[] dist) {
		int md = Integer.MAX_VALUE;
		int mv = -1;
		int v;
		for(v = 0; v < totalVertex; v ++) {
			if((ifSettled[v] == false) && (dist[v] < md)) {
				md = dist[v];
				mv = v;
			}
		}
		return mv;
	}
	//implement the following	
	public int[] Dijkstra(int s) {
		ArrayList<Integer> S = new ArrayList<Integer>();
		int[] dist = new int[totalVertex];
		for(int i = 0; i<dist.length;i++) {
			dist[i]=999999999;
		}
		dist[s]=0;
		while(S.size()<totalVertex) {
			//int n = getUnsettledNearest(dist);
			int v = getUnsettledNearest(dist);
			LinkedList<Integer> tmp = getUnsettledNeighbors(v);
			for (int i = 0;i<tmp.size();i++) {
				dist[tmp.get(i)]= Math.min(dist[v]+getWeight(v,tmp.get(i)), dist[tmp.get(i)]);
			}
			ifSettled[v]=true;
			S.add(v);
		}
		return dist;
	}
	public int[] MST(int s) {
		ArrayList<Integer> S = new ArrayList();
		int[] dist = new int[totalVertex];
		for(int i = 0; i<dist.length;i++) {
			dist[i]=999999999;
		}
		dist[s]=0;
		while(S.size()<totalVertex) {
			//int n = getUnsettledNearest(dist);
			int v = getUnsettledNearest(dist);
			LinkedList<Integer> tmp = getUnsettledNeighbors(v);
			for (int i = 0;i<tmp.size();i++) {
				dist[tmp.get(i)]= Math.min(getWeight(v,tmp.get(i)), dist[tmp.get(i)]);
			}
			ifSettled[v]=true;
			S.add(v);
		}
		return dist;
	}
}
