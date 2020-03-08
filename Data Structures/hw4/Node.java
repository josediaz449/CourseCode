package hw4;

public class Node {
	
	private Node left;
	private Node right;
	private int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	void setData(int d) {
		data = d;
	}

	int getData() {
		return data;
	}

	void setLeft(Node i) {
		left = i;
	}

	void setRight(Node i) {
		right = i;
	}

	Node getLeft() {
		return left;
	}

	Node getRight() {
		return right;
	}

}
