package lab7;

import java.util.Scanner;

public class HuffmanMain {
	public static void main(String[] argv) {
		int[] weights = {2, 7, 24, 32, 37, 42, 42, 120};
		String letters = "ZKMCUDLE";
		Scanner in = new Scanner(System.in);
		//String letters = in.next();
		
		HuffTree<Integer, String> tree = new HuffTree<Integer, String>(letters, weights);
		int test = in.nextInt();
		for(int i = 0; i < test; i ++) {
			String what = in.next();
			String instr = in.next();
			if(what.compareTo("encode") == 0) {
				System.out.println("encode " + instr + " " + tree.encode(instr));
			}
			else if(what.compareTo("decode") == 0) {
				System.out.println("decode " + instr + " " + tree.decode(instr));
			}
		}
	}
}
