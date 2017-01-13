package Controller;

import java.util.ArrayList;
import java.util.List;

import Core.Building;
import Core.Elevator;
import Core.Person;
import Core.Simulation;

/*
 * This class represents a VERY simple elevator controller.
 * This controller just controls one elevator out of the four, waiting for the elevator to happen to take in an occupant.
 * This controller only handles one occupant at a time, whatever occupant happened to walk into the elevator first.
 * Any time this elevator happens to move an occupant(who is not the one occupant we are currently handling) from one floor to another floor, it is completely coincidental.
 * This controller does not look at other elevators and does not plan at all.  This elevator controller is the worst one I could think of that actually moves people.
 */
public class SimpleController implements ElevatorController {
	
	
	
	@Override
	public void runElevator(Building building, List<Person> waitingPeople) {
		//	GET THE ELEVATOR
		Elevator elevator = building.getElevators()[0];
		
		Person current = null;
		for (Person occupant : elevator.getOccupants()) {
			//	GET THE OCCUPANT OF THE ELEVATOR
			if (occupant != null) {
				current = occupant;
				break;
			}
		}
		
		//	IF WE HAVE AT LEAST ONE OCCUPANT IN OUR ELEVATOR
		if (current != null) {
			//	NEED TO MOVE UP
			if (current.getDestination() > elevator.getFloor()) {
				try {
					elevator.goUp();
				} catch (Exception e) {
					//	ON THE 10TH FLOOR, CAN'T GO UP!
				}
			}
			//	NEED TO MOVE DOWN
			else if (current.getDestination() < elevator.getFloor()) {
				try {
					elevator.goDown();
				} catch (Exception e) {
					//	ON THE FIRST FLOOR, CAN'T GO DOWN!
				}
			}
		}
	}
	
	private int elevatorEff(Building b, List<Person> waitingPeople){
		List<Person> occupants = new ArrayList<Person>();
		Person target = null;
		Elevator ele = null;
		int x = 0;
		double eleEff0 = 0;
		double eleEff1 = 0;
		double eleEff2 = 0;
		double eleEff3 = 0;
		int eleLoc = 0;
		int dist = 0;
		int totalMovements = 0;
		int elePop = 0;
		
		if(Simulation.spawned == true && (b.getElevators()[0].getFree() == true || b.getElevators()[1].getFree() == true || b.getElevators()[2].getFree() == true || b.getElevators()[3].getFree() == true)){
			if(b.getElevators()[0].getFree() == true){
				ele = b.getElevators()[0];
				eleLoc = ele.getFloor();
				elePop = ele.getOccupants().size();
				while(target == null){
					if (waitingPeople.get(x) != null){
						target = waitingPeople.get(x);
					}
					else{
						x++;
					}
				}
				dist = Math.abs(eleLoc - target.getLocation());
				for(int i = Math.min(eleLoc, target.getLocation()) + 1; i <= Math.max(eleLoc, target.getLocation()); i++){
					for(int k = 0; k <= ele.getOccupants().size()-1; k++){
						if(ele.getOccupants().get(k).getDestination() == i){
							totalMovements++;
							elePop--;
						}
					}
					for(int k = 0; k <= waitingPeople.size()-1; k++){
						if(waitingPeople.get(k) != null){
							if(waitingPeople.get(k).getLocation()==i && elePop < 6){
								totalMovements++;
								elePop++;
							}
						}
					}
				}
				eleEff0 = totalMovements / dist;
				eleLoc = 0;
				dist = 0;
				totalMovements = 0;
				elePop = 0;
				target = null;
				ele = null;
				x = 0;
				
				
			}
			else if(b.getElevators()[1].getFree() == true){
				ele = b.getElevators()[1];
				eleLoc = ele.getFloor();
				elePop = ele.getOccupants().size();
				while(target == null){
					if (waitingPeople.get(x) != null){
						target = waitingPeople.get(x);
					}
					else{
						x++;
					}
				}
				dist = Math.abs(eleLoc - target.getLocation());
				for(int i = Math.min(eleLoc, target.getLocation()) + 1; i <= Math.max(eleLoc, target.getLocation()); i++){
					for(int k = 0; k <= ele.getOccupants().size()-1; k++){
						if(ele.getOccupants().get(k).getDestination() == i){
							totalMovements++;
							elePop--;
						}
					}
					for(int k = 0; k <= waitingPeople.size()-1; k++){
						if(waitingPeople.get(k) != null){
							if(waitingPeople.get(k).getLocation()==i && elePop < 6){
								totalMovements++;
								elePop++;
							}
						}
					}
				}
				eleEff1 = totalMovements / dist;
				eleLoc = 0;
				dist = 0;
				totalMovements = 0;
				elePop = 0;
				target = null;
				ele = null;
				x = 0;
			}
			else if(b.getElevators()[2].getFree() == true){
				ele = b.getElevators()[2];
				eleLoc = ele.getFloor();
				elePop = ele.getOccupants().size();
				while(target == null){
					if (waitingPeople.get(x) != null){
						target = waitingPeople.get(x);
					}
					else{
						x++;
					}
				}
				dist = Math.abs(eleLoc - target.getLocation());
				for(int i = Math.min(eleLoc, target.getLocation()) + 1; i <= Math.max(eleLoc, target.getLocation()); i++){
					for(int k = 0; k <= ele.getOccupants().size()-1; k++){
						if(ele.getOccupants().get(k).getDestination() == i){
							totalMovements++;
							elePop--;
						}
					}
					for(int k = 0; k <= waitingPeople.size()-1; k++){
						if(waitingPeople.get(k) != null){
							if(waitingPeople.get(k).getLocation()==i && elePop < 6){
								totalMovements++;
								elePop++;
							}
						}
					}
				}
				eleEff2 = totalMovements / dist;
				eleLoc = 0;
				dist = 0;
				totalMovements = 0;
				elePop = 0;
				target = null;
				ele = null;
				x = 0;
			}
			else if(b.getElevators()[3].getFree() == true){
				ele = b.getElevators()[3];
				eleLoc = ele.getFloor();
				elePop = ele.getOccupants().size();
				while(target == null){
					if (waitingPeople.get(x) != null){
						target = waitingPeople.get(x);
					}
					else{
						x++;
					}
				}
				dist = Math.abs(eleLoc - target.getLocation());
				for(int i = Math.min(eleLoc, target.getLocation()) + 1; i <= Math.max(eleLoc, target.getLocation()); i++){
					for(int k = 0; k <= ele.getOccupants().size()-1; k++){
						if(ele.getOccupants().get(k).getDestination() == i){
							totalMovements++;
							elePop--;
						}
					}
					for(int k = 0; k <= waitingPeople.size()-1; k++){
						if(waitingPeople.get(k) != null){
							if(waitingPeople.get(k).getLocation()==i && elePop < 6){
								totalMovements++;
								elePop++;
							}
						}
					}
				}
				eleEff3 = totalMovements / dist;
				eleLoc = 0;
				dist = 0;
				totalMovements = 0;
				elePop = 0;
				target = null;
				ele = null;
				x = 0;
			}
		} 
		else {
			return -1;
		}
		return 0;
	}

}
