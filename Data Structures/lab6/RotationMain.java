package lab6;

import java.util.Scanner;

public class RotationMain {
	public static void main(String[] argv) {
		int n;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		BST<Integer> tree = new BST<Integer>();
		for(int i = 0; i < n; i ++) {
			tree.insert(in.nextInt());
		}
		in.close();
		//if BST is correctly built, items will be displayed in sorted order using
		//in-order traversal
		tree.inOrder();
		
		System.out.println("before rotation: ");
		tree.preOrder();
		
		System.out.println("after rotating left: ");
		tree.rotateLeft();
		tree.preOrder();	
		
		System.out.println("after rotating right: ");
		tree.rotateRight();
		tree.preOrder();
	}

}
