package lab14;

import java.util.Scanner;

public class Solution {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int currX =0;
		int currY =0;
		double dist =0;
		int[][] coordA = new int[x+1][y+1];
		int diags = in.nextInt(); 
		for(int i =0;i<diags;i++) {
			int diagX = in.nextInt();
			int diagY = in.nextInt();
			if(diagX<=x&&diagY<=y) {
			coordA[diagX][diagY] =1;
			}
		}
		while(!(currX==x)||!(currY==y)) {
			if(coordA[currX][currY]==0) {
				dist+=100;
				
				if(currX<x&&currY<y) {
					if(coordA[currX+1][currY]==1) {
						currX+=1;
						
					}
					else if(coordA[currX][currY+1]==1) {
						currY+=1;
					}
					else {
						if(x-currX>y-currY) {
							currX+=1;
						}
						else {
							currY+=1;
						}
					}
				}
				else if(currX==x&&currY<y) {
					currY+=1;
				}
				else {
					currX+=1;
				}
			}
			else {
				dist+=100 * Math.sqrt(2);
				currX+=1;
				currY+=1;
			}
			//System.out.println(currX+" "+currY);
			//System.out.println("dist "+dist);
		}
		
		System.out.println(Math.round(dist));

	}

}
