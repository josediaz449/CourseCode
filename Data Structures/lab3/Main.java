package lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		//queue
		Scanner in = new Scanner(System.in);
		int timePassed= 0;
		int n = in.nextInt();
		int q = in.nextInt();
		Queue<Integer> process = new LinkedList<Integer>();
		Queue<String> name = new LinkedList<String>();
		ArrayList<String> nameRt = new ArrayList<String>();
		ArrayList<Integer> processRt = new ArrayList<Integer>();
		for(int i = 0;i<n;i++) {
			name.add(in.next());
			process.add(in.nextInt());
		}
		while(!process.isEmpty()) {
			int number = process.remove();
			String nme = name.remove();
			if(number-q<=0) {
				processRt.add(number+timePassed);
				nameRt.add(nme);
				timePassed+=number;
			}
			else {
				process.add(number-q);
				name.add(nme);
				timePassed+=q;
			}
			
		}
		for(int i =0; i<n;i++) {
			System.out.println(nameRt.get(i)+" "+processRt.get(i));
		}
		//System.out.println(process.toString());
		//System.out.println(name.toString());
		
		/**
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>(); 
		Scanner in = new Scanner(System.in);
		String stringIn = in.nextLine();
		String[] lineString = stringIn.split(" ");
		for(int i = 0; i<lineString.length;i++) {
			if(lineString[i].equals("*")) {
				int n = stack.pop()*stack.pop();
				stack.push(n);
			}
			else if(lineString[i].equals("+")) {
				int n = stack.pop()+stack.pop();
				stack.push(n);
			}
			else if(lineString[i].equals("-")) {
				int n1 = stack.pop();
				int n2 = stack.pop();
				int n = n2-n1;
				stack.push(n);
			}
			else {
			stack.push(Integer.parseInt(lineString[i]));	
			} 
			//System.out.println(stack.toString());
			
		}
		result = stack.pop();
		System.out.println(result);
		*/
	}

}
