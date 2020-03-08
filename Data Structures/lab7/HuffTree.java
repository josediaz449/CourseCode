package lab7;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class HuffTree<Key, E> {
	private PriorityQueue<BinNode<Integer, String>> queue = new PriorityQueue<BinNode<Integer, String>>(); //for building the huffman tree
	private BinNode<Integer, String> root; //for traversal
	private Dictionary<String, String> codeTable; //huffman code table
	private Dictionary<String, Integer> codeFreq;
	public HuffTree(String letters, int[] weights) {
		init(letters, weights);
		buildTree();
		codeTable = new Hashtable<String, String>();
		getCode();		
		summary();
	}
	private void init(String letters, int[] weights) {
		codeFreq = new Hashtable<String, Integer>();
		for(int i = 0; i < letters.length(); i ++) 
			codeFreq.put(letters.substring(i, i + 1), weights[i]);
		for(int i = 0; i < letters.length(); i ++) {
			BinNode<Integer, String> node = new BinNode<Integer, String>(weights[i], letters.substring(i, i + 1));
			queue.add(node);
		}
	}
	private void buildTree() {
		while(queue.size() > 1) {
			BinNode<Integer, String> node1 = queue.remove(); 
			BinNode<Integer, String> node2 = queue.remove();
			BinNode<Integer, String> newnode = new BinNode<Integer, String>(node1.getKey() + node2.getKey(), " ");
			newnode.setLeft(node1);
			newnode.setRight(node2);
			queue.add(newnode);
			queue.toString();
		}
		root = queue.remove();
		System.out.println("root of the hufftree: weight " + root.getKey());
	}
	public void summary() {
		if(codeTable.isEmpty()) {
			System.out.println("codes not found");
			return;
		}
		//display the code & compute the sum of weighted path lengths
		Enumeration<String> keys = codeFreq.keys();
		int sumOfWeightedPath = 0;
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
		    System.out.println("Letter: " + key + " " + codeTable.get(key));
		    sumOfWeightedPath += codeTable.get(key).length() * codeFreq.get(key); 
		}
		System.out.println("Total letters: " + root.getKey());
		System.out.println("Sum of weighted path lengths: " + sumOfWeightedPath);
		System.out.println("Ave-Code-Length: " + sumOfWeightedPath * 1.0 / root.getKey());
	}
	//function 1: get the codes by walking in the tree
	//each leaf node is a letter, and the corresponding path is the code
	//for simplicity, the codes are represented using strings of "0" and "1", not bits
	private void getCode() {
		getCodeHelp(root, "");	
	}
	
	private void getCodeHelp(BinNode<Integer, String>entry, String incode) {
		if(entry == null) return;
		if(entry.getLeft() != null) {
			getCodeHelp(entry.getLeft(), incode + "0");
			getCodeHelp(entry.getRight(), incode + "1");
		}
		else {
			codeTable.put(entry.getValue(), incode);
		} 
	}

	//to-implement
	//function 2: encode a message
	public String encode(String instr) {
		String result = "";
		char[] array = instr.toCharArray();
		for( int i = 0; i<array.length;i++) {
			char a = array[i];
			result += codeTable.get(String.valueOf(array[i]));
		}
		return result;
	}
	
	//to-implement
	//function 3: decode a message
	public String decode(String coded) {
		String result = "";
		char[] array = coded.toCharArray();
		BinNode<Integer, String> cur = root;
		for( int i = 0; i<array.length;i++) {
			char a = array[i];
			if (a == '0') {
				cur = cur.getLeft();
			}
			else if (a == '1') {
				cur = cur.getRight();
			}
			if (cur.isLeaf()) {
				result+=cur.getValue();
				cur = root;
			}
			
		}
		return result;

	}
}
