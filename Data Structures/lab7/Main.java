package lab7;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokemon e = new Pokemon("a", 250);
		Pokemon d = new Pokemon("a", 520);
		Pokemon a = new Pokemon("a", 50);
		Pokemon c = new Pokemon("a", 150);
		Pokemon b = new Pokemon("a", 25);
		
		PriorityQueue<Pokemon> poke = new PriorityQueue<Pokemon>();
		poke.add(a);
		poke.add(b);
		poke.add(c);
		poke.add(d);
		poke.add(e);
		System.out.println(poke.poll().getPower());
		System.out.println(poke.poll().getPower());
		System.out.println(poke.poll().getPower());
		System.out.println(poke.poll().getPower());
		System.out.println(poke.poll().getPower());
	}

}
