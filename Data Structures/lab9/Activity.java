package lab9;

public class Activity implements Comparable<Activity>{
	private String name;
	private double start;
	private double finish;
	public Activity(String name, double start, double finish) {
		this.name = name;
		this.start = start;
		this.finish = finish;
	}
	public String getName() {
		return this.name;
	}
	public double getStart() {
		return this.start;
	}
	public double getFinish() {
		return this.finish;
	}

	@Override
	public int compareTo(Activity other) {
		// TODO Auto-generated method stub
		if(this.getFinish()>other.getFinish()) {
			return 1;
		}
		else if(this.getFinish()<other.getFinish()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	public String toString() {
		return this.name+" "+this.start+" "+this.finish;
		
	}
	

}
