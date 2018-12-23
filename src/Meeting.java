import java.util.Date;

public class Meeting {
	
	private String title;
	private Date startTime;
	private Date endTime;
	private int numberOfAttendees;
	private Employee organizer;
	
	public Meeting(String title, Date startTime, Date endTime, 
			int numberOfAttendees, Employee organizer){
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.numberOfAttendees = numberOfAttendees;
		this.organizer = organizer;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getNumberOfAttendees() {
		return numberOfAttendees;
	}
	public void setNumberOfAttendees(int numberOfAttendees) {
		this.numberOfAttendees = numberOfAttendees;
	}
	public Employee getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Employee organizer) {
		this.organizer = organizer;
	}

}
