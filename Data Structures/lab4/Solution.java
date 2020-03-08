package lab4;

import java.util.LinkedList;
import java.util.Scanner;

import javafx.util.Pair;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String DNA = in.next();
        int occupied =0;
        LinkedList[] hashT = new LinkedList[(int) Math.pow(4,k)];
        for(int i=0; i<DNA.length()-n+1;i++) {
        	int pos =0;
        	String sub = DNA.substring(i, i+n);
        	int index = i;
        	String ref = "AGCT";
        	//System.out.println(sub);
        	for(int j = 0;j<k;j++) {
        		if(sub.charAt(j)==ref.charAt(0)) {
        			pos +=1*Math.pow(4,j);
        		}
        		if(sub.charAt(j)==ref.charAt(1)) {
        			pos +=0*Math.pow(4,j);
        		}
        		if(sub.charAt(j)==ref.charAt(2)) {
        			pos +=2*Math.pow(4,j);
        		}
        		if(sub.charAt(j)==ref.charAt(3)) {
        			pos +=3*Math.pow(4,j);
        		}
        	}
        	Pair p = new Pair(sub,index);
        	if(hashT[pos]==null) {
        		occupied+=1;
        		LinkedList<Pair> list = new LinkedList<Pair>();
        		hashT[pos] =list;
            	hashT[pos].add(p);
        	}
        	else {
        		hashT[pos].add(p);
        	}
        	//System.out.println(pos);
        }
        System.out.print(hashT.length);	
        System.out.print(" "+occupied);
	}


}
