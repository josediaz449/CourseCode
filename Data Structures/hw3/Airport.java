package hw3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Airport {

	public static void main(String[] args) {
		//timer
		int timePassed= 0;
		//completions
		int takeOffsCompleted=0;
		int landingsCompleted=0;
		//plane numbers
		int planeT = 1;
		int planeL = 1;
		//queues
		Queue<String> takeOff = new LinkedList<String>();
		Queue<String> land = new LinkedList<String>();
		Queue<String> runway1 = new LinkedList<String>();
		Queue<String> runway2 = new LinkedList<String>();
		//timer for how long a plane is on runways
		int runwayTimer1 = 0;
		int runwayTimer2 = 0;
		//says if runways are empty or not
		boolean occupied1 =false;
		boolean occupied2 = false;
		//keeps track of number of planes taken out of each queue
		int tDequeued= 1;
		int lDequeued= 1;	
		//time queues are not empty
		int landQ=0;
		int takeoffQ=0;
		
		//Simulation of 120 minutes
		while(timePassed<=120) {
			//gives random number for requests 1=takeOff request 2=land request 0=no requests
			Random rnd = new Random();
			int randNum = rnd.nextInt(3);
			//what happens if you get 1
			if(randNum == 1) {
				String t = "T"+planeT;
				if(occupied1 == false) {
					runway1.add(t);
					occupied1 = true;
				}
				else if(occupied2 == false) {
					runway2.add(t);
					occupied2 = true;
				}
				else {
					takeOff.add(t);
				}
				planeT+=1;
			}
			//what happens if you get 2
			else if(randNum == 2) {
				String l = "L"+planeL;
				if(occupied1 == false) {
					runway1.add(l);
					occupied1 = true;
				}
				else if(occupied2 == false) {
					runway2.add(l);
					occupied2 = true;
				}
				else {
					land.add(l);
				}
				planeL+=1;
			}
			//if you get 0
			else {
				//nothing happens
			}
			//checks if runway1 is occupied and adds 5 minutes each time if it is
			if(occupied1 == true) {
				runwayTimer1+=5;
			}
			//checks if runway2 is occupied and adds 5 minutes each time if it is
			if(occupied2 == true) {
				runwayTimer2+=5;
			}
			//once 15 minutes is reached on runway1, it is set to unoccupied and adds queued planes to runway1
			if(runwayTimer1==15) {
				String planeC = runway1.remove();
				if(planeC.contains("T")) {
					takeOffsCompleted+=1;
				}
				else if(planeC.contains("L")) {
					landingsCompleted+=1;
				}
				occupied1 = false;
				runwayTimer1=0;
				if(!land.isEmpty()) {
					runway1.add(land.remove());
					lDequeued+=1;
					occupied1 = true;
				}
				else if(!takeOff.isEmpty()) {
					runway1.add(takeOff.remove());
					tDequeued+=1;
					occupied1 = true;
				}
			}
			//once 15 minutes is reached on runway2, it is set to unoccupied and adds queued planes to runway2
			if(runwayTimer2==15) {
				String planeC = runway2.remove();
				if(planeC.contains("T")) {
					takeOffsCompleted+=1;
				}
				else if(planeC.contains("L")) {
					landingsCompleted+=1;
				}
				occupied2 = false;
				runwayTimer2=0;
				if(!land.isEmpty()) {
					runway2.add(land.remove());
					lDequeued+=1;
					occupied2 = true;
				}
				else if(!takeOff.isEmpty()) {
					runway2.add(takeOff.remove());
					tDequeued+=1;
					occupied2 = true;
				}
			}
			//adds 5 minutes to timer simulation
			timePassed+=5;
			//adds time to queues if not empty
			if(!takeOff.isEmpty()) {
				takeoffQ+=5;
			}
			if(!land.isEmpty()) {
				landQ+=5;
			}
			//System.out.println("takeOff: "+takeOff.toString());
			//System.out.println("landing: "+land.toString());
			//System.out.println("Runway1: "+runway1.toString());
			//System.out.println("Runway2: "+runway2.toString());		
		} 
		//avg time in queues
		int avgT =takeoffQ/tDequeued;
		int avgL= landQ/lDequeued;
		System.out.println("Takoffs queue: "+takeOff.toString());
		System.out.println("Landings queue: "+land.toString());
		System.out.println("landings completed: "+landingsCompleted);
		System.out.println("takeOffs Completed: "+takeOffsCompleted);
		System.out.println("Average time in landing queue: "+avgL);
		System.out.println("Average time in takeoff queue: "+avgT);
		
		
	}

}
