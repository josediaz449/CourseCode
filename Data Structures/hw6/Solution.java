package hw6;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		if(in.next()==("int")) {
			AVL<Integer> tree = new AVL<Integer>();
			for(int i = 0; i < n; i ++) {
				tree.insert(in.nextInt());
			}
			System.out.println("root="+tree.getRoot().getData()+" height="+tree.subtreeHeight(tree.getRoot())+" heightfactor="+tree.heightFactor(tree.getRoot()));
		}
		else {
			AVL<String> tree = new AVL<String>();
			for(int i = 0; i < n; i ++) {
				tree.insert(in.next());
			}
			System.out.println("root="+tree.getRoot().getData()+" height="+tree.subtreeHeight(tree.getRoot())+" heightfactor="+tree.heightFactor(tree.getRoot()));
			//System.out.println(tree.heightFactor(tree.getRoot().getRight()));
			tree.inOrder();
		}
		in.close();
	}

}
