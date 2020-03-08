package hw9;

import java.util.Scanner;

public class EditDistance {
	public int computeDistance(String s1, String s2) {
		int[][] d = new int[s1.length()+1][s2.length()+1];
		for(int i = 1; i <= s1.length(); i ++)  {
	        for(int j = 1; j <= s2.length(); j ++) {
	                if(s1.charAt(i-1) == s2.charAt(j-1)) {
	                	d[i][j] = d[i-1][j-1];
	                }
	                else {
	                	d[i][j]= Math.min(d[i-1][j] + 1, d[i][j-1] + 1);
	                }
	        }
		}
		return d[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		EditDistance e = new EditDistance();
		System.out.println(e.computeDistance(s1, s2));

	}

}
