
public enum Rank {

	CEO(0),COO(1),DIRECTOR(2),MANAGER(3);
	
	private int rank;
	
	Rank(int rank){
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}
}
