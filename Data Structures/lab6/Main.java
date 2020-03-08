package lab6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] heap = new int[size+1];
		for(int i = 1; i<heap.length;i++) {
			heap[i]= in.nextInt();
		}
		for(int i = 1; i<=heap.length-1;i++) {
			
			if(i==1) {
			System.out.println("node 1: "+ "key = "+heap[i]+", left key = "+heap[2*i]+", right key = "+heap[2*i+1]+",");
			}
			else if(i>1) {
				if(2*i+1<heap.length) {
				System.out.println("node "+i+": "+ "key = "+heap[i]+", parent key = "+heap[i/2]+", left key = "+heap[2*i]+", right key = "+heap[2*i+1]+",");
				}
				else if(2*i<heap.length) {
					System.out.println("node "+i+": "+ "key = "+heap[i]+", parent key = "+heap[i/2]+", left key = "+heap[2*i]+",");
				}
				else {
					System.out.println("node "+i+": "+ "key = "+heap[i]+", parent key = "+heap[i/2]+",");
				}
			}
		}
		
	}

}
