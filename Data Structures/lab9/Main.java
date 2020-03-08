package lab9;

import java.util.Scanner;

public class Main {
	
	public int lcs(String s1, String s2) {
		int[][] array = new int[s1.length()+1][s2.length()+1];
		for(int i = 1; i <= s1.length(); i ++)  {
		        for(int j = 1; j <= s2.length(); j ++) {
		                if(s1.charAt(i-1)==s2.charAt(j-1)) {
		                	array[i][j]= array[i-1][j-1]+1;
		                }
		                else {
		                	if(array[i-1][j]>array[i][j-1]) {
		                		array[i][j]= array[i-1][j];
		                	}
		                	else {
		                		array[i][j]= array[i][j-1];
		                	}
		                }
		        }
		}
		return array[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i<q;i++) {
			String s1 = in.next();
			String s2 = in.next();
			System.out.println(main.lcs(s1, s2));
		}
		
		

	}

}
