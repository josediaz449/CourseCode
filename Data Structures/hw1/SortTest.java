package hw1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class SortTest {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//scans in file from Simulator.java
		Scanner in = new Scanner(new FileReader("src/hw1/nums.txt"));
		int sets = in.nextInt();
		while (in.hasNext()) {
			//creates file for results
			PrintWriter writer = new PrintWriter("src/hw1/results.txt", "UTF-8");
			//loop to go though sets
			for(int i = 0; i<sets;i++) {
				int iNum = in.nextInt();
				int[] array = new int[iNum];
				//loop to add elements from file to array
				for (int j = 0; j<iNum;j++) {
					array[j] = in.nextInt();
				}
				//start time of sort
				long startTime = System.currentTimeMillis();
				//insertion sort
				for(int k = 0;k<iNum;k++) {
					int smallest = array[k];
					int newSmall = 0;
					int newSmallInd=k;
					for(int h = k+1;h<iNum; h++) {
						if(array[h]< smallest) {
							newSmall = array[h];
							newSmallInd = h;
						}
					}
					array[k]=newSmall;
					array[newSmallInd]=smallest;
				}
				//end time of sort
				long endTime = System.currentTimeMillis();
				long runTime = endTime - startTime;
				System.out.println(iNum+" "+runTime);
				writer.println(iNum+" "+runTime);
			}
			writer.close();
		}
	}

}
