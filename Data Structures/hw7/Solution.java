package hw7;

import java.util.Scanner;

public class Solution {
	 public static int[] parent;
	   static void union(int x, int y){
	      int r1 = find(x);
	      int r2 = find(y);
	      if(r1 != r2) parent[r1] = r2;
	   }

	   static int find(int x) {
	      int curr = x;
	      if(parent[curr] == curr) return curr;
	      parent[curr] = find(parent[curr]);
	      return parent[curr];
	   }
	   public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);
	     int people = in.nextInt();
	     int pairs = in.nextInt();
	     parent = new int[people];
	     for(int i = 0; i<people; i++){
	        parent[i] = i;
	     }
	     for(int i =0; i< pairs;i++){
	         union(in.nextInt(), in.nextInt());
	     }
	     int q = in.nextInt();
	     for(int i=0;i<q;i++){
	        int x = in.nextInt();
	        int y = in.nextInt();
	        if (parent[x]==parent[y]||find(x)==find(y)){
	           System.out.println("yes");
	        }
	        else {
	           System.out.println("no");
	        }
	     }
	   }
}
