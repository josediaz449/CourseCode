package hw1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] intArray = new int[a];
		// adds number of items into array
		for(int x = 0; x<a;x++) {
			intArray[x]=in.nextInt();
		}
		//makes file 
		PrintWriter writer = new PrintWriter("src/hw1/nums.txt", "UTF-8");
		//writes number of sets into file
		writer.println(a);
		System.out.println(a);
		// loop to make sets
		for(int i = a;i>0;i--) {
			System.out.println(intArray[i-1]);
			writer.println(intArray[i-1]);
			String randNum = "";
			//loop to produce random numbers for set
			for(int j = 0;j<intArray[i-1];j++) {
				Random rnd = new Random();
				randNum+= rnd.nextInt(10000)+" ";
			}
			writer.println(randNum);
			System.out.println(randNum);	
		}
		writer.close();
	}

}

