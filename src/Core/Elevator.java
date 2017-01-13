package Core;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
	private int floor = 1;
	List<Person> occupants = new ArrayList<Person>();
	private boolean moved = false;
	boolean free = true;
	
	public boolean getFree(){
		return free;
	}
	
	public void setFree(boolean f){
		free = f;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public void resetMove() {
		moved = false;
	}
	
	public void goUp() throws Exception {
		if (!moved) {
			//	There are ten floors in a building
			if (floor >= 10)
				throw new Exception("CAN'T GO UP - ALREADY ON FLOOR 10!");
			floor++;
			for (Person person : occupants) {
				person.setLocation(floor);
			}
			moved = true;
		}
	}
	
	public void goDown() throws Exception {
		if (!moved) {
			//	And no basement
			if (floor <= 1)
				throw new Exception("CAN'T GO DOWN - ALREADY ON FLOOR 1!");
			floor--;
			for (Person person : occupants) {
				person.setLocation(floor);
			}
			moved = true;
		}
	}
	
	public void addOccupant(Person person) throws Exception {
		//	There are up to 6 occupants in an elevator
		if (occupants.size() >= 6) {
			throw new Exception("ELEVATOR FULL!");
		}
		occupants.add(person);
	}
	
	public List<Person> getOccupants() {
		return occupants;
	}
	
	//	OCCUPANTS WILL AUTOMATICALLY GET OFF ON THE CORRECT FLOOR
	public void removeOccupant(Person person) {
		occupants.remove(person);
	}
	
	public String toString() {
		return "{FLOOR:" + floor + ", OCCUPANTS:" + occupants + "}";
	}
}
