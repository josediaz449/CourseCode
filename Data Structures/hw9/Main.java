package hw9;

import java.util.Scanner;

public class Main {
	public int computeMaxProfit(int n, int[] R) {
		int maxProfit = -1000000000;
		for(int i = 0; i < n; i ++) {
			  for(int j = i +1; j < n; j ++) {
				if(R[j] - R[i] > maxProfit)
					maxProfit = R[j] - R[i];
			  }
		}
		return maxProfit;
	}
	
	public int computeMaxProfit2(int n, int[] R) {
		int maxProfit = -1000000000;
		int minCurr = R[0];
		for(int i = 0; i < n; i ++) {
			  for(int j = i +1; j < n; j ++) {
				if(minCurr > R[i]) {
					minCurr = R[i];
				}
				if(maxProfit < R[j]-minCurr) {
					maxProfit = R[j]-minCurr;
				}
			  }
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] r = new int[n];
		for(int i = 0;i<n;i++) {
			r[i]= in.nextInt();
		}
		System.out.println(main.computeMaxProfit2(n, r));
;
		
	}

}
