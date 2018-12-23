import java.util.ArrayList;
import java.util.Date;

public class Main {
	
	public static void main(String[] args){
		
		ArrayList<Meeting> meetings = new ArrayList<>();
		Employee e1 = new Employee(1, "Amit", Rank.DIRECTOR);
		Employee e2 = new Employee(2, "Nitish", Rank.MANAGER);
		Employee e3 = new Employee(3, "Kanhaiya", Rank.COO);
		Employee e4 = new Employee(4, "Iravati", Rank.MANAGER);
		Employee e5 = new Employee(5, "John", Rank.DIRECTOR);
		
		Meeting m1 = new Meeting("Scrum", new Date(2018,10, 27, 10, 15), new Date(2018,10, 27, 12, 0), 7, e2);
		Meeting m2 = new Meeting("Scrum", new Date(2018,10, 27, 10, 15), new Date(2018,10, 27, 12, 0), 4, e3);
		Meeting m3 = new Meeting("Scrum", new Date(2018,10, 27, 10, 15), new Date(2018,10, 27, 12, 0), 6, e4);
		Meeting m4 = new Meeting("Scrum", new Date(2018,10, 27, 10, 15), new Date(2018,10, 27, 12, 0), 6, e1);
		Meeting m5 = new Meeting("Scrum", new Date(2018,10, 27, 10, 15), new Date(2018,10, 27, 12, 0), 4, e5);
		
	}

}
