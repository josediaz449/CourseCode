package projects;

public class DNA {
	private String name;
	private String sequence;
	
	public DNA(String name, String sequence) {
		this.name = name;
		this.sequence = sequence;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSequence() {
		return this.sequence;
	}
	public void editName(String name) {
		this.name=name;
	}
	public void editSequence(String sequence) {
		this.sequence=sequence;
	}

}
