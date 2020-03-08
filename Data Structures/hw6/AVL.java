package hw6;

public class AVL<E extends Comparable<? super E>> {

	private Node<E> root;
    AVL() {
        root = null;
    }
    Node<E> getRoot() { 
		return root; 
	}
    int subtreeHeight(Node<E> node) {
    	 if (node == null) 
             return 0; 
         else 
         { 
             int l = subtreeHeight(node.getLeft()); 
             int r = subtreeHeight(node.getRight()); 
             if (l > r) 
                 return (l + 1); 
              else 
                 return (r + 1); 
         } 
    }
    int heightFactor(Node<E> node) {
    	int heightFactor = subtreeHeight(node.getLeft())-subtreeHeight(node.getRight());	
    	return heightFactor;
    			
    }
    /*
    void balance() {
    	if(heightFactor(root)==-2) {
    		if(heightFactor(root.getRight())==1) {
				rotateRight();
			}
			else if(heightFactor(root.getRight())<=-1) {
				rotateLeft();
			}
    	}
    	else if(heightFactor(root)==2) {
			if(heightFactor(root.getLeft())==-1) {
				rotateLeft();
			}
			else if(heightFactor(root.getLeft())==1) {
				rotateRight();
			}
		}
    }
    */
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
			if (heightFactor(root) > 1 && data.compareTo(root.getLeft().getData())<0) 
	            return rotateRight(root); 
	  
	        // Right Right Case 
	        if (heightFactor(root) < -1 && data.compareTo(root.getRight().getData()) >0) 
	            return rotateLeft(root); 
	  
	        // Left Right Case 
	        if (heightFactor(root) > 1 && data.compareTo(root.getLeft().getData()) >0) { 
	            root.setLeft(rotateLeft(root.getLeft())); 
	            return rotateRight(root); 
	        } 
	  
	        // Right Left Case 
	        if (heightFactor(root) < -1 && data.compareTo(root.getRight().getData()) <0) { 
	            root.setRight(rotateRight(root.getRight())); 
	            return rotateLeft(root); 
	        } 
			return root;
		}
	}
	Node<E> rotateLeft(Node<E> root) {
		Node<E> newRoot = root.getRight();
		Node<E> left = newRoot.getLeft();
		newRoot.setLeft(root);
		root.setRight(left);
		root = newRoot;
		return root;
	}
	Node<E> rotateRight(Node<E> root) {
		Node<E> newRoot = root.getLeft();
		Node<E> right = newRoot.getRight();
		newRoot.setRight(root);
		root.setLeft(right);
		root = newRoot;
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
}
