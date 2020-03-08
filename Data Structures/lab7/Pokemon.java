package lab7;

public class Pokemon implements Comparable<Pokemon>{
	
	private String name;
	private int power;
	public Pokemon(String name, int power) {
		this.name = name;
		this.power = power;
	}
	public String getName() {
		return this.name;
	}
	public int getPower() {
		return this.power;
	}
	@Override 
	public int compareTo(Pokemon other) {
		if(this.getPower()>other.getPower()) {
			return 1;
		}
		else if(this.getPower()<other.getPower()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
