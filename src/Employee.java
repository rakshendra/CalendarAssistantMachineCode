public class Employee {
	private int id;
	private String name;
	private Rank rank;
	
	public Employee(int id, String name, Rank rank){
		this.id = id;
		this.name = name;
		this.rank = rank;
	}
	
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
