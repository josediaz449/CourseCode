package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class DNAMain {

	public static ArrayList<DNA> dnas = new ArrayList<DNA>(); //holds DNAs from the small data set (small.txt)
	public static ArrayList<DNA> dnasMedian = new ArrayList<DNA>(); //holds DNAs from the median data set (median.txt)
	public static ArrayList<Integer> lcsDNA = new ArrayList<Integer>(); //holds data for longest common subsequences
	public static ArrayList<Integer> editDistanceDNA = new ArrayList<Integer>(); //holds data for edit distance
	public static ArrayList<Integer> lcsDNAMedian = new ArrayList<Integer>(); //holds data for longest common subsequences (median data)
	public static ArrayList<Integer> editDistanceDNAMedian = new ArrayList<Integer>();//holds data for edit distance (median data)
	
	public static int computeDistance(String s1, String s2) //computes smallest edit distance
	{
		int[][] d = new int[s1.length()+1][s2.length()+1];
		for(int i = 1; i <= s1.length(); i ++)  {
	        for(int j = 1; j <= s2.length(); j ++) {
	                if(s1.charAt(i-1) == s2.charAt(j-1)) {
	                	d[i][j] = d[i-1][j-1];
	                }
	                else {
	                	d[i][j]= Math.min(d[i-1][j] + 1, d[i][j-1] + 1);
	                }
	        }
		}
		return d[s1.length()][s2.length()];
	}
	public static int lcs(String s1, String s2) //computes longest common subsequence
	{
		int[][] array = new int[s1.length()+1][s2.length()+1];
		for(int i = 1; i <= s1.length(); i ++)  {
		        for(int j = 1; j <= s2.length(); j ++) {
		                if(s1.charAt(i-1)==s2.charAt(j-1)) {
		                	array[i][j]= array[i-1][j-1]+1;
		                }
		                else {
		                	if(array[i-1][j]>array[i][j-1]) {
		                		array[i][j]= array[i-1][j];
		                	}
		                	else {
		                		array[i][j]= array[i][j-1];
		                	}
		                }
		        }
		}
		return array[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String dnaSeq ="";
		File small = new File("C:\\Users\\josed\\OneDrive\\Desktop\\C343\\C343josediaz\\C343josediaz\\src\\projects\\small.txt");//small data 		
		Scanner in = new Scanner(small);//scanner for small data
		while(in.hasNext()) //creates DNA types and adds them to ArrayList
		{
			DNA dna;
			String inString = in.nextLine();
			if(inString.contains(">")) {
				if(dnas.size()>0) {
					dnas.get(dnas.size()-1).editSequence(dnaSeq);
				}
				dna = new DNA(inString, "");
				dnas.add(dna);
				dnaSeq = "";
			}
			else {
				dnaSeq += inString;
				 
			}			
		}
		dnas.get(dnas.size()-1).editSequence(dnaSeq);
		in.close();

		for(int i = 0; i<dnas.size()-1;i++) //computes lcs and edit distance, adds it to ArrayLists (small data)
		{
			editDistanceDNA.add(computeDistance(dnas.get(i).getSequence(),dnas.get(i+1).getSequence()));
			lcsDNA.add(lcs(dnas.get(i).getSequence(),dnas.get(i+1).getSequence()));
		}

		//writes results to a file named "small-data-results.txt" (small data)
		PrintWriter writer = new PrintWriter("small-data-results.txt", "UTF-8");
		for(int i = 0; i<lcsDNA.size();i++) {
			writer.println(lcsDNA.get(i)+","+editDistanceDNA.get(i));
		}
		writer.close();
		
		/** same code for median data set */
		dnaSeq =  "";
		File median = new File("C:\\Users\\josed\\OneDrive\\Desktop\\C343\\C343josediaz\\C343josediaz\\src\\projects\\median.txt");//median data
		Scanner inM = new Scanner(median);//scanner for median data
		while(inM.hasNext()) //creates DNA types and adds them to ArrayList for median data 
		{
			DNA dna;
			String inString = inM.nextLine();
			if(inString.contains(">")) {
				if(dnasMedian.size()>0) {
					dnasMedian.get(dnasMedian.size()-1).editSequence(dnaSeq);
				}
				dna = new DNA(inString, "");
				dnasMedian.add(dna);
				dnaSeq = "";
			}
			else {
				dnaSeq += inString;
				 
			}			
		}
		dnasMedian.get(dnasMedian.size()-1).editSequence(dnaSeq);
		inM.close();
		
		for(int i = 0; i<dnasMedian.size()-1;i++) //computes lcs and edit distance, adds it to ArrayLists (median data)
		{
			editDistanceDNAMedian.add(computeDistance(dnasMedian.get(i).getSequence(),dnasMedian.get(i+1).getSequence()));
			lcsDNAMedian.add(lcs(dnasMedian.get(i).getSequence(),dnasMedian.get(i+1).getSequence()));
		}

		//writes results to a file named "median-data-results.txt" (median data)
		PrintWriter writerMedian = new PrintWriter("median-data-results.txt", "UTF-8");
		for(int i = 0; i<lcsDNAMedian.size();i++) {
			writerMedian.println(lcsDNAMedian.get(i)+","+editDistanceDNAMedian.get(i));
		}
		writerMedian.close();

	}

}
