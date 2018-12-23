import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class CalendarAssistant {
	
	public ArrayList<Meeting> removeConflicts(ArrayList<Meeting> meetings, 
			Employee employee){
		ArrayList<Meeting> filteredMeetings = new ArrayList<>(meetings);
		ArrayList<Meeting> ans = new ArrayList<>();
		HashMap<Meeting, Boolean> attend = new HashMap<>();
		for(Meeting m : meetings){
			attend.put(m, true);
		}
		
		meetings.sort(new Comparator<Meeting>(){
			@Override
			public int compare(Meeting m1, Meeting m2){
				if(m1.getStartTime().equals(m2.getStartTime())){
					return m1.getEndTime().compareTo(m2.getEndTime());
				}
				return m1.getStartTime().compareTo(m2.getStartTime());
			}
		});
		
		int n = meetings.size();
		
		for(int i=0; i < n; i++){
			Meeting m1 = filteredMeetings.get(i);
			
			for(int j=i+1; j < n;j++){
				Meeting m2 = filteredMeetings.get(j);
				
				if(conflict(m1, m2)){
					if(sameOrganizer(m1, employee)){
						if(sameOrganizer(m2, employee)){
							compareRanks(m1, m2, employee, attend);
						}else{
							attend.put(m1, true);
							attend.put(m2, false);
						}
						
					}else{
						if(sameOrganizer(m2, employee)){
							attend.put(m2, true);
							attend.put(m1, false);
						}
					}
				}
				
			}
		}
		
		for(Meeting m: filteredMeetings){
			if(attend.get(m)){
				ans.add(m);
			}
		}
		
		return ans;
	}
	
	boolean conflict(Meeting m1, Meeting m2){
		if(m1.getStartTime().equals(m2.getStartTime())||
				m1.getEndTime().equals(m2.getEndTime())){
			return true;
		}else if(m1.getStartTime().after(m2.getStartTime()) &&
				m1.getStartTime().before(m2.getEndTime())){
			return true;
		}else if(m1.getEndTime().before(m2.getEndTime()) && 
				m1.getEndTime().after(m2.getStartTime())){
			return true;
		}else{
			return false;
		}
		
		
	}
	
	boolean sameOrganizer(Meeting m, Employee e){
		if(m.getOrganizer().getId() == e.getId()){
			return true;
		}
		return false;
	}
	
	public void compareRanks(Meeting m1, Meeting m2, Employee e, HashMap<Meeting, Boolean> attend){
		
		int m1e = compareRanks(m1, e);
		int m2e = compareRanks(m2, e);
		
		if(m1e < 0 && m2e >= 0){
			attend.put(m1, true);
			attend.put(m2, false);
		}else if(m2e < 0 && m1e >= 0){
			attend.put(m2, true);
			attend.put(m1, false);
		}else if(m1e < m2e){
			attend.put(m1, true);
			attend.put(m2, false);
		}else if(m2e < m1e){
			attend.put(m1, false);
			attend.put(m2, true);
		}else{
			if(m1.getNumberOfAttendees() > m2.getNumberOfAttendees()){
				attend.put(m1, false);
				attend.put(m2, true);
			}else{
				attend.put(m1, true);
				attend.put(m2, false);
			}
		}
		
	}
	
	private int compareRanks(Meeting m1, Employee e){
		return m1.getOrganizer().getRank().getRank() - e.getRank().getRank();
	}
	
}
