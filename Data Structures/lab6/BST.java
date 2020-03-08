package lab6;

public class BST <E extends Comparable<?super E>> {
	private Node<E> root;
	BST() {
		root = null;
	}
	Node<E> getRoot() { 
		return root; 
	}
	void inOrder() {
		System.out.print("in-order: ");
		inOrder(root);
		System.out.println();
	}
	void inOrder(Node<E>root) {
		if(root == null) return;
		inOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrder(root.getRight());
	}
	void preOrder() {
		System.out.print("pre-order: ");
		preOrder(root);
		System.out.println();
	}
	void preOrder(Node<E>root) {
		if(root == null) return;
		System.out.print(root.getData() + " ");
		if(root.hasLeft()) preOrder(root.getLeft());
		if(root.hasRight()) preOrder(root.getRight());
	}
	void insert(E data) {
		root = insert(root, data);
	}
	Node<E> insert(Node<E> root, E data) {
		if (root == null) {
			return new Node<E>(data);
		} else {
			Node<E> cur;
			if (root.getData().compareTo(data) > 0) {
				cur = insert(root.getLeft(), data);
				root.setLeft(cur);
			} else {
				cur = insert(root.getRight(), data);
				root.setRight(cur);
			}
			return root;
		}
	}
	//apply left rotate to the root node
	void rotateLeft() {
		Node newRoot = root.getRight();
		Node left = newRoot.getLeft();
		newRoot.setLeft(root);
		root.setRight(left);
		root = newRoot;
	}

	//apply right rotate to the root node
	void rotateRight() {
		Node newRoot = root.getLeft();
		Node right = newRoot.getRight();
		newRoot.setRight(root);
		root.setLeft(right);
		root = newRoot;
		
		
	}

}
