package lab1;

import java.util.Random;
import java.util.Scanner;

public class RandomDNA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		String[] dna = {"A", "T","C","G"};
		Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for(int i = 0; i<a;i++) {
        	Random rnd = new Random();
        	int t = rnd.nextInt(4);
        	s = s+" "+dna[t];
        }
        System.out.println(s);
	}

}
