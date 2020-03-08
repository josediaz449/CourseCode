package hw6;

public class Node<E> {

	private Node<E> left;
    private Node<E> right;
    private E data;

	public Node(E data) {
		this.data = data;
		left = null;
		right = null;
	}

	void setData(E d) {
		data = d;
	}

	E getData() {
		return data;
	}

	void setLeft(Node<E> i) {
		left = i;
	}

	void setRight(Node<E> i) {
		right = i;
	}

	Boolean hasLeft() {
		return left != null;
	}
	
	Node<E> getLeft() {
		return left;
	}

	Boolean hasRight() {
		return right != null;
	}
	Node<E> getRight() {
		return right;
	}
}
