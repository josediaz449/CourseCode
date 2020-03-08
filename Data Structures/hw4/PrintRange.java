package hw4;

import java.util.Scanner;

public class PrintRange {
	
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data < root.getData()) {
				cur = insert(root.getLeft(), data);
				root.setLeft(cur);
			} else {
				cur = insert(root.getRight(), data);
				root.setRight(cur);
			}
			return root;
		}
	}

	//implement printRange() function
	public static void printRange(Node root, int low, int high) {
		if(root==null){
        }
		else {
			if(root.getData()>=low) {
			printRange(root.getLeft(), low, high);
			}
			if(root.getData()>=low&&root.getData()<=high) {
			System.out.print(root.getData()+" ");
			}
			if(root.getData()<=high) {
			printRange(root.getRight(), low, high);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		int low = scan.nextInt();
		int high = scan.nextInt();
		scan.close();
		printRange(root, low, high);
	}

}
