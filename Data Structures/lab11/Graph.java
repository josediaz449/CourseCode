package lab11;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
	private int totalVertex;
	private LinkedList<LinkedList<Integer>> adjList;
	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		int edges = in.nextInt();
		int[] inDegree = new int[totalVertex];
		adjList = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < edges; i++) {
			int source = in.nextInt();
			int target = in.nextInt();
			inDegree[target]+=1;
			if(adjList.get(source)==null) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			tmp.add(target);	
			adjList.add(tmp);
			}
			else {
				adjList.get(source).add(target);
			}
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
	public void BFS(int s) 
	{
		boolean visited[] = new boolean[totalVertex]; 
        Queue<Integer> toVisit = new LinkedList<Integer>(); 
        visited[s]=true; 
        toVisit.add(s); 
        int[] dist = new int[totalVertex];
        for(int i = 0;i<dist.length;i++) {
        	dist[i]=-1;
        }
        dist[s]=0;
        
        while (!toVisit.isEmpty()) 
        { 
            int u = toVisit.poll(); 
            LinkedList<Integer> n = adjList.get(u);
            for(int i = 0 ; i<n.size();i++) {
            	int v = adjList.get(u).get(i);
            	if (!visited[v]) 
                { 
                    visited[v] = true; 
                    toVisit.add(v); 
                    dist[v]=dist[u]+1;
                } 
            } 
            
   
        }
        for(int i=0;i<totalVertex;i++) {
        	System.out.println(i+1+" "+dist[i]);
        }
		
	}
	public void topological() {
		
	}
}
